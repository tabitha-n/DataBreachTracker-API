# 🫆 DataBreachTracker-API

Data is often called the “new gold” of the digital age. It powers everything from online shopping and mobile banking to global commerce and everyday apps. But with that value comes risk: when attackers steal data, the impact can reach millions of people and affect businesses and governments worldwide.

Data security isn’t just for IT specialists anymore—it’s something we all share responsibility for. Whether it’s an individual protecting their accounts, a company safeguarding its reputation, or a government protecting critical infrastructure, security starts with awareness.

The Data Breach Tracker API organises raw breach data into five key records—organisation, date, type of incident, data compromised, and affected users—making it easier to access, query, and understand. Unlike other services that require personal details to check breaches, this API only queries organisations, reducing the risk of exposing sensitive personal information.

The API aims to provide useful insights for:

🔍 Researchers, developers, and cybersecurity enthusiasts – analyse trends, build dashboards, or integrate breach data into tools.

🌍 The general public (through a future website) – stay informed about breaches in a simple, non-technical way.

## ✴️ Features

    🔍 View all cybersecurity breaches

    🔍 Retrieve a breach by ID

    ➕ Add new breach records

    ✏️ Update existing breach records

    ❌ Delete breach records

    ⚡ Fully functional with a MySQL database

    ⚠️ Exception handling with helpful error responses

    🌐 Optional external breach API via Have I Been Pwned (organisation only)

## ⚙ Tech Stack

    Java 21+

    Spring Boot 3+

    MySQL 8+  

    Maven (dependency management)

## 🛡️ Project Cybersecurity Highlights 

Even as a beginner project, DataBreachTracker demonstrates several fundamental cybersecurity principles:

    🔒 Data Integrity & Validation

• Breaches are only updated or deleted if they exist, preventing accidental or malicious misuse.

• Some fields, like id, are read-only to protect the uniqueness of records and prevent tampering.

    🛡️ Layered Security (Defense-in-Depth)

• Controller layer: Handles all user requests and is the only part exposed externally.

• Service layer: Manages business logic and makes sure requests are valid before reaching the database.

∙ Repository layer: Talks to the database directly. Other parts of the app never touch the database.

👉 This separation reduces risks and keeps each layer responsible for its own job.

    🌐 Secure API Practices

• Proxy to external API: The app queries Have I Been Pwned on behalf of the user. This prevents users from exposing personal data directly.

∙ User-Agent header: Properly identifies the app to the external API, a small but important step in secure communication.

    🔑 Hibernate & Security

• Acts as a bridge between Java objects and database tables, eliminating the need to write raw SQL queries.

∙ Helps prevent SQL injection attacks, where hackers try to run malicious queries on the database, making interactions safer by default.

    🗝️ Safe Credential Management

∙ Database credentials are stored in local.properties (excluded from GitHub via .gitignore).

This approach ensures:

🔒 Credentials stay private

⚠️ Accidental leaks are prevented

🛡️ Systems are protected from unauthorized access


# 🚀 Setup Instructions

  ### 1. Clone the repository

      git clone https://github.com/your-username/DataBreachTracker-API.git

      cd DataBreachTracker-API

  ### 2. Import the database

      Run the provided SQL dump file into MySQL:

      mysql -u <your-username> -p databreachtracker < db-dump.sql

  ### 3. Configure database credentials

    In application.properties:

        APPLICATION: 
        spring.application.name=DataBreachTracker
        server.port=8080

        DATABASE CONFIGURATION:
        spring.datasource.url=jdbc:mysql://localhost:3306/databreachtracker?useSSL=false&serverTimezone=UTC
        spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
        spring.config.import=local.properties   # Database credentials are stored here (not committed to GitHub)

        HIBERNATE CONFIGURATION:
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true

    In local.properties
    Create a file in the root of your project with your MySQL username and password:

        spring.datasource.username=yourUsername
        spring.datasource.password=yourPassword

    ⛔️ This file should be excluded via .gitignore (which tells Git which files not to track or upload to GitHub).

    

  ### 4. Run the application

      ./mvnw spring-boot:run

## 🔗 API Endpoints

### Internal Database Endpoints

    These endpoints access data stored in your local database (MySQL):

| Method | Endpoint                           | Description                                 |
|--------|----------------------------------- |---------------------------------------------|
| GET    | `/api/breaches`                    | Get all breaches                            |
| GET    | `/api/breaches?organisation={name}`| Filter breaches by organisation             |
| GET    | `/api/breaches/{id}`               | Get a breach by ID                          |
| POST   | `/api/breaches`                    | Add a new breach                            |
| PUT    | `/api/breaches/{id}`               | Update a breach                             |
| DELETE | `/api/breaches/{id}`               | Delete a breach                             |

    Note:
    Each breach has a unique id (primary key). Using both id and organisation provides flexible and reliable searching:

    🔑 id uniquely identifies each record, even if multiple breaches exist for the same organisation.

    🏢 organisation allows easy searching and filtering by company name.

    Together, they ensure you can accurately retrieve, update, or delete records.

### External HIBP Endpoint

| Method | Endpoint                           | Description                                              |
|--------|----------------------------------- |----------------------------------------------------------|
| GET    | `/api/hibp-breaches/{org}`         | Query breaches associated with a specific organisation   | 

    Note:
    This endpoint connects to Have I Been Pwned, a public service reporting real-world data breaches. Your API only queries organisation names, reducing the risk of exposing personal data.

## 👮 Using Postman 

    1. Open Postman (https://www.postman.com/) and create a new request.

    2. Select the HTTP method (GET, POST, etc.).

    3. Enter the endpoint URL e.g.:

        • http://localhost:8080/api/breaches

        • http://localhost:8080/api/hibp-breaches/facebook.com

    4. Click Send and view the response in JSON format.

    5. For POST or PUT requests, include a JSON body with the breach information.

## 🧪 Maven Tests
| Command                   | Description                                      |
|---------------------------|--------------------------------------------------|
| `./mvnw clean`            | Cleans the target directory (removes compiled files) |
| `./mvnw compile`          | Compiles the project                             |
| `./mvnw test`             | Runs unit tests                                  |
| `./mvnw clean test`       | Cleans and runs tests                            |
| `./mvnw spring-boot:run`  | Runs the Spring Boot application    


## 🗄️ Files Overview

    📁 Breach.java

Holds breach details like organisation, date, data compromised, affected users, and a unique id primary key.

    📁 BreachController.java

Internal API endpoints to manage breaches.

    📁 HibpBreachController.java

External API connecting to Have I Been Pwned, querying organisation names only.

    📁 BreachService.java

Handles business logic for adding, updating, retrieving, and deleting breaches.

    📁 BreachRepository.java

Manages breach records in the database.

    📁 BreachNotFoundException.java

Signals when a requested breach doesn’t exist.

        📁 GlobalExceptionHandler.java

Handles application errors and returns:

• Structured messages for specific exceptions (e.g., BreachNotFoundException)

• Generic errors with appropriate HTTP status codes

    📁 DataBreachTrackerApplication.java

Starts the Spring Boot application.

    📁 DataBreachTrackerApplicationTests.java

Confirms the Spring Boot app starts successfully.

    📁 BreachUnitTest.java

Unit tests for the Breach class getters and setters.