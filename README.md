# G51 To-do API

This project is a To-do API built using Java and Spring Boot as part of the G51 full-stack web development course. The backend is connected to a MariaDB database, and all data interactions happen through a set of REST APIs.

## Project Architecture

The project follows a layered architecture shown in the images. 


/* will be updated 
- Add additional entities such as Reminder,
- Details
- Category
- Attachment */ 

1. **Controller Layer**: Handles API requests and communicates with the service layer.
2. **Service Layer**: Contains the business logic and communicates with repositories.
3. **Repository Layer**: Responsible for database interactions.
4. **Entity Layer**: Defines the entities and their relationships, such as `Task`, `Person`, `User`, and `Role`.
5. **DTO (Data Transfer Object)**: Simplifies data exchange between layers.



## Entity Relationship

- **User**: Contains user information such as email, password, and roles.
- **Task**: Represents a to-do task with fields like description, title, deadline, and a reference to a `Person`.
- **Person**: Linked to both `User` and `Task`, a person can have multiple tasks.
- **Role**: Used for user authorization and is associated with `User` in a many-to-many relationship.

![Entity Diagram]

## Technologies Used
- **Spring Boot**: Backend framework for building RESTful APIs.
- **Spring Data JPA**: ORM for database interaction
- **MariaDB**: The database used for persistence
- **Lombok**: Reduces boilerplate code with annotations like `@Getter` and `@Setter`
- **H2 Database** (Optional): For local development and testing.
- **Docker** (Optional): For containerization

## API Points
- **    GET /api/tasks - Fetch all tasks
-  GET /api/tasks/{id} - Fetch a specific task by ID
-  POST /api/tasks - Create a new task
-  PUT /api/tasks/{id} - Update an existing task
-  DELETE /api/tasks/{id} - Delete a task

## User Endpoints

    GET /api/users - Fetch all users
    POST /api/users - Create a new user

## Role Endpoints

    GET /api/roles - Fetch all roles
