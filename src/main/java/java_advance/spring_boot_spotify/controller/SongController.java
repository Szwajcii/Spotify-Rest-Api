package java_advance.spring_boot_spotify.controller;

import java_advance.spring_boot_spotify.controller.exception.ResourceNotFoundException;
import java_advance.spring_boot_spotify.exceptionMessage.ClientMessage;
import java_advance.spring_boot_spotify.exceptionMessage.Message;
import java_advance.spring_boot_spotify.model.Playlist;
import java_advance.spring_boot_spotify.model.Song;
import java_advance.spring_boot_spotify.service.PlaylistService;
import java_advance.spring_boot_spotify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SongController {
    private final SongService songService;
    private final PlaylistService playlistService;

    @Autowired
    public SongController(SongService songService, PlaylistService playlistService){
        this.songService = songService;
        this.playlistService = playlistService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/songs/{id}")
    public Song getSongById(@PathVariable("id") Long id){
        Song song = this.songService.getSongById(id);
        if ((song == null) || song.isActive() == false) {
                throw new ResourceNotFoundException("Song not found!") ;
            }
        return song;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/songs/all")
    public Iterable<Song> getAllSongs(){
        return this.songService.getAllSongs();
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
    public Song safeDeleteSongById(@PathVariable("id") Long id){
        Song song = this.songService.getSongById(id);
        if ((song == null) || song.isActive() == false) {
            throw new ResourceNotFoundException("Song not found!") ;
        }
        this.songService.safeDeleteSongById(id);
        return this.songService.getSongById(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/songs/addtoplaylist")
    public void addSongToPlaylist(@RequestParam("songId") Long songId,
                                  @RequestParam("playlistId") Long playlistId){
        Playlist playlist = this.playlistService.getPlaylistById(playlistId);
        this.songService.addSongToPLaylist(songId, playlist);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Message> handleResourceNotFound(HttpServletRequest request, Exception exception) {
        Message message = new ClientMessage(new Timestamp(System.currentTimeMillis())
                , HttpStatus.NOT_FOUND
                , exception.getMessage(), request.getRequestURI()
                , "Provide proper song id, because there is no song with id like that.");
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
