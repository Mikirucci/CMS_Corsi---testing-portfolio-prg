# 📚 CMS Corsi di Formazione

A modern **Content Management System** for managing online training courses, built with a clean, enterprise-grade architecture.

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java 21 + Spring Boot 4 |
| Database | MySQL 8 |
| API Docs | Swagger / OpenAPI 3 |
| Frontend | React + TypeScript *(in progress)* |
| Auth | JWT *(coming soon)* |
| Container | Docker + Docker Compose *(coming soon)* |

---

## 🏗️ Architecture

```
[React Frontend] ←→ [Spring Boot REST API] ←→ [MySQL Database]
```

The project follows a clean layered architecture:

- **Controller** — handles HTTP requests and responses
- **Service** — contains business logic
- **Repository** — manages database operations
- **Model** — reflects the database schema

---

## 🚀 Getting Started

### Prerequisites

- Java 21+
- Maven
- MySQL 8+

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/cms-corsi.git
   cd cms-corsi
   ```

2. **Create a `.env` file** in the project root:
   ```
   DB_URL=jdbc:mysql://localhost:3306/cms_corsi
   DB_USERNAME=root
   DB_PASSWORD=yourpassword
   ```

3. **Create the database** in MySQL:
   ```sql
   CREATE DATABASE cms_corsi;
   ```

4. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Open Swagger UI** at:
   ```
   http://localhost:8080/swagger-ui.html
   ```

---

## 📡 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/corsi` | Get all courses |
| `GET` | `/api/corsi/{id}` | Get course by ID |
| `GET` | `/api/corsi/search?nome=` | Search courses by name |
| `POST` | `/api/corsi` | Create a new course |
| `PUT` | `/api/corsi/{id}` | Update a course |
| `DELETE` | `/api/corsi/{id}` | Delete a course |
| `PUT` | `/api/corsi/{id}/publish` | Publish a course |

---

## 🗺️ Roadmap

- [x] Project setup & dependencies
- [x] Database connection (MySQL + JPA)
- [x] Course model & entity
- [x] CRUD REST API
- [x] Swagger / OpenAPI documentation
- [x] Custom exceptions & error handling
- [ ] Input validation
- [ ] CORS configuration
- [ ] JWT Authentication & Security
- [ ] DTO pattern
- [ ] React + TypeScript frontend
- [ ] Docker & Docker Compose
- [ ] Unit & integration tests

---

## 📁 Project Structure

```
src/
└── main/
    └── java/com/michele/cms/
        ├── config/         # Configuration classes
        ├── controller/     # REST Controllers & API interfaces
        ├── exception/      # Custom exceptions
        ├── model/          # JPA Entities
        ├── repository/     # Spring Data JPA repositories
        ├── security/       # JWT & Spring Security
        └── service/        # Business logic
```

---

## 👨‍💻 Author

Built as a learning project to practice enterprise Java development with Spring Boot and React.
