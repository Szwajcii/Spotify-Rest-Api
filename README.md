### Spotify Rest Api

   Spotify REST API is application built with spring boot framework and postgresql.

### Requirements

1. Use Spring Boot to create the project.
2. Define from 2 to 3 resources.
3. Handle CRUD operations on these resources.
4. Between two of available resources, relationship has to be defined.
5. You HAVE to use H2 or PostgreSQL database.
6. Keep separate concerns of your app - controller, service, repository.
7. Logging of every CRUD operation and exception to a text file using log4j.
8. Data should be safe deleted - archived instead of physically deleted. Users should not see archived data but the data should    be present in the database.

### Using the API (All paths returns response only in JSON format)

1. Download the package.
2. This project is based on postgreSQL, check the src/main/resources/application.properties file, which consists of crucial info to run our app, you should create database and user as the file configuration tells, but if you want to provide your own customization you should rebuild the project and run it from your IDE(If you do that you don't need to read rest of the points excluding 5-th) or you can extract project to jar and follow instructions.
3. Navigate to out/artifacts/spring_boot_project_Szwajcii_jar folder.
4. Use "java -jar spring-boot-project-Szwajcii.jar" command (Ubuntu terminal).
5. Use Postman or other software to feed API with your requests, the server is listening on http://localhost:8080.


**End points**

User:
```
GET /users = Display all users
GET /users/{id} = Display user by given id
POST /users/add.json = Add new user
DELETE /users/delete/{userId} = Delete user by given id
PUT /users/update/{id} = Update user by given id
```
Song:
```
GET /songs/all = Display all songs
GET /songs/{id} = Display song by given id
POST /songs/add = Add new song
DELETE /songs/archive/{id} = Delete song by given id
POST /songs/addtoplaylist = Add song to playlist
```
Playlist:
```
GET /playlist/* = Display all playlists
POST /playlistId/add/{playlistName} = Add new playlist
GET /playlist/{playlistId} = Display playlist by given id
GET /playlist/{playlistId}/{songName} = Display song from playlist by given song name and playlist id
DELETE /playlist/delete/{playlistId} = Delete playlist by given id
```
### Built with:
1. Maven - Dependency Management
2. Spring Boot
3. PostgresSQL

### Tools:
1. IntelliJ IDEA
2. pgAdmin III
3. Postman

### Authors: 
- Bartosz Pyrz [Github profile](https://github.com/Czakero)
- Dawid Grygier [Github profile](https://github.com/cyan0505)
- Damian Szwajkos [Github profile](https://github.com/Szwajcii)
