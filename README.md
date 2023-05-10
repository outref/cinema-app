
# <img src="https://raw.githubusercontent.com/outref/readme-recources/main/cinema.png"  width="48" height="55"> Cinema App
```
RESTful, API-based movie theater application that implements authentication and
authorization with Spring Security.
```
## 🚀 Demo
To avoid the hassle of running the application locally to try it out, you can use deployed demo by this address: http://13.48.85.241:8080/cinema-app  
Postman collection - [Endpoints for testing](https://www.postman.com/outref/workspace/workspace/collection/26840886-893bc5e7-be31-4bd1-b703-59cd15cd19b4)

## 🔐 Security
Application implements Basic Auth scheme, which means that user's email and password have to be sent with every HTTP-request inside of a Authorization header (encoded in Base64). 
This can be easily configured in Postman on Authorization tab for testing purposes.

At launch application injects two default users into DB:

[ADMIN] - admin@i.ua - admin123

[USER] - user@i.ua - user123

They can be used for testing both locally or in demo app. 


## 🎯 Features (API endpoints)
- `POST /register`   [Non-authorized] : register new user ->  
*{"email":"test@email.com", "password":"12345678", "repeatPassword":"12345678"}*
- `GET /cinema-halls`  [USER or ADMIN] : get list of all cinema halls
- `GET /movie-sessions/available?movieId=1&date=01.01.2023`  
  [USER or ADMIN] : get list of sessions for given movie and day
- `GET /users/by-email?email=some@email.com` [ADMIN] : get user's info
- `GET /orders` [USER] : get user's order history
- `GET /shopping-carts/by-user` [USER] : retrieve user's shopping cart
- `PUT /shopping-carts/movie-sessions?movieSessionId=1`  
  [USER] : add a ticket of given movie session to the shopping cart
- `POST /orders/complete` [USER] : complete (create) order from shopping cart
- `POST /movies` [ADMIN] : add new movie ->  
  *{"title":"some movie", "description":"some description"}*
- `POST /cinema-halls` [ADMIN] : add new cinema hall ->  
  *{"capacity":"50", "description":"some description"}*
- `POST /movie-sessions` [ADMIN]  : add new movie session ->  
  *{"movieId":"1", "cinemaHallId":"1", "showTime":"2023-01-01T09:00:00.000"}*
- `PUT /movie-sessions/{id}` [ADMIN]  : update movie session with given id ->  
  *{"movieId":"1", "cinemaHallId":"1", "showTime":"2023-01-01T09:00:00.000"}*
- `DELETE /movie-sessions/{id}`  [ADMIN]  : delete movie session with given id

Feel free to change example values in request bodies or params and test the app using Postman or similar tool.

## 📖 Structure
![structure](https://raw.githubusercontent.com/outref/readme-recources/main/cinema-structure.png)
- <b> config/ </b> - contains <b>Spring</b>, <b>Spring MVC</b> and <b>Spring Security</b> config classes
- <b> controller/ </b> - all the <b>@RestControllers</b> containing application's endpoints
- <b> dao/ </b> - contains all the Dao classes to perform operations on the DB.
- <b> dto/ </b> - package with <b>DTO</b> classes used for communication between application and API withouth exposing the models. 
- <b> exception/ </b> - holds all custom exception classes.
- <b> lib/ </b> - contains custom validators.
- <b> model/ </b> - model classes, main entities used in application: <b> Movie </b> + <b> CinemaHall </b> + <b> MovieSession </b>, <b> ShoppingCart </b> + <b> Order </b> + <b> Ticket </b>, <b> User </b> + <b> Role </b>.
- <b> security/ </b> - holds <b>CustomUserDetailsService</b> class that builds UserDetails object based on clients input during authentication.
- <b> service/ </b> - service layer of the application, also including mappers that turn models into DTOs and vice versa.
- <b> util/ </b> - contains utility classes.

Application is structured according to N-Tier structure pattern with Presentation, Service and Data layers.

## 🤖 Technologies
- <b>Java `17`</b>
- <b>Spring `5.3.20`</b> for dependency injection.
- <b>Spring MVC </b> to create RESTful endpoints.
- <b>Spring Security `5.6.10`</b> to implement authorization and authentication.
- <b>Hibernate `5.6.14.Final`</b> for relational DB connection.
- Deployed using <b>Apache Tomcat `9.0.73`</b> running om Amazon <b>AWS EC2</b> instance and <b>RDS MySQL</b> database.

## ⚙️ How to run locally
1.  Clone this repository to your local machine using `git clone`.
2.  Navigate to the project directory using `cd <path to directory>/taxi-service`.
3.  Ensure that you have Java, Apache Tomcat and any relational DB management system (like MySQL) installed on your system.
4.  Configure the database settings in `src/main/resources/db.properties`.
5. Build the application using `mvn package`.
6.  Copy the generated WAR file to the `webapps/` directory of your Tomcat installation and rename it to `taxi-service.war` .
7.  Start Tomcat by running the `startup.sh` (or `startup.bat` on Windows) script in the `bin/` directory of your Tomcat installation.
8.  Use Postman or similar tool to test the endpoints.
