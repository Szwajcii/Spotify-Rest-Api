package java_advance.spring_boot_spotify.service;

import java_advance.spring_boot_spotify.model.User;
import java_advance.spring_boot_spotify.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements UserServiceInterface {

    private static final String[] IGNORED_PROPERTIES_FOR_USER_UPDATE = {"playlists", "archived"};

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
    public boolean deleteUserById(Long id) {
        if (!(getUserById(id) == null)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User updateUserById(User providedUpdatedUser) {
        User dbUser = userRepository.findById(providedUpdatedUser.getUserId()).orElse(null);
        if (dbUser == null) {
            return null;
        } else {
            BeanUtils.copyProperties(providedUpdatedUser, dbUser, IGNORED_PROPERTIES_FOR_USER_UPDATE);
        }
        return userRepository.save(dbUser);
    }

    @Override
    public User addUser(User newUser) {
        return userRepository.save(newUser);
    }
}
