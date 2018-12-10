package java_advance.spring_boot_spotify.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Playlist {

    @Id
    @GeneratedValue
    private Long playlistId;
    private String playlistName;

    @ManyToMany(mappedBy = "playlistList")
    private List<Song> playlistSongs = new ArrayList<Song>();

    @ManyToMany(mappedBy = "")
    private List<User> playlistUsers = new ArrayList<User>();


    public Long getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Long playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }
}
