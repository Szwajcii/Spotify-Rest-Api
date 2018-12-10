package java_advance.spring_boot_spotify.controller;

import java_advance.spring_boot_spotify.model.Song;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class PlaylistController {

    private PlaylistService playlistService;

    public Collection<Song> getAllSongs(){
        return playlistService.getAllSongs();
    }

    public Collection<Song> getSongsByGenre(String genre){
        return playlistService.getSongsByGenre(genre);
    }

}
