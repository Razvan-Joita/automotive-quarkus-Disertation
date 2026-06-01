#!/usr/bin/env bash
set -euo pipefail

BASE_URL="${BASE_URL:-http://localhost:8081}"
BASIC_AUTH_USER="${BASIC_AUTH_USER:-admin}"
BASIC_AUTH_PASSWORD="${BASIC_AUTH_PASSWORD:-admin123}"

mkdir -p k6/results

docker run --rm \
  --network host \
  -e BASE_URL="$BASE_URL" \
  -e BASIC_AUTH_USER="$BASIC_AUTH_USER" \
  -e BASIC_AUTH_PASSWORD="$BASIC_AUTH_PASSWORD" \
  -e VUS="${VUS:-10}" \
  -e RAMP_UP="${RAMP_UP:-30s}" \
  -e STEADY_STATE="${STEADY_STATE:-1m}" \
  -e RAMP_DOWN="${RAMP_DOWN:-30s}" \
  -e THINK_TIME_SECONDS="${THINK_TIME_SECONDS:-1}" \
  -v "$PWD:/work" \
  -w /work \
  grafana/k6:latest run k6/automotive-api-smoke.js
