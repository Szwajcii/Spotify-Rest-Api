package java_advance.spring_boot_spotify.controller;

import java_advance.spring_boot_spotify.controller.exception.ResourceNotFound;
import java_advance.spring_boot_spotify.controller.exception.SimilarResourceExistsOrWrongInput;
import java_advance.spring_boot_spotify.exceptionMessage.ClientMessage;
import java_advance.spring_boot_spotify.exceptionMessage.Message;
import java_advance.spring_boot_spotify.model.User;
import java_advance.spring_boot_spotify.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@RestController
public class UserController {
    private UserServiceInterface userServiceInterface;

    @Autowired
    public UserController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/users/{userId}", produces = "application/json")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        ResponseEntity<User> response;
        User user = userServiceInterface.getUserById(userId);
        if (user == null) {
            throw new ResourceNotFound("User not found!");
        } else {
            response = new ResponseEntity<>(user, HttpStatus.OK);
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/users/add.json", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> addUser(@RequestBody User newUser) {
        ResponseEntity<User> response;
        try {
            response = new ResponseEntity<>(userServiceInterface.addUser(newUser), HttpStatus.OK);
            return  response;

        } catch (Exception e) {
            throw new SimilarResourceExistsOrWrongInput("Similar user exists or provided info is wrong!");
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/users", produces = "application/json")
    public ResponseEntity<List<User>> getUsers() {
        ResponseEntity<List<User>> response;
        List<User> result = userServiceInterface.getAllUsers();
        response = new ResponseEntity<>(result, HttpStatus.OK);
        return response;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/users/delete/{userId}")
    public ResponseEntity deleteUser(@PathVariable Long userId) {
        ResponseEntity response;
        boolean isDeleted = userServiceInterface.deleteUserById(userId);
        if (isDeleted) {
            response = new ResponseEntity(HttpStatus.OK);
        } else {
            throw new ResourceNotFound("User not found!");
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/users/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> updateUser(@RequestBody User providedUpdatedUser) {
        ResponseEntity<User> response;
        User updatedUser = userServiceInterface.updateUserById(providedUpdatedUser);
        if (updatedUser == null) {
            throw new ResourceNotFound("User not found!");
        } else {
            response = new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
        return response;
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<Message> handleResourceNotFound(HttpServletRequest request, Exception exception) {
        Message message = new ClientMessage(new Timestamp(System.currentTimeMillis())
                , HttpStatus.NOT_FOUND
                , exception.getMessage(), request.getRequestURI()
                , "Provide proper user id, because there is no user with id like that.");
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SimilarResourceExistsOrWrongInput.class)
    public ResponseEntity<Message> handleSimilarResourceExistsOrWrongInput(HttpServletRequest request, Exception exception) {
        Message message = new ClientMessage(new Timestamp(System.currentTimeMillis())
                                            , HttpStatus.BAD_REQUEST
                                            , exception.getMessage()
                                            , request.getRequestURI()
                                            , "User like that already exists or email/phone don't match patterns email(50 char length)/phone(XXX-XXX-XXX)");
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}