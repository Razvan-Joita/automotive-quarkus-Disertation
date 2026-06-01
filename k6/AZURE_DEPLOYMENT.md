# Deploy and run k6 tests in Azure

The k6 script is portable: the same `k6/automotive-api-smoke.js` file can run locally, in Azure DevOps, in GitHub Actions, or in Azure Container Instances.

> Azure Load Testing is mainly documented for URL-based, JMeter, and Locust tests. For this project’s k6 JavaScript test, the most reliable Azure options are running k6 as a container in Azure Container Instances or running it inside Azure Pipelines/GitHub Actions.

## Option 1: Azure DevOps Pipeline

1. Commit these files to your repository:
    - `k6/automotive-api-smoke.js`
    - `azure-pipelines/k6-azure-pipelines.yml`

2. In Azure DevOps, create a new pipeline from `azure-pipelines/k6-azure-pipelines.yml`.

3. Add pipeline variables:
    - `BASE_URL`: public URL of the deployed Quarkus app, for example `https://your-app.azurecontainerapps.io`
    - `BASIC_AUTH_PASSWORD`: mark this as secret. Default development value is `admin123`.
    - Optional: `VUS`, `RAMP_UP`, `STEADY_STATE`, `RAMP_DOWN`

4. Run the pipeline. The JSON summary is published as the `k6-results` artifact.

## Option 2: GitHub Actions

1. Commit `.github/workflows/k6-performance.yml` and the `k6/` folder.
2. In GitHub, add repository secret `BASIC_AUTH_PASSWORD`.
3. Go to **Actions > k6 performance tests > Run workflow**.
4. Provide the deployed app URL and the virtual user count.

## Option 3: Azure Container Instances

Use this when you want an Azure-hosted one-off test run without Azure DevOps.

```bash
az login
az group create --name rg-automotive-k6 --location westeurope

az container create \
  --resource-group rg-automotive-k6 \
  --name automotive-k6-run \
  --image grafana/k6:latest \
  --restart-policy Never \
  --environment-variables \
      BASE_URL=https://your-app-url.azurecontainerapps.io \
      BASIC_AUTH_USER=admin \
      VUS=25 \
      RAMP_UP=1m \
      STEADY_STATE=5m \
      RAMP_DOWN=1m \
  --secure-environment-variables \
      BASIC_AUTH_PASSWORD=admin123 \
  --command-line "run https://raw.githubusercontent.com/Razvan-Joita/automotive-quarkus-Disertation/main/automotive-quarkus-disertation/k6/automotive-api-smoke.js"

az container logs \
  --resource-group rg-automotive-k6 \
  --name automotive-k6-run

az container delete \
  --resource-group rg-automotive-k6 \
  --name automotive-k6-run \
  --yes
```

If your repository is private, build a small container image that copies the `k6/` folder and run that image in ACI instead of loading the script from GitHub raw content.

## Recommended production thresholds

Start with the defaults in `automotive-api-smoke.js`:

- HTTP error rate below 5%.
- 95th percentile response time below 750 ms.
- 99th percentile response time below 1500 ms.
- Check pass rate above 95%.

Raise `VUS` gradually. For example: `25`, `50`, `100`, then `200`, while watching Quarkus, MySQL, Prometheus, and Grafana metrics.
