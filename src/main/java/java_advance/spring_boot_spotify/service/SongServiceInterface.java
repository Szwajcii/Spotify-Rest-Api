package java_advance.spring_boot_spotify.service;

import java_advance.spring_boot_spotify.model.Playlist;
import java_advance.spring_boot_spotify.model.Song;

import java.util.List;

public interface SongServiceInterface {
    Song getSongById(Long id);
    List<Song> getAllSongs();
    Song safeDeleteSongById(Long id);
    Song addSong(List<String> songDetails);
    void addSongToPLaylist(Long id, Playlist playlist);
}
