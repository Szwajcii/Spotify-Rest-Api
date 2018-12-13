package java_advance.spring_boot_spotify.repository;

import java_advance.spring_boot_spotify.model.Playlist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaylistRepository extends CrudRepository<Playlist, Long> {

    @Override
    List<Playlist> findAll();

}
