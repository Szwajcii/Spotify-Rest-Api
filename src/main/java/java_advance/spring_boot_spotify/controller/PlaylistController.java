package java_advance.spring_boot_spotify.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaylistController {

    private PlaylistService playlistService;

    public Collection<Song> getAllSongs(){
        return playlistService.getAllSongs();
    }

}
