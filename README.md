# Registration Web Application

A simple web application for managing registrations using Java Servlets, JDBC, 
and MySQL. The application allows users to create, read, update, and delete registration 
records in a MySQL database.

## Features

- **Create**: Add new registration entries.
- **Read**: View all registrations.
- **Update**: Modify existing registration details.
- **Delete**: Remove a registration from the database.

## Technologies Used

- **Java**: The primary language for backend logic and servlets.
- **Servlets**: Used for handling HTTP requests and responses.
- **JDBC**: For database interaction.
- **MySQL**: The database management system used to store registration data.
- **Apache Tomcat**: The servlet container used to run the application.

## Prerequisites

Before running the application, ensure you have the following installed:

- **JDK 8+** (Java Development Kit)
- **Apache Tomcat 10.1** or later
- **MySQL Server** (with the appropriate JDBC driver)
- **Eclipse IDE** (or any other IDE that supports Java web development)
  
## Setup

### 1.  Set up MySQL Database


  To run this project, you will need to set up a MySQL database.
  Follow the steps below to create the database and the necessary table.

1. **Create the Database:**

   Run the following SQL query to create the database:

   SQL
   CREATE DATABASE registrationdb;


  USE registrationdb;

CREATE TABLE Registration (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Email VARCHAR(150) NOT NULL UNIQUE,
    DateOfBirth DATE NOT NULL,
    PhoneNumber VARCHAR(15),
    Address VARCHAR(255)
);

### 2. Configure Database Connection

** In the RegistrationDAO.java file, configure the database connection URL, username, and password:
      code--
                   private static final String JDBC_URL = "jdbc:mysql://localhost:3306/registrationdb";
                   private static final String JDBC_USER = "root";
                   private static final String JDBC_PASSWORD = "******";
    

### 3. Build and Run the Project

**Build the project: Right-click on the project > Build Project.
   Deploy to Tomcat both (deploy in server and run the program in console)
       Right-click the project > Run As > Java Application on the console.
