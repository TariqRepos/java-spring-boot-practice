# Java Spring Boot and Postgresql practice with creating a student management system

The application will be able to manage students in a system with the ability to add, delete, and update students from the postgresql database

## Overview
There are 3 layers for the porject:
- API layer to handle REST APIs
- Service/business layer for server side logic
- Data access layer to interface with the database

![image](https://user-images.githubusercontent.com/104251502/173170155-3dc48103-0023-4f54-9406-1007cae51144.png)

## REST APIs

### GET

`http://localhost:8080/api/v1/student`

### POST

`http://localhost:8080/api/v1/student`

{
    "name": "Tom",
    "email": "tom@gmail.com",
    "dob": "1998-02-16"
}

### DELETE

`http://localhost:8080/api/v1/student/1`

### PUT
`http://localhost:8080/api/v1/student/2?name=Bob&email=bob@gmail.com`

## Credits and Thanks
Lastly I wanted to provide thanks to Amigoscode for the great tutorial. I have provided a link to his website here: https://amigoscode.com/
