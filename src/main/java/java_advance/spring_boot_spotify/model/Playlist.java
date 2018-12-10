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

    @ManyToMany(mappedBy = "playlistList", cascade = CascadeType.ALL)
    private List<Song> playlistSongs = new ArrayList<Song>();

    @ManyToOne(mappedBy = "playlists")
    @JoinColumn(name="userId", nullable=false)
    private User playlistUser;


    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }
}
