# Task Manager API 📝

A clean and practical Spring Boot REST API built as part of backend learning — using proper ResponseEntity responses and REST standards.

---

## 🚀 Tech Used

| Technology     | Purpose          |
|----------------|------------------|
| Java           | Language         |
| Spring Boot    | Framework        |
| Spring Web     | REST API         |
| Spring Data JPA| Database layer   |
| H2             | In-memory DB     |
| Maven          | Build tool       |
| Postman        | API testing      |


---

## 📦 Features

- Create tasks
- Get all tasks
- Get task by ID
- Update task
- Delete task
- Meaningful HTTP responses (201, 200, 204, 404)

---

## 🏗 Architecture

```
Client → Controller → Service → Repository → DB
```

---

## 📁 Project Structure

```
task-manager-api
 ├─ src
 ├─ docs
 │   └─ screenshots
 ├─ pom.xml
 └─ README.md
```

---

## 🛠 API Endpoints

| Method | Endpoint        | Description          | Success Code    | Error Code        |
|--------|-----------------|----------------------|-----------------|-------------------|
| POST   | `/tasks`        | Create task          | `201 CREATED`   | -                 |
| GET    | `/tasks`        | Get all tasks        | `200 OK`        | -                 |
| GET    | `/tasks/{id}`   | Get task by ID       | `200 OK`        | `404 NOT FOUND`   |
| PUT    | `/tasks/{id}`   | Update task by ID    | `200 OK`        | `404 NOT FOUND`   |
| DELETE | `/tasks/{id}`   | Delete task by ID    | `204 NO CONTENT`| `404 NOT FOUND`   |



---

## 📮 Request/Response Examples

### ▶ Create Task (`POST /tasks`)

Request:

```json
{
  "title": "Example Task",
  "description": "Testing ResponseEntity"
}
```

Response:

```json
{
  "title": "Example Task",
  "description": "Testing ResponseEntity",
  "status": "PENDING",
  "createdAt": "2025-12-02T15:47:16.548407",
  "updatedAt": "2025-12-02T15:47:16.548407",
  "id": 1
}
```

📷 Screenshot:  
`docs/screenshots/post-create.png`

---

### ▶ Get All Tasks (`GET /tasks`)

Response:

```json
[
  {
    "id": 1,
    "title": "Example Task",
    "description": "Testing ResponseEntity",
    "status": "PENDING",
    "createdAt": "...",
    "updatedAt": "..."
  }
]
```

📷 Screenshot:  
`docs/screenshots/get-all.png`

---

### ▶ Get Task by ID (`GET /tasks/{id}`)

📷 Screenshot:  
`docs/screenshots/get-by-id.png`

---

### ▶ Update Task (`PUT /tasks/{id}`)

📷 Screenshot:  
`docs/screenshots/update.png`

---

### ▶ Delete Task (`DELETE /tasks/{id}`)

📷 Screenshot:  
`docs/screenshots/delete.png`

---

## 🧩 Model Design

### `Task.java`

```
| Field      | Type          |
|------------|---------------|
| id         | Long          |
| title      | String        |
| description| String        |
| status     | TaskStatus    |
| createdAt  | LocalDateTime |
| updatedAt  | LocalDateTime |
```

### `TaskStatus.java`

```java
public enum TaskStatus {
    PENDING,
    COMPLETED
}
```

---

## ▶ Run the project

```bash
mvn spring-boot:run
```

Base URL:

```
http://localhost:8080
```

---

## 📌 Current Progress

| Feature         | Status       |
|----------------|-------------|
| CRUD           | ✅ Completed |
| ResponseEntity | ✅ Completed |
| Validation     | ⏳ Next      |
| DTO + Mapping  | ⏳ Planned   |
| Swagger Docs   | ⏳ Planned   |
| Deployment     | ⏳ Planned   |
---

## 🎯 Next Goals

- Add validation (`@NotNull`, `@Size`, custom messages)
- Global exception handling
- DTO refactoring
- Swagger documentation

---

## 🏁 Summary

This is a fully working backend CRUD app following proper REST conventions — built step by step with clean architecture and real-world response handling.

---

**⭐️ Keep improving. Next step: Validation.**
