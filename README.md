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
/users/add.json = Add new user
/users/delete/{userId} = Delete user by given id
/users/update/{id} = Update user by given id
```
Song:
```
/songs/all = Display all songs
/songs/all/{id} = Display song by given id
/songs/add = Add new song
/songs/archive/{id} = Delete song by given id
/songs/addtoplaylist = Add song to playlist
```
Playlist:
```
/playlist/* = Display all playlists
/playlistId/add/{playlistName} = Add new playlist
/playlist/{playlistId} = Display playlist by given id
/playlist/{playlistId}/{songName} = Display song from playlist by given song name and playlist id
/playlist/delete/{playlistId} = Delete playlist by given id
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

### More information:
Project was created for **Codecool** programming course.











