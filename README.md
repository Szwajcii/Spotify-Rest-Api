# spring-boot-project-Szwajcii

### Spotify Rest Api

   Spotify REST API id application built with spring boot framework and postgresql.

### Requirements

1. Use Spring Boot to create the project.
2. Define from 2 to 3 resources.
3. Handle CRUD operations on these resources.
4. Between two of available resources, relationship has to be defined.
5. You HAVE to use H2 or PostgreSQL database.
6. Keep separate concerns of your app - controller, service, repository.
7. Logging of every CRUD operation and exception to a text file using log4j.
8. Data should be safe deleted - archived instead of physically deleted. Users should not see archived data but the data should    be present in the database

### Using the app

**End points**

User:
```
/users/* = Display all users
/users/{id} = Display user by given id
/users/add = Add new user
/users/delete = Delete user by given id
/users/update/{id} = Update user by given id

```
Song:
```
