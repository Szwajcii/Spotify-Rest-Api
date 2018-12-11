package java_advance.spring_boot_spotify.service;

import java_advance.spring_boot_spotify.model.User;
import java_advance.spring_boot_spotify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements UserServiceInterface {
    private static final int FIRST_NAME_INDEX = 0;
    private static final int LAST_NAME_INDEX = 1;
    private static final int EMAIL_INDEX = 2;
    private static final int PHONE_INDEX = 3;

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
        user.setFirstName(userDetails.get(FIRST_NAME_INDEX));
        user.setLastName(userDetails.get(LAST_NAME_INDEX));
        user.setEmail(userDetails.get(EMAIL_INDEX));
        user.setPhone(userDetails.get(PHONE_INDEX));

        return userRepository.save(user);
    }

    @Override
    public User addUser(List<String> userDetails) {
        User user = new User(userDetails.get(FIRST_NAME_INDEX),
                            userDetails.get(LAST_NAME_INDEX),
                            userDetails.get(EMAIL_INDEX),
                            userDetails.get(PHONE_INDEX));

        return userRepository.save(user);
    }
}
