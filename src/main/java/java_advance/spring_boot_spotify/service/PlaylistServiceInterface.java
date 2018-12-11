package java_advance.spring_boot_spotify.service;

import java_advance.spring_boot_spotify.model.Playlist;
import java_advance.spring_boot_spotify.model.Song;

import java.util.List;
import java.util.Optional;

public interface PlaylistServiceInterface {

    List<Playlist> getAllPlaylists();
    List<Song> getSongByName(Long playlistId, String name);
    Iterable<Song> getAllSongs(Long playlistId);
    Optional<Playlist> getPlaylistsByUserId(Long userId);
    void deleteSongByName(Long playlistId, String songName);

}
