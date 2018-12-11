package java_advance.spring_boot_spotify.service;

import java_advance.spring_boot_spotify.model.Playlist;
import java_advance.spring_boot_spotify.model.Song;
import java_advance.spring_boot_spotify.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService implements PlaylistServiceInterface{

    private PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository){
        this.playlistRepository = playlistRepository;
    }

    @Override
    public List<Song> getSongByName(String name) {
        return null;
    }

    @Override
    public Iterable<Song> getAllSongs() {
        return null;
    }

    @Override
    public List<Playlist> getPlaylistsByUserId(int userId) {
        return null;
    }

    @Override
    public void deleteSongByName(String songName) {

    }
}
