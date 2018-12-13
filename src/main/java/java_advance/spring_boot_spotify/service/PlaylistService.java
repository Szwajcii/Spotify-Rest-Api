package java_advance.spring_boot_spotify.service;

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
        return this.playlistRepository.findById(playlistId).orElse(null);
    }

    @Override
    public void deletePlaylist(Long playlistId) {
        this.playlistRepository.deleteById(playlistId);
    }

    @Override
    public List<Playlist> getAllPlaylists(){
        List<Playlist> playlistList = this.playlistRepository.findAll();
        List<Playlist> activePlaylists = new ArrayList<>();

        for(Playlist playlist : playlistList){
            if(playlist.isActive()){
                activePlaylists.add(playlist);
            }
        }

        return activePlaylists;
    }

    @Override
    public List<Song> getSongByName(Long playlistId, String name) {
        List<Song> songList = this.playlistRepository.findById(playlistId).orElse(null).getPlaylistSongs();

        List<Song> songs = new ArrayList<>();

        for(Song song : songList){
            if(song.getName().equals(name)){
                songs.add(song);
            }
        }
        return songs;
    }

    @Override
    public Iterable<Song> getAllSongsFromPlaylist(Long playlistId) {
        return this.playlistRepository.findById(playlistId).orElse(null).getPlaylistSongs();
    }


    @Override
    public void deleteSongByName(String songName) {

    }

    @Override
    public void archivePlaylist(Long playlistId) {
        this.playlistRepository.findById(playlistId).orElse(null).setActive(false);
    }
}
