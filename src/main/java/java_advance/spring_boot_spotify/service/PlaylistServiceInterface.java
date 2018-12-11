package java_advance.spring_boot_spotify.service;

import java_advance.spring_boot_spotify.model.Playlist;
import java_advance.spring_boot_spotify.model.Song;
import java_advance.spring_boot_spotify.model.User;

import java.util.List;

public interface PlaylistServiceInterface {

    List<Playlist> getAllPlaylists();
    List<Song> getSongByName(String name);
    Iterable<Song> getAllSongs();
    List<Playlist> getPlaylistsByUserId(int userId);
    void deleteSongByName(String songName);

}
