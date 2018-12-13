package java_advance.spring_boot_spotify.controller;

import java_advance.spring_boot_spotify.model.Playlist;
import java_advance.spring_boot_spotify.model.Song;
import java_advance.spring_boot_spotify.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaylistController {

    private final PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService){
        this.playlistService = playlistService;
    }

    @RequestMapping(path = "/playlist/*", method = RequestMethod.GET)
    public List<Playlist> getAllPlaylists(){
        return playlistService.getAllPlaylists();
    }

    @RequestMapping(path = "/playlist/{playlistId}", method = RequestMethod.GET)
    public Playlist getPlaylistById(@PathVariable("playlistId") Long playlistId){
        return this.playlistService.getPlaylistById(playlistId);
    }

    @RequestMapping(path = "/playlist/songs/{playlistId}", method = RequestMethod.GET)
    public Iterable<Song> getAllSongsFromPlaylist(@PathVariable("playlistId") Long playlistId){
        return playlistService.getAllSongsFromPlaylist(playlistId);
    }

    @RequestMapping(path = "/playlist/{playlistId}/{songName}", method = RequestMethod.GET)
    public List<Song> getSongByNameFromPlaylist(@PathVariable("playlistId") Long playlistId,
                                    @PathVariable("songName") String songName){
        return playlistService.getSongByNameFromPlaylist(playlistId, songName);
    }

    @RequestMapping(path = "/playlistId/add/{playlistName}", method = RequestMethod.POST)
    public Playlist addNewPlaylist(@PathVariable("playlistName") String playlistName){
        return playlistService.addNewPlaylist(playlistName);
    }

    @RequestMapping(path = "/playlist/delete/{playlistId}", method = RequestMethod.DELETE)
    public void deletePlaylist(@PathVariable("playlistId") Long playlistId){
        this.playlistService.deletePlaylistById(playlistId);
    }

}
