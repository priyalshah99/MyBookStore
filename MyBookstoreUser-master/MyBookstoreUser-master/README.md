# MyBookstoreUser
Book Store Project For User Side.
A fully functional full-stack E-commerce Web Application developed using Spring Boot, Hibernate, MySQL, Thymeleaf, Bootstrap.

<img src="src/main/resources/static/img/logo.png" height=60px width=150>

## Requirements
1. JDK 1.8
2. MySQL 5.5
3. Spring Tool Suite 4 
4. Lombok JAR with installation in STS 4
5. https://github.com/abhishekshah27/MyBookstoreAdmin (It should be configured and running simultaneously.)

## IMPORTANT NOTE
This Setup is common for both of this repositories. So do it for one time only.
1. https://github.com/abhishekshah27/MyBookstoreAdmin
2. https://github.com/abhishekshah27/MyBookstoreUser

## Steps to Setup

**1. First setup JDK8, MySQL5.5, STS4 and Lombok.**

**2. Clone both of this applications**

```bash
git clone https://github.com/abhishekshah27/MyBookstoreAdmin
git clone https://github.com/abhishekshah27/MyBookstoreUser
```

**3. Create MySQL database**
```bash
create database MyBookstore
```

**4. Change MySQL username and password as per your installation**
+ open `src/main/resources/application.properties` in both of the applications.
+ change `connection URL`, `username` and `password` as per your MySQL configuration in both of the applications.

**5. Now you can run the app using maven for both the applications from CMD**
```bash
mvnw spring-boot:run
```

**6. Open your chrome browser and visit the below URLs** 
+ **It is required to run ADMIN project first and then the USER project.**
+ The ADMIN appication will start running at <http://localhost:8081/adminportal>.
+ The USER appication will start running at <http://localhost:8080>.

## Application Logins

Initially there are 2 users in memory:

ID: ```admin``` Password: ```admin``` with **ADMIN** role.

ID: ```abhi``` Password: ```1234``` with **USER** role.

## Roles

**ADMIN** can manage books.

**USER** can add books to shopping cart and buy them.


## Functionalities [ADMIN]
+ Add/update books in the database.
+ Activate or deactivate a book.
+ View orders.

## Functionalities [USER]
+ Register with email verification and login accordingly.
+ Browse all the books according to their favourable category.
+ Search a specific book by title.
+ Manage profile and change the password.
+ Manage shipping and billing addresses, add and update payment card details.
+ Add books to cart and check out by confirming address and payment details.
+ Use forget password Facility.
+ Get confirmation email after ordering the books .
+ Check previous orders.



## Authors
+ <a href="https://github.com/abhishekshah27/">Abhishek Shah</a>
+ <a href="https://github.com/priyalshah99/">Priyal Shah</a>

## License
This project is not licensed as it is made for educational purpose only. You can use and learn from it for free.😊
