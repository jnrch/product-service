# Product Service

This is a simple **Product Service** application, designed as part of a microservice architecture using hexagonal architecture principles. It allows the creation, querying, and management of product-related data in a maintainable manner.

## Technologies Used

- **Java**: Version 17 (LTS)
- **Spring Boot**: Version 3.3.1
- **Spring Data JPA**: For persistence and database interaction
- **H2 Database**: In-memory database for local development (can be switched to other databases such as PostgreSQL or MySQL)
- **JUnit 5**: For unit testing
- **Maven**: Build tool for dependency management and project structure
- **MapStruct**: For object mapping

## Architecture

The application follows a **Hexagonal Architecture** (also known as **Ports and Adapters**), which helps in isolating the core business logic from the external dependencies.

### Key Components:

1. **Domain Layer**: Contains the core business logic. This includes entities like `Product` and service classes such as `CreateProductService` and `GetProductService`.

2. **Application Layer**: Responsible for orchestrating use cases and coordinating between the domain and external services (like persistence). The `ProductService` class handles the use cases for creating and querying products.

3. **Ports**:
    - **Input Ports**: Interfaces for accepting requests. Example: `CreateProductInputPort`, `GetProductInputPort`.
    - **Output Ports**: Interfaces for communicating with external systems. Example: `CreateProductOutputPort`, `GetProductOutputPort` for data persistence.

4. **Adapters**:
    - **Input Adapters (REST controllers)**: Expose REST endpoints for interacting with the service. Examples: `CreateProductController`, `GetProductController`.
    - **Output Adapters (JPA)**: Handle interactions with the database through `ProductRepository` and `ProductJpaAdapter`.

### Folder Structure:
```
src/
├── main/
│   ├── java/
│   │   ├── com/example/product/
│   │       ├── domain/
│   │       │   ├── Product.java
│   │       │   ├── services/
│   │       │   │   ├── CreateProductService.java
│   │       │   │   └── GetProductService.java
│   │       │   └── exceptions/
│   │       │       └── ProductNotFoundException.java
│   │       ├── application/
│   │       │   ├── CreateProductUseCase.java
│   │       │   └── GetProductUseCase.java
│   │       ├── ports/
│   │       │   ├── input/
│   │       │   │   ├── CreateProductInputPort.java
│   │       │   │   └── GetProductInputPort.java
│   │       │   ├── output/
│   │       │   │   ├── CreateProductOutputPort.java
│   │       │   │   └── GetProductOutputPort.java
│   │       ├── adapters/
│   │       │   ├── input/rest/
│   │       │   │   ├── CreateProductController.java
│   │       │   │   ├── GetProductController.java
│   │       │   └── output/jpa/
│   │       │       ├── ProductEntity.java
│   │       │       ├── ProductRepository.java
│   │       │       └── ProductJpaAdapter.java
│   │       └── ProductMicroserviceApplication.java
│   └── resources/
│       ├── application.yml
│       └── data.sql
└── test/
└── java/com/example/product/
├── adapters/input/rest/CreateProductControllerTest.java
├── adapters/input/rest/ProductQueryControllerTest.java
├── domain/services/CreateProductServiceTest.java
├── domain/services/GetProductServiceTest.java
├── application/CreateProductUseCaseTest.java
└── application/GetProductUseCaseTest.java
```

## Setup

### Prerequisites

- Java 17 (LTS)
- Maven
- IDE like IntelliJ IDEA or Eclipse

### Running the Application

1. Clone this repository:

```bash
mvn clean install

mvn spring-boot:run

mvn test 

```

### Run application with docker

```
mvn clean install
docker build -t product-service .
docker-compose up
```

### Remove container & docker image

```
docker container ls
docker rm -f {CONTAINER_ID}
docker images
docker rmi {IMAGE_ID}
```
### Endpoints
#### Base URL: http://localhost:8080/api
- POST /products: Create a new product.
- GET /products/{id}: Retrieve a product by ID.
- GET /actuator/health: Check the application's health status.
- GET /swagger-ui/index.html: Access the Swagger UI for API documentation.