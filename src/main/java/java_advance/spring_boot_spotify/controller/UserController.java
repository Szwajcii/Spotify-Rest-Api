package java_advance.spring_boot_spotify.controller;

import java_advance.spring_boot_spotify.model.User;
import java_advance.spring_boot_spotify.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private UserServiceInterface userServiceInterface;

    @Autowired
    public UserController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/users/add")
    public User addUser(@RequestParam("firstName") String firstName,
                                  @RequestParam("lastName") String lastName,
                                  @RequestParam("email") String email,
                                  @RequestParam("phone") String phone)
    {
        List<String> userDetails = new ArrayList<>();
        userDetails.add(firstName);
        userDetails.add(lastName);
        userDetails.add(email);
        userDetails.add(phone);

        return userServiceInterface.addUser(userDetails);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public List<User> getUsers() {
        return userServiceInterface.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/users/delete")
    public void deleteUser(@RequestParam("id") Long id) {
        userServiceInterface.deleteUserById(id);

    }

//    @RequestMapping(method = RequestMethod.PUT, path = "/users/update")
//    public User updateUser(@RequestParam("id") Long id, @RequestParam(""))
}
