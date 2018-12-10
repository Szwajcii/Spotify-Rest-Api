package java_advance.spring_boot_spotify.service;

import java_advance.spring_boot_spotify.model.User;

import java.util.List;

public interface UserServiceInterface {
    User getUserById(Long id);
    List<User> getAllUsers();
    void deleteUserById(Long id);
    void updateUserById(Long id);
    boolean addUser(User user);

}
