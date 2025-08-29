# 🫆 DataBreachTracker-API

Every day, companies experience data breaches that expose sensitive personal and business information — sometimes affecting millions of people.

The Data Breach Tracker makes information about these breaches accessible to different audiences:

1. For researchers, developers, and cybersecurity enthusiasts.

    As a cybersecurity enthusiast or developer, I want to use this API to access and manage data breach records so that I can analyse trends, build dashboards, or integrate the information into my own tools.

2. For the general public.

    As a member of the general public, I want to access a simple, user-friendly interface (planned for the future) that keeps me informed about data breaches, so I can understand their scale and impact without needing technical knowledge.

## 🕵 What the API Tells You

    📌 Which companies had a data breach

    📌 What kind of information was lost

    📌 When the breach happened

## ✴️ Features

    🔍 View all cybersecurity breaches

    🔍 Retrieve a breach by ID

    ➕ Add new breach records

    ✏️ Update existing breach records

    ❌ Delete breach records

    ⚡ Fully functional with a MySQL database

    ⚠️ Exception handling with helpful error responses

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
| Method | Endpoint                          | Description                     |
|--------|----------------------------------|---------------------------------|
| GET    | `/api/breaches`                     | Get all breaches                |
| GET    | `/api/breaches?organisation={name}`| Filter breaches by organisation |
| GET    | `/api/breaches/{id}`                | Get a breach by ID              |
| POST   | `/api/breaches`                     | Add a new breach                |
| PUT    | `/api/breaches/{id}`                | Update a breach                 |
| DELETE | `/api/breaches/{id}`                | Delete a breach                 |

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

Keeps and finds breach records in the database. Helps the app look up breaches quickly.

### 📁 BreachService.java	          

Decides how to handle breach information. Adds new breaches, updates them, finds them, or deletes them.

### 📁 BreachController.java	

Handles requests from users or apps. Lets people see, add, change, or remove breach information.

### 📁 BreachNotFoundException.java	

Shows an error message if someone tries to get a breach that doesn’t exist.

### 📁 GlobalExceptionHandler.java	

Catches errors and sends easy-to-read messages back to the user.

### 📁 DataBreachTrackerApplication.java	

Starts the DataBreachTracker app so it can run and show information about breaches.

