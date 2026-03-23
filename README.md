# ChatOp API

REST API for the ChatOp rental platform.

## Prerequisites

- Java 21
- Maven
- MySQL database

## Installation

1. Clone the repository
2. Create a `env.properties` file in the project root with:
   ```properties
   DB_HOST=localhost
   DB_PORT=3306
   DB_NAME=chatop
   DB_USER=your_username
   DB_PASSWORD=your_password
   JWT_SECRET=your_jwt_secret_key_min_32_characters
   JWT_EXPIRATION=86400000
   ```

3. Create the database:
   ```sql
   CREATE DATABASE chatop;
   ```
   
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Configuration

All configuration is managed via `env.properties`:
- Database connection (host, port, name, user, password)
- JWT settings (secret key, expiration time)

## API Documentation

Swagger UI is available at:
```
http://localhost:3001/swagger-ui/index.html
```

API endpoints:
- `POST /api/auth/register` - Register a new user
- `POST /api/auth/login` - Login
- `GET /api/auth/me` - Get current user info
- `GET /api/rentals` - Get all rentals
- `GET /api/rentals/{id}` - Get rental by ID
- `POST /api/rentals` - Create a rental (requires authentication)
- `PUT /api/rentals/{id}` - Update a rental (requires authentication)
- `GET /api/user/{id}` - Get user by ID
- `POST /api/messages` - Send a message (requires authentication)

## Project Structure

```
src/main/java/com/openclassrooms/chatopapi/
├── config/          # Configuration classes
├── controller/      # REST controllers
├── dto/             # Data Transfer Objects
├── exception/       # Exception handling
├── mapper/          # MapStruct mappers
├── model/           # JPA entities
├── repository/      # Spring Data repositories
├── security/        # JWT authentication
└── service/         # Business logic services
```
