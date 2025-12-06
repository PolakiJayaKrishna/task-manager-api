# Task Manager API 📝

A clean and practical Spring Boot REST API built as part of backend learning — following proper REST conventions, validation, DTO pattern, and meaningful responses.

---

## 🚀 Tech Used

| Technology       | Purpose           |
|-----------------|-------------------|
| Java            | Language          |
| Spring Boot     | Framework         |
| Spring Web      | REST API          |
| Spring Data JPA | Database Layer    |
| H2 Database     | In-memory Storage |
| Maven           | Build Tool        |
| Postman         | API Testing       |

---

## 📦 Features

- Create tasks
- Get all tasks
- Get task by ID
- Update task
- Delete task
- DTO (Request + Response)
- Validation with custom messages
- Global Exception Handling
- Clean API responses using `ResponseEntity`

---

## 🏗 Architecture

```
Client → Controller → DTO → Service → Repository → Database
```

---

## 📁 Project Structure

```
task-manager-api
 ├─ src/main/java/...        (source code)
 ├─ src/main/resources/...   (config files)
 ├─ docs/screenshots/        (Postman screenshots)
 ├─ pom.xml
 └─ README.md
```

---

## 🛠 API Endpoints

| Method | Endpoint        | Description        | Success Status   | Error Status      |
|--------|-----------------|--------------------|------------------|-------------------|
| POST   | `/tasks`        | Create Task        | `201 CREATED`    | `400 BAD REQUEST` |
| GET    | `/tasks`        | Get All Tasks      | `200 OK`         | -                 |
| GET    | `/tasks/{id}`   | Get Task By ID     | `200 OK`         | `404 NOT FOUND`   |
| PUT    | `/tasks/{id}`   | Update Task        | `200 OK`         | `400 / 404`       |
| DELETE | `/tasks/{id}`   | Delete Task        | `204 NO CONTENT` | `404 NOT FOUND`   |

---

## 📮 Request/Response Examples

### ▶ Create Task (`POST /tasks`)

📌 Request

```json
{
  "title": "Learn DTO",
  "description": "Understanding mapping and validation"
}
```

📌 Response

```json
{
  "id": 1,
  "title": "Learn DTO",
  "description": "Understanding mapping and validation",
  "status": "PENDING",
  "createdAt": "2025-12-06T12:42:30.012351",
  "updatedAt": "2025-12-06T12:42:30.012351"
}
```

📸 Screenshot  
`docs/screenshots/06-post-success.png`

---

### ❌ Validation Error (POST /tasks)

```json
{
  "description": "Description must be between 5 and 200 Characters",
  "title": "Title must be between 3 and 50 Characters"
}
```

📸 Screenshot  
`docs/screenshots/07-post-error.png`

---

### ▶ Get All Tasks (`GET /tasks`)

📸 Screenshot  
`docs/screenshots/03-get-all.png`

---

### ▶ Get Task By ID (`GET /tasks/{id}`)

📸 Success  
`docs/screenshots/04-get-by-id.png`

📸 Not Found  
`docs/screenshots/05-get-by-id-error.png`

---

### ▶ Update Task (`PUT /tasks/{id}`)

📸 Success  
`docs/screenshots/08-put-success.png`

📸 Error  
`docs/screenshots/09-put-error.png`

---

### ▶ Delete Task (`DELETE /tasks/{id}`)

📸 Success  
`docs/screenshots/01-delete-success.png`

📸 Not Found  
`docs/screenshots/02-delete-error.png`

---

## 🧩 Model Design

### `Task.java`

| Field        | Type          |
|-------------|---------------|
| id          | Long          |
| title       | String        |
| description | String        |
| status      | TaskStatus    |
| createdAt   | LocalDateTime |
| updatedAt   | LocalDateTime |

---

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

| Feature                      | Status       |
|-----------------------------|-------------|
| CRUD Operations             | ✅ Completed |
| ResponseEntity              | ✅ Completed |
| Validation + Custom Errors  | ✅ Completed |
| Global Exception Handling   | ✅ Completed |
| DTO (Request + Response)    | ✅ Completed |
| Mapping (Entity ↔ DTO)      | ✅ Completed |
| Postman Testing             | ✅ Completed |
| Pagination & Sorting        | ⏳ Next      |
| Swagger Documentation       | ⏳ Planned   |
| Deployment                 | ⏳ Planned   |

---
