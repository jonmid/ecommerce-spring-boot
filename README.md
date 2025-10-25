# Products Multi-Tenancy API

A Spring Boot REST API for multi-tenant product and inventory management. It models companies, stores, users and roles, brands, product models and variants, inventory, selling prices, stock transactions, transfers with details, and subscription plans/payments.

## Requirements
- Java 17+
- Maven 3.8+
- A relational database (H2 dev or Postgres/MySQL in prod)

## Quick Start
1. Configure database connection in `src/main/resources/application.properties` (H2 in-memory for local dev is fine):
   ```properties
   # Example H2 (dev)
   spring.datasource.url=jdbc:h2:mem:products;DB_CLOSE_DELAY=-1;MODE=PostgreSQL
   spring.datasource.username=sa
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update
   spring.h2.console.enabled=true
   management.endpoints.web.exposure.include=health,info
   server.port=8080
   ```
2. Run the application:
   ```bash
   mvn spring-boot:run
   ```
3. Base URL:
   - `http://localhost:8080/api/v1`

## Postman Collection
A collection to exercise all CRUD endpoints is included.
- File: `postman_collection.json`
- Path: `/Users/robinfood/Desktop/products/postman_collection.json`
- Import into Postman and set the variable:
  - `baseUrl = http://localhost:8080`

The collection includes folders for:
- Companies
- Stores
- Users
- User Store Roles
- Brands
- Product Models
- Product Variants
- Inventory Stocks
- Store Selling Prices
- Stock Transactions
- Transfers
- Transfer Details
- Subscription Plans
- Subscription Payments

Each folder contains: list, get by id, create, update, delete.

## Sample Requests (curl)
- Create a Brand:
  ```bash
  curl -X POST \
    -H 'Content-Type: application/json' \
    -d '{"name":"Nike"}' \
    http://localhost:8080/api/v1/brands
  ```
- Create a Product Model:
  ```bash
  curl -X POST \
    -H 'Content-Type: application/json' \
    -d '{"brand":{"id":1},"name":"Air Max","footwearType":"Sneakers","mainMaterial":"Leather","gender":"Unisex"}' \
    http://localhost:8080/api/v1/product-models
  ```
- Create a Product Variant:
  ```bash
  curl -X POST \
    -H 'Content-Type: application/json' \
    -d '{"productModel":{"id":1},"sizeUs":"10","primaryColor":"Black","sku":"SKU-123","barcode":"BAR-123","purchasePrice":100.0}' \
    http://localhost:8080/api/v1/product-variants
  ```

## Architecture Notes
- Persistence: Spring Data JPA repositories per entity for CRUD.
- Web: REST controllers (`@RestController`) exposing `/api/v1/**` endpoints for each entity.
- Multi-tenancy: Entities reference `Company` and `Store` to scope data. Use `Company.subdomain` to route/identify tenant when needed.
- Transfer workflow: `Transfer` holds metadata (origin/destination/status), with `TransferDetail` items carrying quantities per variant.
- Subscription: `SubscriptionPlan` defines plan limits/pricing, `SubscriptionPayment` tracks company subscriptions and payment status.

## Build & Test
- Build:
  ```bash
  mvn clean package
  ```
- Run tests:
  ```bash
  mvn test
  ```

## Deployment
- Externalize DB credentials via environment:
  - `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, `SPRING_DATASOURCE_PASSWORD`
- Tune JPA:
  - `spring.jpa.hibernate.ddl-auto=validate` for production
- Run as a jar:
  ```bash
  java -jar target/products-*.jar
  ```

## Security & Validation (Next Steps)
- Add authentication/authorization (e.g., Spring Security + JWT).
- Add request validation (`@Valid` + Bean Validation).
- Add pagination/sorting to list endpoints.
- Add domain constraints and business rules for transfers/transactions.

## Troubleshooting
- If the app fails to start, verify database connectivity and the `spring.jpa.hibernate.ddl-auto` setting matches your needs.
- Use H2 console at `http://localhost:8080/h2-console` (if enabled) to inspect data.