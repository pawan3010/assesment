# Assessment Project

This is a **Spring Boot + MySQL** project that demonstrates **CRUD (Create, Read, Update, Delete) operations**.  
It is built using **Java** and **IntelliJ IDEA**, with **Maven** for dependency management.

---

## 🚀 How to Run the Project

### 1. Clone the Repository
```bash
git clone https://github.com/pawan3010/assesment.git
cd assesment

2. Create the Database

Open MySQL and run:

CREATE DATABASE store_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

###3. Configure Database Credentials

Edit the file: src/main/resources/application.properties

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/store_db
spring.datasource.username="YOUR_DB_USERNAME"
spring.datasource.password="YOUR_DB_PASSWORD"
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver



YOUR_DB_USERNAME → your MySQL username (default is root)
YOUR_DB_PASSWORD → your MySQL password

####4. Run the Project

You have two options:

▶ Option 1: Run with Maven
mvn spring-boot:run

▶ Option 2: Run with IntelliJ

Open the project in IntelliJ IDEA

Navigate to the main class (with @SpringBootApplication)

Click the Run ▶ button

