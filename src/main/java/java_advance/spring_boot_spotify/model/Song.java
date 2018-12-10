package java_advance.spring_boot_spotify.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long songId;
    private String name;
    private String artist;
    private String length;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "playlist_song",
            joinColumns = { @JoinColumn(name = "songId") },
            inverseJoinColumns = { @JoinColumn(name = "playlistId") }
    )
    private List<Playlist> playlistList;
    private boolean active;

    protected Song() {}

    public Song(String name, String artist, String length) {
        this.name = name;
        this.artist = artist;
        this.length = length;
        this.playlistList = new ArrayList<>();
        this.active = true;
    }

    @Override
    public String toString() {
        return String.format(
                "Song[id=%d, name='%s', artist='%s', length='%s', active='%s']",
                songId, name, artist, length, active);
    }

    public Long getId() {
        return songId;
    }

    public void setId(Long songId) {
        this.songId = songId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
