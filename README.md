# BookLog

A Spring Boot application for logging books you’ve read, including title, author, genre, series, rating (out of 5), and notes. Features a web UI and a REST API.

## Features

- Add, view, and delete books
- Rate books out of 5
- Add notes and genres
- Create and Manage Book Series
- Clean, modern web interface
- RESTful API for integration

## Setup and Structure - Local Development
- pom.xml (Maven dependencies)

- src/main/java/com/booklog/booklog/ (Java source files)

- src/main/resources/static/index.html (Web UI)

- src/main/resources/application.properties (Configuration)

## Build and Run
- Make sure to have: Java 17+, Maven 3.8+
- Build the Project: mvn clean install
- Run using Maven: mvn spring-boot:run

HTTP Page: http://localhost:8080/index.html
Test Endpoint: http://localhost:8080/api/hello

## CRUD Operations via API
- List books: GET /api/books
- Add book: POST /api/books
- Delete book: DELETE /api/books/{id}

  
<img width="1598" alt="Screenshot 2025-05-28 at 4 11 00 PM" src="https://github.com/user-attachments/assets/37309383-d0ef-4a73-9feb-ccadcbd49d96" />

<img width="1596" alt="Screenshot 2025-05-28 at 4 17 54 PM" src="https://github.com/user-attachments/assets/96069a86-dfa7-45b4-b560-da7fdbd76963" />

<img width="1596" alt="Screenshot 2025-05-28 at 4 21 37 PM" src="https://github.com/user-attachments/assets/b6027b51-0f32-41ee-b987-b594d592a349" />




