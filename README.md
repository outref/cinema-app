# <img src="https://raw.githubusercontent.com/outref/readme-recources/main/cinema.png"  width="48" height="55"> Cinema App
```
RESTful, API-based movie theater application that implements authentication and
authorization with Spring Security.
```
## 🚀 Demo
To avoid the hassle of running the application locally to try it out, you can use deployed demo by this address: http://13.48.85.241:8080/cinema-app


## 🎯 Features (API endpoints)
<b> HTTP-method -- /endpoint -- [Authorized roles] -- Feature description </b>

- `POST /register`   [Non-authorized] : register new user
- `GET /cinema-halls`  [USER or ADMIN] : get list of all halls
- `GET /movie-sessions/available`  [USER or ADMIN] : get list of sessions for given movie and day
- `GET /users/by-email` [ADMIN] : get user's info
- `GET /orders/shopping-carts/by-user` [USER] : get user's order history
- `PUT /shopping-carts/movie-sessions` [USER]  - add a ticket of given movie session to the shopping cart
- `POST /orders/complete` [USER] : complete (create) order from shopping cart
- `POST /movies` [ADMIN] : add new movie
- `POST /cinema-halls` [ADMIN] : add new cinema hall
- `POST /movie-sessions` [ADMIN]  : add new movie session
- `PUT /movie-sessions` [ADMIN]  : update movie session
- `DELETE /movie-sessions`  [ADMIN]  : delete movie session

## 📖 Structure
![structure](https://raw.githubusercontent.com/outref/readme-recources/main/cinema-structure.png)
- <b> config/ </b> - contains <b>Spring</b>, <b>Spring MVC</b> and <b>Spring Security</b> config classes
- <b> controller/ </b> - all the <b>@RestControllers</b> containing application's endpoints
- <b> dao/ </b> - contains all the Dao classes to perform operations on the DB.
- <b> dto/ </b> - package with <b>DTO</b> classes used for communication between application and API withouth exposing the models. 
- <b> exception/ </b> - holds all custom exception classes.
- <b> lib/ </b> - contains custom validators.
- <b> model/ </b> - model classes, main entities used in application: <b> Movie </b> -- <b> CinemaHall </b> -- <b> MovieSession </b>, <b> ShoppingCart </b> -- <b> Order </b> -- <b> Ticket </b>, <b> User </b> -- <b> Role </b>.
- <b> security/ </b> - holds <b>CustomUserDetailsService</b> class that builds UserDetails object based on clients input during authentication.
- <b> service/ </b> - service layer of the application, also including mappers that turn models into DTOs and vice versa.
- <b> util/ </b> - contains utility classes.

Application is structured according to N-Tier structure pattern with Presentation, Service and Data layers.

## 🤖 Technologies
- <b>Java</b>
- <b>Spring</b> for dependency injection.
- <b>Spring MVC </b> to create RESTful endpoints.
- <b>Spring Security</b> to implement authorization and authentication.
- <b>Hibernate</b> for relational DB connection.
- Deployed using <b>Apache Tomcat</b> running om Amazon <b>AWS EC2</b> instance and <b>RDS MySQL</b> database.

## ⚙️ How to run locally
1.  Clone this repository to your local machine using `git clone`.
2.  Navigate to the project directory using `cd <path to directory>/taxi-service`.
3.  Ensure that you have Java, Apache Tomcat and any relational DB management system (like MySQL) installed on your system.
4.  Configure the database settings in `src/main/resources/db.properties`.
5. Build the application using `mvn package`.
6.  Copy the generated WAR file to the `webapps/` directory of your Tomcat installation and rename it to `taxi-service.war` .
7.  Start Tomcat by running the `startup.sh` (or `startup.bat` on Windows) script in the `bin/` directory of your Tomcat installation.
8.  Use Postman or similar tool to test the endpoints.


