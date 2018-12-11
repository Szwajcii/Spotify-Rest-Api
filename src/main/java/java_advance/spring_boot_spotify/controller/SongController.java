package java_advance.spring_boot_spotify.controller;

import java_advance.spring_boot_spotify.model.Song;
import java_advance.spring_boot_spotify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/all")
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
}
