package java_advance.spring_boot_spotify.service;

import java_advance.spring_boot_spotify.model.Playlist;
import java_advance.spring_boot_spotify.model.Song;
import java_advance.spring_boot_spotify.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService implements PlaylistServiceInterface{

    private PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository){
        this.playlistRepository = playlistRepository;
    }

    @Override
    public List<Playlist> getAllPlaylists(){
        return (List<Playlist>) this.playlistRepository.findAll();
    }

    @Override
    public List<Song> getSongByName(Long playlistId, String name) {
        return this.playlistRepository.findById(playlistId).getPlaylistSongs().get(name);
    }

    @Override
    public Iterable<Song> getAllSongs(Long playlistId) {
        return this.playlistRepository.findById(playlistId).getPlaylistSongs();
    }

    @Override
    public Optional<Playlist> getPlaylistsByUserId(Long userId) {
        return this.playlistRepository.findById(userId);
    }

    @Override
    public void deleteSongByName(Long playlistId, String songName) {
        this.playlistRepository.findById(playlistId).getPlaylistSongs().remove(songName);
    }
}
