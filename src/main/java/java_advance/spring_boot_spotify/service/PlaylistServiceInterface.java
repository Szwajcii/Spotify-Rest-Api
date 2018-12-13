package java_advance.spring_boot_spotify.service;

import java_advance.spring_boot_spotify.model.Playlist;
import java_advance.spring_boot_spotify.model.Song;

import java.util.List;

public interface PlaylistServiceInterface {

    Playlist addNewPlaylist(String playlistName);
    Playlist getPlaylistById(Long playlistId);
    void deletePlaylist(Long playlistId);
    List<Playlist> getAllPlaylists();
    List<Song> getSongByName(Long playlistId, String name);
    Iterable<Song> getAllSongsFromPlaylist(Long playlistId);
    void deleteSongByName(String songName);
    void archivePlaylist(Long playlistId);

}
