# Task Manager API 📝

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-brightgreen)
![Maven](https://img.shields.io/badge/Build-Maven-blue)
![Status](https://img.shields.io/badge/Project-Completed-success)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

A **production-style Spring Boot REST API** demonstrating clean backend architecture, DTO usage, validation, pagination, sorting, and partial updates — built as a **portfolio-ready backend project**.

---

## 🎯 Project Highlights

- Clean REST API design (Controller → Service → Repository)
- Request & Response DTO separation
- Validation with meaningful error messages
- Global exception handling
- Pagination and sorting support
- Enum-based business state handling
- PATCH-based partial update (status only)
- MySQL database integration
- Fully tested using Postman with screenshots

---

## 🧱 Tech Stack

| Technology        | Purpose                  |
|------------------|--------------------------|
| Java 17          | Core language            |
| Spring Boot      | Backend framework        |
| Spring Web       | REST APIs                |
| Spring Data JPA  | Persistence layer        |
| Hibernate        | ORM                      |
| MySQL            | Relational database      |
| Maven            | Build tool               |
| Postman          | API testing              |

---

## 🏗 Architecture

```
Client
  ↓
Controller
  ↓
DTO (Request / Response)
  ↓
Service (Business Logic)
  ↓
Repository (JPA)
  ↓
MySQL Database
```

---

## ✨ Features

- Create, read, update, and delete tasks
- DTO-based request and response models
- Validation with custom messages
- Global exception handling
- Pagination using `page` and `size`
- Sorting using `sortBy` and `direction`
- Enum-based task status (`PENDING`, `COMPLETED`)
- PATCH endpoint for status-only updates

---

## 📦 API Endpoints

| Method | Endpoint                 | Description                     |
|--------|--------------------------|---------------------------------|
| POST   | `/tasks`                 | Create a new task               |
| GET    | `/tasks`                 | Get all tasks (pagination)      |
| GET    | `/tasks/{id}`            | Get task by ID                  |
| PUT    | `/tasks/{id}`            | Update title & description      |
| PATCH  | `/tasks/{id}/status`     | Update task status only         |
| DELETE | `/tasks/{id}`            | Delete task                     |

---

## 📮 Sample Request

### Create Task — POST `/tasks`

```json
{
  "title": "Learn Spring Boot",
  "description": "Build production-ready APIs"
}
```

### Successful Response

```json
{
  "id": 1,
  "title": "Learn Spring Boot",
  "description": "Build production-ready APIs",
  "status": "PENDING",
  "createdAt": "2025-12-12T20:40:20",
  "updatedAt": "2025-12-12T20:40:20"
}
```

---
## 📷 API Demo (Postman Screenshots)

### 1️⃣ Create Task (POST `/tasks`)

**Success**
![Create Task Success](screenshots/06-post-success.png)

**Validation Error**
![Create Task Validation Error](screenshots/07-post-error.png)

---

### 2️⃣ Get All Tasks (GET `/tasks`)

![Get All Tasks](screenshots/03-get-all-success.png)

---

### 3️⃣ Get Task By ID (GET `/tasks/{id}`)

**Success**
![Get Task By ID Success](screenshots/04-get-by-id-success.png)

**Not Found**
![Get Task By ID Not Found](screenshots/05-get-by-id-error.png)

---

### 4️⃣ Update Task (PUT `/tasks/{id}`)

**Success**
![Update Task Success](screenshots/08-put-success.png)

**Validation / Not Found Error**
![Update Task Error](screenshots/09-put-error.png)

---

### 5️⃣ Delete Task (DELETE `/tasks/{id}`)

**Success**
![Delete Task Success](screenshots/01-delete-success.png)

**Not Found**
![Delete Task Error](screenshots/02-delete-error.png)

---

### 6️⃣ Pagination (GET `/tasks?page=x&size=y`)

**Single Page Result**
![Pagination – Page Result](screenshots/10-get-all-by-page.png)

**All Pages Metadata**
![Pagination – All Pages](screenshots/11-get-all-pages.png)

**Pageable Response**
![Pagination – Pageable Style](screenshots/12-get-all-by-pageable.png)

---

### 7️⃣ Sorting & Pagination Combined

**Sort + Pagination**
![Sort + Pagination](screenshots/Sort+Pagination.png)

**Sort by Title (ASC)**
![Sort Title ASC](screenshots/SortAsc.png)

**Sort by Title (DESC)**
![Sort Title DESC](screenshots/SortDesc.png)

**Get All Tasks With Sorting**
![Sort Get All](screenshots/SortGetAll.png)

---

### 8️⃣ Partial Update – Status Only (PATCH `/tasks/{id}/status`)

**Status Update Success**
![Patch Status Success](screenshots/PATCH.png)
---

## 🧩 Data Model

### Entity: `Task`

| Field       | Type          |
|------------|---------------|
| id         | Long          |
| title      | String        |
| description| String        |
| status     | TaskStatus    |
| createdAt  | LocalDateTime |
| updatedAt  | LocalDateTime |

### Enum: `TaskStatus`

```java
public enum TaskStatus {
    PENDING,
    COMPLETED
}
```

---

## ▶ Run the Application

```bash
mvn spring-boot:run
```

Base URL:
```
http://localhost:8080
```

---

## 🏁 Summary

This project demonstrates:

- Professional Spring Boot REST API design
- Clean layered architecture
- Real database usage (MySQL)
- Pagination, sorting, and partial updates
- Strong debugging and implementation discipline

📄 License: MIT  
🧑‍💻 Built with focus on backend engineering best practices.