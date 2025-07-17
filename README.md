# 📚 Hexagonal Architecture App for educational purposes

## 🧩 Description

This is a simple REST API built with **Spring Boot**, for putting into practice the **Hexagonal Architecture** (Ports & Adapters). It allows creating and storing users in a PostgreSQL database using a clean and decoupled architecture.

## 🛠️ Technologies Used

- ☕ Java 17+
- 🌱 Spring Boot 3.x
- 📦 Spring Data JPA
- 🐘 PostgreSQL
- 🐳 Docker & Docker Compose

## 📁 Project Structure

- `domain`: business entities and ports (interfaces)
- `application`: use case implementations
- `adapter.in.web`: REST controllers (input adapters)
- `adapter.out.persistence`: database persistence (output adapters)
- `resources`: configuration files (`application.yml`)

## ⚙️ Prerequisites

Make sure you have the following installed:

- Java 17+
- Maven or Gradle
- Docker & Docker Compose


## 🧪 How to Run the Project

1. **Clone the repository**

```bash
git clone https://github.com/gkuster/java-hexagonal-architecture.git
cd your-repo
```

2. **Start PostgreSQL with Docker**

```bash
docker compose up -d
```

3. **Verify the container is running**

```bash
docker ps
```

4. **Run the Spring Boot application from your IDE**


## 📬 Example API Endpoints

- `POST /users` — Create a new user  
  **Request Body:**
  ```json
  {
    "name": "Alice",
    "email": "alice@example.com"
  }
  ```


## ✅ How to Check Saved Data

**Option A — Using Docker CLI:**

```bash
docker exec -it hexagonal_demo_db psql -U demo_user -d demo_db
```

Inside the `psql` prompt:

```sql
SELECT * FROM users;
```

**Option B — Use a GUI Client:**

- Connect with tools like DBeaver, pgAdmin, or IntelliJ Database Tool
- Host: `localhost`
- Port: `5432`
- Database: `demo_db`
- User: `demo_user`
- Password: `demo_pass`


## 📌 Notes

- Follows Hexagonal Architecture to separate business logic from framework and infrastructure.
- Uses Spring Data JPA for data persistence.
- Docker is used to spin up an isolated PostgreSQL environment.


## 👨‍💻 Author

Created by Guillermo
📫 Contact: gpastor.kuster@gmail.com
