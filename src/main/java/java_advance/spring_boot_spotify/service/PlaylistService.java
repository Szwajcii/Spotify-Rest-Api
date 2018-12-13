package java_advance.spring_boot_spotify.service;

import java_advance.spring_boot_spotify.controller.exception.ResourceNotFound;
import java_advance.spring_boot_spotify.model.Playlist;
import java_advance.spring_boot_spotify.model.Song;
import java_advance.spring_boot_spotify.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistService implements PlaylistServiceInterface{

    private PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository){
        this.playlistRepository = playlistRepository;
    }

    @Override
    public Playlist addNewPlaylist(String playlistName) {
        Playlist playlist = new Playlist(playlistName);
        this.playlistRepository.save(playlist);
        return playlist;
    }

    @Override
    public Playlist getPlaylistById(Long playlistId) {
        Playlist playlist = this.playlistRepository.findById(playlistId).orElse(null);

        if (playlist == null || !playlist.isActive()) {
            throw new ResourceNotFound("Playlist not found!");
        }

        return playlist;
    }

    @Override
    public void deletePlaylist(Long playlistId) {
        this.playlistRepository.deleteById(playlistId);
    }

    @Override
    public List<Playlist> getAllPlaylists(){
        return this.playlistRepository.findAll();
    }

    @Override
    public List<Song> getSongByNameFromPlaylist(Long playlistId, String name) {
        return this.playlistRepository.findById(playlistId).orElse(null).getPlaylistSongs();
    }

    @Override
    public Iterable<Song> getAllSongsFromPlaylist(Long playlistId) {
        return this.playlistRepository.findById(playlistId).orElse(null).getPlaylistSongs();
    }


    @Override
    public void deleteSongByNameFromPlaylist(String songName) {

    }

    @Override
    public void archivePlaylist(Long playlistId) {
        this.playlistRepository.findById(playlistId).orElse(null).setActive(false);
    }
}
