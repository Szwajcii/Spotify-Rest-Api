package java_advance.spring_boot_spotify.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long playlistId;
    private String playlistName;

    @ManyToMany(mappedBy = "playlistList")
    private List<Song> playlistSongs;

    @ManyToOne
    private User playlistUser;


    public Playlist(String playlistName) {
        this.playlistName = playlistName;
        this.playlistSongs = new ArrayList<>();
    }

    public List<Song> getPlaylistSongs() {
        return playlistSongs;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }
}
