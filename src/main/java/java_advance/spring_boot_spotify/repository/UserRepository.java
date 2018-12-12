package java_advance.spring_boot_spotify.repository;

import java_advance.spring_boot_spotify.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
