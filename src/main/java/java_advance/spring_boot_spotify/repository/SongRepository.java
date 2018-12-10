package java_advance.spring_boot_spotify.repository;

import java_advance.spring_boot_spotify.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
}
