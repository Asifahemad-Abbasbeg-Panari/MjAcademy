# Kodewala Academy – Recorded Classes Management System

A full-stack web application built with Java and Spring Boot to manage and organize recorded classes, Zoom links, passcodes, and study notes in one secure platform.

## 🚀 Features

### 👨‍🎓 Student
- Student registration
- Admin approval system
- Secure login/logout
- View recorded classes
- Search and filter recordings
- View Zoom meeting links and passcodes
- Access study notes and PDF files
- Change password

### 👨‍💼 Admin
- Secure admin login
- Add, edit and delete recordings
- Manage subjects and class information
- Upload PDF study notes
- Delete notes
- Approve student registrations
- Manage student accounts

## 🛠️ Technologies Used

- Java 21
- Spring Boot 3
- Spring Data JPA
- Hibernate
- MySQL
- BCrypt Password Hashing
- HTML5
- CSS3
- JavaScript
- Maven
- REST APIs

## 🔐 Security

- Passwords are stored using BCrypt hashing
- Role-based access control
- Admin-only management APIs
- Login required for recordings and notes
- Student approval before account access
- Sensitive configuration is handled through environment variables

## 📂 Project Structure

```text
src/
├── main/
│   ├── java/
│   │   └── com/kodewala/academy/
│   │       ├── controller/
│   │       ├── entity/
│   │       ├── repository/
│   │       ├── service/
│   │       └── AcademyApplication.java
│   │
│   └── resources/
│       ├── static/
│       └── application.properties
