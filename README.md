# Hotel Management Website

This project is a comprehensive Hotel Management Web Application. It allows users to manage hotel reservations, send automated emails, handle specific booking conditions, and manage room statuses efficiently.

## Features

- **User Registration & Login**: Users can register and log in to the system.
- **Room Reservation**: Users can make room reservations.
- **Automated Email Notifications**: The system sends automated emails for booking confirmations, reminders, and other notifications.
- **Reservation Management**: Manage reservations with specific conditions.
- **Room Status Management**: View and update the status of hotel rooms.

## Technologies Used

- **Backend**: Java 21, Spring Boot (Spring Security, Spring Boot Web, Spring Boot Data JPA, Spring Boot Mail, Spring Boot Actuator, etc.)
- Maven
- Mapstruct
- Swagger
- Lombok
- JWT
- **Frontend**: Angular & Angular CLI 17.3.7, Javascript, Typescript
- Node.js
- **Database**: PostgreSQL

## Installation

### Prerequisites

- Java 11 or later
- Node.js and npm
- PostgreSQL database

### Backend Setup

1. Clone the repository:
    ```sh
    git clone https://github.com/ulasahin/HotelManagementWebSite.git
    cd HotelManagementWebSite/backend
    ```

2. Update the `application.properties` file with your PostgreSQL database configuration:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/HotelManagementWebSiteDB
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

3. Build and run the Spring Boot application:
    ```sh
    ./mvnw spring-boot:run
    ```

### Frontend Setup

1. Navigate to the frontend directory:
    ```sh
    cd ../frontend
    ```

2. Install dependencies:
    ```sh
    npm install
    ```

3. Start the Angular development server:
    ```sh
    ng serve
    ```

4. Open your browser and navigate to `http://localhost:4200`.
