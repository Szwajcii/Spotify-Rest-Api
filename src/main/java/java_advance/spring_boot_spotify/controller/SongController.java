package java_advance.spring_boot_spotify.controller;

import java_advance.spring_boot_spotify.model.Playlist;
import java_advance.spring_boot_spotify.model.Song;
import java_advance.spring_boot_spotify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SongController {
    SongService songService;

    @Autowired
    public SongController(SongService songService){
        this.songService = songService;
    }

    @GetMapping("/all/{id}")
    public Optional<Song> getSongById(@PathVariable("id") String id){
        Long idLong = Long.parseLong(id);
        return this.songService.getSongById(idLong);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public Iterable<Song> getAllSongs(){
        return this.songService.getAllSongs();
    }

    public void deleteSongById(Long id){
        this.songService.deleteSongById(id);
    }

    public void addSong(Song song){
        this.songService.addSong(song);
    }

    public void archiveSongById(Long id){
        this.songService.archiveSong(id);
    }

    public void addSongToPlaylist(Long songId, Playlist playlist){
        this.songService.addSongToPLaylist(songId, playlist);
    }
}
