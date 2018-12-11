package java_advance.spring_boot_spotify.controller;

import java_advance.spring_boot_spotify.model.Song;
import java_advance.spring_boot_spotify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SongController {
    private SongService songService;

    @Autowired
    public SongController(SongService songService){
        this.songService = songService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/songs/all/{id}")
    public Optional<Song> getSongById(@PathVariable("id") String id){
        Long idLong = Long.parseLong(id);
        return this.songService.getSongById(idLong);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/songs/all")
    public Iterable<Song> getAllSongs(){
        return this.songService.getAllSongs();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/songs/delete/{id}")
    public void deleteSongById(@PathVariable("id") String id){
        Long idLong = Long.parseLong(id);
        this.songService.deleteSongById(idLong);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/songs/add")
    public Song addSong(@RequestParam("name") String name,
                        @RequestParam("artist") String artist,
                        @RequestParam("length") String length)
    {
        List<String> songDetails = new ArrayList<>();
        songDetails.add(name);
        songDetails.add(artist);
        songDetails.add(length);

        return songService.addSong(songDetails);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/songs/archive/{id}")
    public Optional<Song> archiveSongById(@PathVariable("id") String id){
        Long idLong = Long.parseLong(id);
        this.songService.archiveSong(idLong);
        return this.songService.getSongById(idLong);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/songs/addtoplaylist")
    public void addSongToPlaylist(@RequestParam("songId") String songId,
                                  @RequestParam("playlistId") String playlistId){
        Long songIdLong = Long.parseLong(songId);

        this.songService.addSongToPLaylist(songIdLong, playlistIdLong);
    }
}
