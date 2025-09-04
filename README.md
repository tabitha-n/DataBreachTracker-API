# 🫆 DataBreachTracker-API

Data is often called the “new gold” of the digital age. It powers everything from online shopping and mobile banking to global commerce and everyday apps. But with that value comes risk: when attackers steal data, the impact can reach millions of people and damage businesses worldwide.

Data security isn’t just for IT specialists anymore—it’s something we all share responsibility for. Whether it’s an individual protecting their bank account, a company safeguarding its reputation, or a government protecting critical infrastructure, security begins with awareness.

That’s where the Data Breach Tracker API comes in. It organises raw breach data into five key records—organisation, date, type of incident, data compromised, and affected users—making it easy to access and understand. Unlike services that require you to enter personal details to check breaches, this API lets you query organisations only, helping users avoid the risk of exposing their own information.

The aim is to turn raw breach data into useful insights for:

    🔍 Researchers, developers, and cybersecurity enthusiasts who want to analyse trends, build dashboards, or integrate breach data into tools.

    🌍 The general public (through a future website) who want to stay informed about breaches in a simple, non-technical way.

The API back end is currently under development and will be deployed on Render, with a future front end hosted on Netlify.

## ✴️ Features

    🔍 View all cybersecurity breaches

    🔍 Retrieve a breach by ID

    ➕ Add new breach records

    ✏️ Update existing breach records

    ❌ Delete breach records

    ⚡ Fully functional with a MySQL database

    ⚠️ Exception handling with helpful error responses

    🌐 Optional external breach API via haveibeenpwned.com

## ⚙ Tech Stack

    Java 21+

    Spring Boot 3+

    MySQL 8+  

    Maven (dependency management)

# 🚀 Setup Instructions

  ### 1. Clone the repository

      git clone https://github.com/your-username/DataBreachTracker-API.git

      cd DataBreachTracker-API

  ### 2. Import the database

      Run the provided SQL dump file into MySQL:

      mysql -u <your-username> -p databreachtracker < db-dump.sql

  ### 3. Configure database credentials

    The main configuration is in application.properties:

    # APPLICATION 
    spring.application.name=DataBreachTracker
    server.port=8080

    # DATABASE CONFIGURATION
    spring.datasource.url=jdbc:mysql://localhost:3306/databreachtracker?useSSL=false&serverTimezone=UTC
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.config.import=local.properties   # Database credentials are stored here (not committed to GitHub)

    # HIBERNATE CONFIGURATION
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

    👉 Important: 
      Create a file called local.properties in the root of your project with your MySQL username and password:

      spring.datasource.username=yourUsername
      spring.datasource.password=yourPassword

    ⛔️ It should be excluded via .gitignore 

  ### 4. Run the application

      From the terminal:
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

### External HIBP Endpoint

    This endpoint connects to Have I Been Pwned, a public service reporting real-world data breaches. 
    
    Unlike HIBP, which usually requires you to enter personal details, this endpoint only uses the organisation name.

    This minimises the risk of exposing personal information.

| Method | Endpoint                           | Description                                              |
|--------|----------------------------------- |----------------------------------------------------------|
| GET    | `/api/hibp-breaches/{org}`         | Query breaches associated with a specific organisation   | 

### 👮 Using Postman

    1. Open Postman (https://www.postman.com/) and create a new request.

    2. Select the HTTP method (GET, POST, etc.).

    3. Enter the endpoint URL e.g. http://localhost:8080/api/breaches or http://localhost:8080/api/hibp-breaches/facebook.com

    4. Click Send and view the response in JSON format.

    5. For POST or PUT requests, include a JSON body with the breach information.

## 🧪 Maven Tests
| Command                   | Description                                      |
|---------------------------|--------------------------------------------------|
| `./mvnw clean`            | Cleans the target directory (removes compiled files) |
| `./mvnw compile`          | Compiles the project                             |
| `./mvnw test`             | Runs unit tests                                  |
| `./mvnw clean test`       | Cleans and runs tests                            |
| `./mvnw package`          | Builds the project into a JAR file              |
| `./mvnw spring-boot:run`  | Runs the Spring Boot application    


## 🗄️ Files Overview

### 📁 Breach.java	                  

Holds the details of a data breach, like company name, date, number of people affected, and what information was exposed.

### 📁 BreachRepository.java	        

Manages breach records in the database.

### 📁 BreachService.java	          

Handles business logic for adding, updating, retrieving, and deleting breaches.

### 📁 BreachController.java	

Provides API endpoints to manage breaches internally.

### 📁 HibpBreachController.java	

External API controller connecting to Have I Been Pwned.

### 📁 BreachNotFoundException.java	

Signals when a requested breach doesn’t exist.

### 📁 GlobalExceptionHandler.java	

Catches errors and sends easy-to-read messages back to the user.

### 📁 DataBreachTrackerApplication.java	

Starts the DataBreachTracker app so it can run and show information about breaches.

### 📁 DataBreachTrackerApplicationTests.java	

Confirms that the Spring Boot application starts without errors.

### 📁 BreachUnitTest.java	

Unit test for the Breach class, checking that getters and setters correctly store and retrieve breach data.

