# Loan Decision Engine 🚀

Simple full-stack application for processing loan requests based on personal credit modifiers.

## 🛠 Tech Stack
* **Backend:** Java 21, Spring Boot 3, Spring Data JPA
* **Database:** H2 (In-memory) 
* **Frontend:** React

## 📋 Features
* Decision engine based on `creditScore = (modifier / amount) * period`.
* Automatic calculation of the maximum possible amount if the requested one is too high.
* Automatic search for an alternative loan period if the requested one is rejected.
* Validation for personal codes, amounts (2000-10000 €), and periods (12-60 months).

## 🚀 Getting Started

### Backend (Spring Boot)
1.  Navigate to the backend folder.
2.  Run `./mvnw spring-boot:run` or start the application from your IDE.
3.  The H2 Console is available at: `http://localhost:8080/h2-console`
    * **JDBC URL:** `jdbc:h2:mem:loandb`
    * **User:** `sa` | **Pass:** ``

### Frontend (React)
1.  Navigate to the frontend folder.
2.  Install dependencies: `npm install`
3.  Start the app: `npm start`
4.  The app will be available at: `http://localhost:3000`

### 💡 Improvements for the future
* As part of the assignment reflection, I identified that the Error Handling could be improved by:
* **Implementing a Global Exception Handler on the backend to provide more descriptive error codes.
* **Adding asynchronous validation to the frontend for better UX.
* **Using Zod/Yup for schema-based validation to ensure data integrity between layers.
