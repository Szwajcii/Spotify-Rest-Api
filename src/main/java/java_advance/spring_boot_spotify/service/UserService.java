package java_advance.spring_boot_spotify.service;

import java_advance.spring_boot_spotify.model.User;
import java_advance.spring_boot_spotify.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceInterface {

    private static final String[] IGNORED_PROPERTIES_FOR_USER_UPDATE = {"playlists", "archived"};

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        User searchedUser = userRepository.findById(id).orElse(null);
        if (!(searchedUser == null)) {
            if (searchedUser.isArchived()) {
                return null;
            }
        }
        return searchedUser;
    }

    @Override
    public List<User> getAllUsers() {
       return userRepository.findAll()
               .stream()
               .filter(e -> !e.isArchived())
               .collect(Collectors.toList());
    }

    @Override
    public boolean deleteUserById(Long id) {
        User archivedUser = getUserById(id);
        if (!(archivedUser == null)) {
            archivedUser.setArchived(true);
            userRepository.save(archivedUser);
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
