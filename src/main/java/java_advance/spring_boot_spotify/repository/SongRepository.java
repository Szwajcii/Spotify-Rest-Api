package java_advance.spring_boot_spotify.repository;

import java_advance.spring_boot_spotify.model.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends CrudRepository<Song, Long> {

    @Override
    @Query(value = "SELECT * FROM song WHERE active = true",
            nativeQuery = true)
    List<Song> findAll();

//    @Override
//    @Query(value = "SELECT * FROM song WHERE active = true AND id = ?1", nativeQuery = true)
//    Optional<Song> findById(Long id);


}
