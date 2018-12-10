package java_advance.spring_boot_spotify.repository;

import java_advance.spring_boot_spotify.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
