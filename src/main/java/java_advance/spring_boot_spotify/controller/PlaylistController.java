package java_advance.spring_boot_spotify.controller;

import java_advance.spring_boot_spotify.model.Playlist;
import java_advance.spring_boot_spotify.model.Song;
import java_advance.spring_boot_spotify.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaylistController {

    private PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService){
        this.playlistService = playlistService;
    }

    @GetMapping("/all")
    public List<Playlist> getAllPlaylists(){
        return playlistService.getAllPlaylists();
    }

    @GetMapping("/all/{playlistId}")
    public Iterable<Song> getAllSongs(@PathVariable Long playlistId){
        return playlistService.getAllSongs(playlistId);
    }

    @GetMapping("/all/{playlistId}/{songName}")
    public List<Song> getSongByName(@PathVariable Long playlistId, @PathVariable String songName){
        return playlistService.getSongByName(playlistId, songName);
    }

}
