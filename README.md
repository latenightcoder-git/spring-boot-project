# Spring Boot Book API

This is a simple Spring Boot RESTful API that manages a collection of books. The application provides CRUD (Create, Read, Update, Delete) operations to handle books in a library. You can filter books by category and interact with them through HTTP endpoints.

## Features

- **GET /api/books** - Retrieve all books or filter books by category.
- **GET /api/books/{title}** - Retrieve a specific book by its title.
- **POST /api/books/create** - Add a new book to the collection.
- **PUT /api/books/{title}** - Update an existing book by its title.
- **DELETE /api/books/{title}** - Delete a book by its title.

## Tech Stack

- **Java 17**
- **Spring Boot 3.5.0**
- **Spring Web** (REST API)
- **Maven** for project management and dependencies

## Prerequisites

Before running the project, ensure that you have the following installed:

- **JDK 17+** (You can check if it’s installed by running `java -version` in the terminal)
- **Maven** (Optional, as it is bundled with Spring Boot)
- **IDE** like **IntelliJ IDEA** or **Eclipse** (with Spring Boot support)

## Setup and Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/springboot-book-api.git
   cd springboot-book-api

   


