# Library Management System
By using APIs we can add book, user and also user can borrow a book and return it.

### System Requirement 
- Java 8 or Higher
- Maven version 3.x.x preferred
- Any Java development IDE with Spring Boot support (Intellij preferred)
- Using H2 in memory database where user name is ```sa``` and password is ```password```
- Use Postman or any rest client to hit the APIs
- Default port of application is 8080, it can change by adding ```server.port=XXXX``` in application.properties file

### To build the project use at root of project
    mvn clean install
#### To Run the Application need to start ```LibraryApplication``` file 

## Curl Request which using CMD or Terminal

### Get Books Curl
```bash
curl --location --request GET 'http://localhost:8080/getBooks'
```

### Post request 
```bash
curl --location --request POST 'http://localhost:8080/addBook' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Books Introduction to Computer",
    "author": "Amit Garg",
    "publication": "Readers Zone",
    "year_of_publication": "2015",
    "isbn_no": "978935019611",
    "quantity": 1
}'
```
### Post calls to add user 
```bash
curl --location --request POST 'http://localhost:8080/addUser' \
--header 'Content-Type: application/json' \
--data-raw '{
    "address": "Dubai",
    "libraryCardNumber": "L23",
    "name": "Aman Patil"
}'
```

### Post calls to add book

```bash
curl --location --request POST 'http://localhost:8080/addBook' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Books Introduction to Computer",
    "author": "Amit Garg",
    "publication": "Readers Zone",
    "year_of_publication": "2015",
    "isbn_no": "978935019611",
    "quantity": 10
}'
```

### Post calls to Borrow a book using user id and book id
```bash
curl --location --request POST 'http://localhost:8080/borrowBook' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userId": "1",
    "bookId": 1
}'
```

### Post calls to return a books using list of book and user ids pair

```bash
curl --location --request POST 'http://localhost:8080/returnBook' \
--header 'Content-Type: application/json' \
--data-raw '[{
    "userId": "1",
    "bookId": 1
}]'
```