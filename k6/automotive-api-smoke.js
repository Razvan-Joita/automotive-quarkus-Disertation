import http from 'k6/http';
import { check, group, sleep } from 'k6';
import { Trend, Rate } from 'k6/metrics';
import encoding from 'k6/encoding';

const BASE_URL = (__ENV.BASE_URL || 'http://localhost:8081').replace(/\/$/, '');
const USERNAME = __ENV.USERNAME || __ENV.BASIC_AUTH_USER || 'admin';
const PASSWORD = __ENV.PASSWORD || __ENV.BASIC_AUTH_PASSWORD || 'admin123';
const THINK_TIME_SECONDS = Number(__ENV.THINK_TIME_SECONDS || '1');
const authHeader = `Basic ${encoding.b64encode(`${USERNAME}:${PASSWORD}`)}`;

export const options = {
  scenarios: {
    automotive_api_smoke: {
      executor: 'ramping-vus',
      stages: [
        { duration: __ENV.RAMP_UP || '30s', target: Number(__ENV.VUS || '10') },
        { duration: __ENV.STEADY_STATE || '1m', target: Number(__ENV.VUS || '10') },
        { duration: __ENV.RAMP_DOWN || '30s', target: 0 },
      ],
      gracefulRampDown: '15s',
    },
  },
  thresholds: {
    http_req_failed: ['rate<0.05'],
    http_req_duration: ['p(95)<750', 'p(99)<1500'],
    checks: ['rate>0.95'],
  },
  summaryTrendStats: ['avg', 'min', 'med', 'p(90)', 'p(95)', 'p(99)', 'max'],
};

const endpoints = [
  '/q/health',
  '/q/metrics',
  '/api/v1/customers',
  '/api/v1/dealerships',
  '/api/v1/manufacturers',
  '/api/v1/vehicles',
  '/api/v1/employees',
  '/api/v1/parts',
  '/api/v1/service-records',
  '/api/v1/appointments',
  '/api/v1/invoices',
  '/api/v1/warranties',
  '/api/v1/users',
];

const apiLatency = new Trend('automotive_api_latency', true);
const apiSuccess = new Rate('automotive_api_success');

function paramsFor(path) {
  const headers = {};

  if (path === '/q/metrics') {
    headers.Accept = 'text/plain';
  } else {
    headers.Accept = 'application/json';
  }

  if (path.startsWith('/api/')) {
    headers.Authorization = authHeader;
  }

  return { headers, tags: { endpoint: path } };
}

export default function () {
  group('read automotive API endpoints', () => {
    for (const endpoint of endpoints) {
      const response = http.get(`${BASE_URL}${endpoint}`, paramsFor(endpoint));
      const ok = check(response, {
        [`${endpoint} status is 2xx`]: (r) => r.status >= 200 && r.status < 300,
        [`${endpoint} returns content`]: (r) => r.body && r.body.length > 0,
      });
      apiLatency.add(response.timings.duration, { endpoint });
      apiSuccess.add(ok, { endpoint });
      sleep(THINK_TIME_SECONDS);
    }
  });
}

export function handleSummary(data) {
  return {
    'stdout': textSummary(data),
    '/scripts/results/automotive-api-summary.json': JSON.stringify(data, null, 2),
  };
}

function textSummary(data) {
  const p95 = data.metrics.http_req_duration?.percentiles?.['95'] || 0;
  const failed = data.metrics.http_req_failed?.rate || 0;
  const checks = data.metrics.checks?.rate || 0;
  return [
    'Automotive Quarkus API k6 summary',
    `Target: ${BASE_URL}`,
    `p95 response time: ${p95.toFixed(2)} ms`,
    `HTTP failure rate: ${(failed * 100).toFixed(2)}%`,
    `Check pass rate: ${(checks * 100).toFixed(2)}%`,
    '',
  ].join('\n');
}
