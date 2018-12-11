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
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUserById(Long id, List<String> userDetails) {
        User user = userRepository.findById(id).orElse(null);
        user.setFirstName(userDetails.get(0));
        user.setLastName(userDetails.get(1));
        user.setEmail(userDetails.get(2));
        user.setPhone(userDetails.get(3));

        return userRepository.save(user);
    }

    @Override
    public User addUser(List<String> userDetails) {
        User user = new User(userDetails.get(0), userDetails.get(1), userDetails.get(2), userDetails.get(3));

        return userRepository.save(user);
    }
}
