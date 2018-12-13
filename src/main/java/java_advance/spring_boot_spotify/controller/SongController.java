package java_advance.spring_boot_spotify.controller;

import java_advance.spring_boot_spotify.model.Playlist;
import java_advance.spring_boot_spotify.model.Song;
import java_advance.spring_boot_spotify.service.PlaylistService;
import java_advance.spring_boot_spotify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SongController {
    private SongService songService;
    private PlaylistService playlistService;

    @Autowired
    public SongController(SongService songService, PlaylistService playlistService){
        this.songService = songService;
        this.playlistService = playlistService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/songs/all/{id}")
    public Song getSongById(@PathVariable("id") Long id){
        return this.songService.getSongById(id);
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
        this.songService.safeDeleteSongById(id);
        return this.songService.getSongById(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/songs/addtoplaylist")
    public void addSongToPlaylist(@RequestParam("songId") Long songId,
                                  @RequestParam("playlistId") Long playlistId){
        Playlist playlist = this.playlistService.getPlaylistById(playlistId);
        this.songService.addSongToPLaylist(songId, playlist);
    }
}
