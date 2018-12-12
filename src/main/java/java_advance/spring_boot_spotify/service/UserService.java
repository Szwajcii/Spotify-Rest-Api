package java_advance.spring_boot_spotify.service;

import java_advance.spring_boot_spotify.model.User;
import java_advance.spring_boot_spotify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements UserServiceInterface {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public void updateUserById(Long id) {

    }

    @Override
    public boolean addUser(User user) {
        return false;
    }
}
