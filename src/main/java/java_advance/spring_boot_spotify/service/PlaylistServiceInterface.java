package java_advance.spring_boot_spotify.service;

import java_advance.spring_boot_spotify.model.Playlist;
import java_advance.spring_boot_spotify.model.Song;

import java.util.List;

public interface PlaylistServiceInterface {

    Playlist addNewPlaylist(String playlistName);
    Playlist getPlaylistById(Long playlistId);
    boolean deletePlaylistById(Long playlistId);
    List<Playlist> getAllPlaylists();
    List<Song> getSongByNameFromPlaylist(Long playlistId, String name);
    Iterable<Song> getAllSongsFromPlaylist(Long playlistId);
    boolean deleteSongByNameFromPlaylist(Long playlistId, Long songId);

}
