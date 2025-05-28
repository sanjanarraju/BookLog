# BookLog

A Spring Boot application for logging books you’ve read, including title, author, genre, rating (out of 5), and notes. Features a web UI and a REST API.

## Features

- Add, view, and delete books
- Rate books out of 5
- Add notes and genres
- Clean, modern web interface
- RESTful API for integration

##Setup and Structure - Local Development
- pom.xml (Maven dependencies)

- src/main/java/com/booklog/booklog/ (Java source files)

- src/main/resources/static/index.html (Web UI)

- src/main/resources/application.properties (Configuration)

##Build and Run
- Make sure to have: Java 17+, Maven 3.8+
- Build the Project: mvn clean install
- Run using Maven: mvn spring-boot:run

HTTP Page: http://localhost:8080/index.html
Test Endpoint: http://localhost:8080/api/hello

## CRUD Operations via API
- List books: GET /api/books
- Add book: POST /api/books
- Delete book: DELETE /api/books/{id}

  
<img width="1594" alt="Screenshot 2025-05-28 at 12 26 26 PM" src="https://github.com/user-attachments/assets/836c2427-189d-42ee-9eb1-5f51ed8381b8" />

<img width="1595" alt="Screenshot 2025-05-28 at 12 16 15 PM" src="https://github.com/user-attachments/assets/513de747-4a2b-4668-b1e7-75fd3f37a9df" />
