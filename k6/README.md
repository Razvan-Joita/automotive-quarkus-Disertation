# k6 performance tests

This folder contains k6 tests for the Automotive Quarkus REST API.

## Test file

- `automotive-api-smoke.js` checks the public Quarkus health/metrics endpoints and the authenticated `/api/v1/*` read endpoints.
- Default target: `http://localhost:8081`
- Default Basic Auth: `admin/admin123`

## Run locally

Start the application first:

```bash
docker compose up --build -d
```

Run k6 with Docker:

```bash
docker run --rm \
  --network host \
  -e BASE_URL=http://localhost:8081 \
  -e BASIC_AUTH_USER=admin \
  -e BASIC_AUTH_PASSWORD=admin123 \
  -v "$PWD:/work" \
  -w /work \
  grafana/k6:latest run k6/automotive-api-smoke.js
```

On Windows or Docker Desktop, replace `--network host` with the published host URL:

```bash
docker run --rm \
  -e BASE_URL=http://host.docker.internal:8081 \
  -e BASIC_AUTH_USER=admin \
  -e BASIC_AUTH_PASSWORD=admin123 \
  -v "%cd%:/work" \
  -w /work \
  grafana/k6:latest run k6/automotive-api-smoke.js
```

Or install k6 locally and run:

```bash
BASE_URL=http://localhost:8081 k6 run k6/automotive-api-smoke.js
```

## Useful environment variables

| Variable | Default | Purpose |
| --- | --- | --- |
| `BASE_URL` | `http://localhost:8081` | Application URL under test |
| `BASIC_AUTH_USER` | `admin` | API username |
| `BASIC_AUTH_PASSWORD` | `admin123` | API password |
| `VUS` | `10` | Virtual users during steady state |
| `RAMP_UP` | `30s` | Ramp-up duration |
| `STEADY_STATE` | `1m` | Steady-state duration |
| `RAMP_DOWN` | `30s` | Ramp-down duration |
| `THINK_TIME_SECONDS` | `1` | Pause between endpoint calls |

## Output

The test prints a terminal summary and writes a JSON summary to:

```text
k6/results/automotive-api-summary.json
```
