# Task Manager API 📝

A clean and practical Spring Boot REST API built as part of backend learning — following proper REST conventions, validation, DTO pattern, pagination, and meaningful responses.

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
- Pagination support
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
 ├─ screenshots/             (Postman screenshots)
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
`screenshots/06-post-success.png`

---

### ❌ Validation Error (POST /tasks)

```json
{
  "description": "Description must be between 5 and 200 Characters",
  "title": "Title must be between 3 and 50 Characters"
}
```

📸 Screenshot  
`screenshots/07-post-error.png`

---

### ▶ Get All Tasks (`GET /tasks`)

📸 Screenshot  
`screenshots/03-get-all-success.png`

---

### ▶ Get Task By ID (`GET /tasks/{id}`)

📸 Success  
`screenshots/04-get-by-id-success.png`

📸 Not Found  
`screenshots/05-get-by-id-error.png`

---

### ▶ Update Task (`PUT /tasks/{id}`)

📸 Success  
`screenshots/08-put-success.png`

📸 Error  
`screenshots/09-put-error.png`

---

### ▶ Delete Task (`DELETE /tasks/{id}`)

📸 Success  
`screenshots/01-delete-success.png`

📸 Not Found  
`screenshots/02-delete-error.png`

---

## 📚 Pagination Examples (`GET /tasks?page=x&size=y`)

📸 Get All By Page  
`screenshots/getAllByPage.png`

📸 Get All By Pages  
`screenshots/getAllByPages.png`

📸 Pageable Response  
`screenshots/getAllTasksByPageable.png`

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
| Pagination & Sorting        | ✅ Completed |
| Swagger Documentation       | ⏳ Next      |
| Deployment                 | ⏳ Planned   |

---

### 🏁 Summary

A clean, production-style Spring Boot API demonstrating real-world patterns: DTOs, validation, pagination, and consistent HTTP responses — great for portfolio and future extensions like JWT authentication and deployment.

