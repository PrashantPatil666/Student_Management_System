
# Student Management System 🎓

A full-stack, enterprise-grade CRUD (Create, Read, Update, Delete) application built using **Spring Boot**, **Thymeleaf**, **Bootstrap 4**, and **MySQL**. This application acts as a clean dashboard for managing student profiles dynamically with a live relational database backend.

## 🚀 Features
* **Dashboard Overview:** Displays all registered students dynamically out of the MySQL database in a clean Bootstrap table layout.
* **Add New Student:** A secure input form to capture and validate student records (First Name, Last Name, and Email).
* **Update Records:** In-place editing functionality that securely carries over entity IDs to prevent data duplication.
* **Instant Deletion:** Fast removal of records from the database with built-in user confirmation dialogs.
* **Optimized Developer Workflow:** Configured with Spring DevTools to disable template caching, allowing instant HTML/CSS UI hot-reloads without server restarts.

---

## 🛠️ Technology Stack & Architecture
* **Backend:** Java 26, Spring Boot 4.x (Spring MVC, Spring Data JPA, Hibernate)
* **Frontend:** Thymeleaf Template Engine, Bootstrap 4, HTML5
* **Database:** MySQL 8.x / Localhost
* **Build Tool:** Maven

The project adheres to the standard professional **Controller-Service-Repository** layered architecture patterns, separating interfaces from business logic implementations (`StudentServiceImpl`) to ensure loose coupling.

---

## 📋 Prerequisites
Before running this application locally, ensure you have:
1. **Java Development Kit (JDK 21 or newer)** installed (Project is compiled using openjdk-26).
2. **MySQL Server** running on port `3306`.
3. An IDE like **IntelliJ IDEA** or Eclipse.

---

## ⚙️ Local Setup & Installation

### 1. Database Configuration
Open your MySQL terminal/shell and create the schema:
```sql
CREATE DATABASE prashant;
```

Next, open `src/main/resources/application.properties` and configure your database username and password credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/prashant?useSSL=true&serverTimezone=UTC
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate configurations for auto table generation
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Disable Thymeleaf cache for immediate frontend refresh
spring.thymeleaf.cache=false
```

### 2. Run the Application
Open your terminal inside the project root directory and execute:
```bash
./mvnw clean spring-boot:run
```

Once the terminal prints `Started StudentManagementSystemApplication`, open your web browser and navigate to:
👉 **`http://localhost:8080/students`**

---

## 🗂️ Project Structure & Endpoints

### Core UI Routing Endpoints:
* `GET /students` - Displays the student data dashboard table.
* `GET /students/new` - Opens the form page to create a new student record.
* `POST /students` - Processes form submission data to persist the entry.
* `GET /students/edit/{id}` - Loads existing student data into the edit layout.
* `POST /students/update/{id}` - Commits updated data structures back to MySQL.
* `GET /students/delete/{id}` - Deletes the student profile instantly and redirects home.
