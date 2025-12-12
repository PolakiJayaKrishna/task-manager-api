# Task Manager API 📝

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-brightgreen)
![Maven](https://img.shields.io/badge/Build-Maven-blue)
![Status](https://img.shields.io/badge/Status-Completed-success)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

A clean, production-grade Spring Boot REST API demonstrating CRUD operations, DTOs, validation, pagination, and global exception handling — built as a **portfolio-ready backend application**.

---

## 🎯 Highlights

- Professional REST API design and structure
- Request & Response DTO pattern
- Centralized validation with custom messages
- Global exception handling with clean JSON error responses
- Pagination using `page` and `size` query parameters
- Enum-based task status (`PENDING`, `COMPLETED`)
- Fully tested using Postman with real execution screenshots

---

## 🚀 Tech Stack

| Technology       | Purpose               |
|-----------------|-----------------------|
| Java 17         | Language              |
| Spring Boot     | Backend Framework     |
| Spring Web      | REST Controller Layer |
| Spring Data JPA | Persistence Layer     |
| H2 Database     | In-Memory Database    |
| Maven           | Build Tool            |
| Postman         | API Testing Tool      |

---

## 📦 Features

- Create, read, update, and delete tasks
- DTO-based request and response models
- Custom validation error messages
- Global exception handling for consistent error output
- Pagination and sorting support
- Enum-based status management (`PENDING`, `COMPLETED`)
- Clean, layered, and testable architecture

---

## 🏗 Architecture

Client → Controller → DTO → Service → Repository → Database

---

## 📁 Project Structure

    task-manager-api
     ├─ screenshots/
     │   ├─ 01-delete-success.png
     │   ├─ 02-delete-error.png
     │   ├─ 03-get-all-success.png
     │   ├─ 04-get-by-id-success.png
     │   ├─ 05-get-by-id-error.png
     │   ├─ 06-post-success.png
     │   ├─ 07-post-error.png
     │   ├─ 08-put-success.png
     │   ├─ 09-put-error.png
     │   ├─ 10-get-all-by-page.png
     │   ├─ 11-get-all-pages.png
     │   └─ 12-get-all-by-pageable.png
     ├─ src/
     │   └─ main/
     │       ├─ java/
     │       │   └─ com/example/todo/
     │       │       ├─ controller/
     │       │       ├─ dto/
     │       │       ├─ exception/
     │       │       ├─ model/
     │       │       ├─ repository/
     │       │       └─ service/
     │       └─ resources/
     ├─ pom.xml
     └─ README.md

---

## 🛠 API Endpoints

| Method | Endpoint                 | Description        | Success Status   | Error Status      |
|--------|--------------------------|--------------------|------------------|-------------------|
| POST   | `/tasks`                 | Create Task        | `201 CREATED`    | `400 BAD REQUEST` |
| GET    | `/tasks`                 | Get All Tasks      | `200 OK`         | —                 |
| GET    | `/tasks/{id}`            | Get Task By ID     | `200 OK`         | `404 NOT FOUND`   |
| PUT    | `/tasks/{id}`            | Update Task        | `200 OK`         | `400 / 404`       |
| DELETE | `/tasks/{id}`            | Delete Task        | `204 NO CONTENT` | `404 NOT FOUND`   |
| GET    | `/tasks?page=x&size=y`   | Paginated Tasks    | `200 OK`         | —                 |

---

## 📮 Sample Request & Response

### Create Task — POST `/tasks`

Request body:

    {
      "title": "Learn DTO",
      "description": "Understanding mapping and validation"
    }

Successful response (201 Created):

    {
      "id": 1,
      "title": "Learn DTO",
      "description": "Understanding mapping and validation",
      "status": "PENDING",
      "createdAt": "2025-12-06T12:42:30.012351",
      "updatedAt": "2025-12-06T12:42:30.012351"
    }

Validation error example:

    {
      "description": "Description must be between 5 and 200 Characters",
      "title": "Title must be between 3 and 50 Characters"
    }

---

## 📷 API Demo (Postman Screenshots)

### 1️⃣ Create Task (POST `/tasks`)

**Success**

![Create Task Success](screenshots/06-post-success.png)

**Validation Error**

![Create Task Error](screenshots/07-post-error.png)

---

### 2️⃣ Get All Tasks (GET `/tasks`)

![Get All Tasks](screenshots/03-get-all-success.png)

---

### 3️⃣ Get Task By ID (GET `/tasks/{id}`)

**Success**

![Get Task By ID Success](screenshots/04-get-by-id-success.png)

**Not Found**

![Get Task By ID Error](screenshots/05-get-by-id-error.png)

---

### 4️⃣ Update Task (PUT `/tasks/{id}`)

**Success**

![Update Task Success](screenshots/08-put-success.png)

**Error**

![Update Task Error](screenshots/09-put-error.png)

---

### 5️⃣ Delete Task (DELETE `/tasks/{id}`)

**Success**

![Delete Task Success](screenshots/01-delete-success.png)

**Not Found**

![Delete Task Error](screenshots/02-delete-error.png)

---

### 6️⃣ Pagination (GET `/tasks?page=x&size=y`)

**Tasks for a specific page**

![Get All Tasks By Page](screenshots/10-get-all-by-page.png)

**All available pages metadata**

![Get All Pages](screenshots/11-get-all-pages.png)

**Pageable style response**

![Get All Tasks Pageable](screenshots/12-get-all-by-pageable.png)

---

### 7️⃣ Sorting & Pagination (GET `/tasks` with query params)

You can combine **pagination** and **sorting** using query parameters like `page`, `size`, `sortBy`, and `direction`.

**Example:**

`GET /tasks?page=1&size=2&sortBy=createdAt&direction=desc`

📸 **Page + Sort by `createdAt` (desc)**  
![Get Tasks Page + Sort by createdAt desc](screenshots/Sort+Pagination.png)

---

**All tasks with sorting and pagination metadata**  
![Get Tasks – All Pages With Sorting](screenshots/SortGetAll.png)

---

**Sort by `title` ASC**  
![Get Tasks – Sort by Title ASC](screenshots/SortAsc.png)

---

**Sort by `title` DESC**  
![Get Tasks – Sort by Title DESC](screenshots/SortDesc.png)


📸 **Sort + Pagination Combined (Demo)**
![Sort + Pagination Demo](screenshots/sort-pagination-demo.png)

📸 **All Tasks With Sorting – Full Pages Metadata (Demo)**
![Sorting – All Pages Demo](screenshots/sort-all-pages-demo.png)


---

## 🧩 Data Model

### Entity: `Task`

| Field       | Type          | Description                  |
|------------|---------------|------------------------------|
| id         | Long          | Primary key                  |
| title      | String        | Task title                   |
| description| String        | Detailed description         |
| status     | TaskStatus    | `PENDING` or `COMPLETED`     |
| createdAt  | LocalDateTime | Created timestamp            |
| updatedAt  | LocalDateTime | Last updated timestamp       |

### Enum: `TaskStatus`

    public enum TaskStatus {
        PENDING,
        COMPLETED
    }

---

## ▶ Running the Application

Build and run using Maven:

    mvn spring-boot:run

Base URL:

    http://localhost:8080

---

## 📌 Current Progress

| Feature                     | Status      |
|----------------------------|------------|
| CRUD Operations            | ✅ Completed |
| DTO (Request & Response)   | ✅ Completed |
| Validation + Custom Errors | ✅ Completed |
| Global Exception Handling  | ✅ Completed |
| Pagination & Sorting       | ✅ Completed |
| Postman Testing            | ✅ Completed |
| Swagger / OpenAPI Docs     | ⏳ Planned  |
| Deployment                 | ⏳ Planned  |

---

## 🏁 Summary

This project demonstrates:

- Clean, layered Spring Boot architecture
- DTO-based request and response models
- Validation with clear, user-friendly error messages
- Global exception handling for consistent API behavior
- Pagination support with `page` and `size` query parameters
- Real-world API testing using Postman with attached screenshots

---

📄 **License:** This project is licensed under the MIT License.  
🧑‍💻 Built with focus and consistency while mastering Spring Boot backend development.
