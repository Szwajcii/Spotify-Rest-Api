package java_advance.spring_boot_spotify.service;

import java_advance.spring_boot_spotify.model.Playlist;
import java_advance.spring_boot_spotify.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongServiceInterface {
    Optional<Song> getSongById(Long id);
    List<Song> getAllSongs();
    void deleteSongById(Long id);
    Song addSong(List<String> songDetails);
    void archiveSong(Long id);
    void addSongToPLaylist(Long id, Playlist playlist);
}
