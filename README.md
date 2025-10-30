# Transaction Aggregator

## Quick start (with docker-compose)
1. Build & run:
   docker-compose up --build

2. Endpoints
- POST /api/v1/ingest/run
  Triggers ingest from mock sources and stores categorized transactions.

Example:
curl -X POST http://localhost:8080/api/v1/ingest/run

- GET /api/v1/transactions/by-customer/{customerId}
  Optional query params: ?from=2025-10-01T00:00:00Z&to=2025-10-31T23:59:59Z

- GET /api/v1/aggregations/customer/{customerId}?from=<ISO>&to=<ISO>

- Actuator:
  /actuator/health
  /actuator/prometheus

## Notes
- Uses Postgres, JPA/Hibernate. For production consider Flyway and stricter DB config.
- Categorise is rule-based and lives in CategorizeService. Swap for ML or external service as needed.