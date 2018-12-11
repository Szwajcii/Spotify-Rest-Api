package java_advance.spring_boot_spotify.service;

import java_advance.spring_boot_spotify.model.Playlist;
import java_advance.spring_boot_spotify.model.Song;

import java.util.List;
import java.util.Optional;

public interface PlaylistServiceInterface {

    Playlist addNewPlaylist(String playlistName);
    void deletePlaylist(Long playlistId);
    List<Playlist> getAllPlaylists();
    List<Song> getSongByName(Long playlistId, String name);
    Iterable<Song> getAllSongsFromPlaylist(Long playlistId);
    Optional<Playlist> getPlaylistsByUserId(Long userId);
    void deleteSongByName(String songName);

}
