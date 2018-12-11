package java_advance.spring_boot_spotify.controller;

import java_advance.spring_boot_spotify.model.Song;
import java_advance.spring_boot_spotify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SongController {
    SongService songService;

    @Autowired
    public SongController(SongService songService){
        this.songService = songService;
    }

    public Optional<Song> getSongById(Long id){
        return this.songService.getSongById(id);
    }

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
