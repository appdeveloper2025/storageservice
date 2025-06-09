# Storage Service

## Overview
The Storage Service is a Spring Boot application that provides an API to create user home directories on the filesystem. The application validates user input to ensure security and prevent SQL injection.

## Features
- Create user home directories based on a provided user ID.
- Input validation to ensure user ID contains only lowercase letters and numbers.

## API Endpoint
### Create User Home Directory
- **URL:** `/api/user/home`
- **Method:** `POST`
- **Request Body:**
  ```json
  {
    "userid": "string"
  }
  ```
- **Description:** This endpoint creates a home directory for the specified user ID.

## Directory Structure
```
storageservice
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── storageservice
│   │   │               ├── StorageServiceApplication.java
│   │   │               ├── controller
│   │   │               │   └── UserHomeController.java
│   │   │               └── service
│   │   │                   └── UserHomeService.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── storageservice
│                       └── StorageServiceApplicationTests.java
├── Dockerfile
├── Jenkinsfile
├── pom.xml
└── README.md
```

## Setup Instructions
1. Clone the repository:
   ```
   git clone https://github.com/microsoft/vscode-remote-try-java.git
   ```
2. Navigate to the project directory:
   ```
   cd storageservice
   ```
3. Build the application:
   ```
   mvn clean install
   ```
4. Run the application:
   ```
   mvn spring-boot:run
   ```

## Docker Instructions
1. Build the Docker image:
   ```
   docker build -t storageservice .
   ```
2. Run the Docker container:
   ```
   docker run -p 8080:8080 storageservice
   ```

## Testing
Unit tests are included in the project to ensure the application behaves as expected. Run the tests using:
```
mvn test
```

## License
This project is licensed under the MIT License.