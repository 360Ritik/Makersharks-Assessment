# Makersharks Application

## Overview

The Makersharks application is a Spring Boot-based service that manages suppliers. It provides endpoints to search for
suppliers and add new suppliers to the system. The application uses `springdoc-openapi` to generate OpenAPI
documentation and provides a Swagger UI for interactive API exploration.

## Watch the Demonstration Video

https://github.com/user-attachments/assets/09029001-7362-4194-80b5-19f4772693f2

## Prerequisites

- Java 17 or higher
- Maven (for building the project)

## Build the Application

To build the application using Maven, run:

- mvn clean install

## Run the Application Locally

To run the application locally, use:

- mvn spring-boot:run

## Configure the Database

- The application uses PostgreSQL as the database.
- You need to configure the database connection details in the src/main/resources/application.properties file.
- Update the database connection properties with your PostgreSQL credentials.

## OpenAPI Documentation

To get Swagger UI documentation, just visit this :

- URL: http://localhost:8080/swagger-ui/index.html#/

## Project Setup

### Clone the Repository

```bash
git clone https://github.com/360Ritik/Makersharks-Assessment.git
cd makersharks
