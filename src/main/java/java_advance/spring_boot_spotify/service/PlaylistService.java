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
    private SongService songService;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository, SongService songService){
        this.playlistRepository = playlistRepository;
        this.songService = songService;
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
            return null;
        }

        return playlist;
    }

    @Override
    public boolean deletePlaylistById(Long playlistId) {
        Playlist archivedPlaylist = getPlaylistById(playlistId);
        if(archivedPlaylist != null){
            archivedPlaylist.setActive(true);
            playlistRepository.save(archivedPlaylist);
            return true;
        } else {
            return false;
        }
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
    public boolean deleteSongByNameFromPlaylist(Long playlistId, Long songId) {

        Playlist playlist = getPlaylistById(playlistId);

        if(playlist != null) {
            for (Song song : playlist.getPlaylistSongs()) {
                if ((song.getSongId().equals(songId)) && song.isActive()) {
                    song.setActive(false);
                    playlistRepository.save(playlist);
                    return true;
                }
            }
        }
        return false;
    }

}
