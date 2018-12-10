package java_advance.spring_boot_spotify.repository;

import java_advance.spring_boot_spotify.model.Playlist;
import org.springframework.data.repository.CrudRepository;

public interface PlaylistRepository extends CrudRepository<Playlist, Long> {


}
