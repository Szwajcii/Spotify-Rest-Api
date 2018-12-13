package java_advance.spring_boot_spotify.repository;

import java_advance.spring_boot_spotify.model.Playlist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PlaylistRepository extends CrudRepository<Playlist, Long> {

    @Override
    @Query(value = "SELECT * FROM playlist p WHERE p.active = true",
            nativeQuery = true)
    List<Playlist> findAll();

    @Override
    @Query(value = "SELECT * FROM playlist p WHERE p.active = true AND p.playlistId = ?1",
            nativeQuery = true)
    Optional<Playlist> findById(Long id);

}
