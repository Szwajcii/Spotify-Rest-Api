package java_advance.spring_boot_spotify.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String artist;
    private String length;
    private boolean active;

    protected Song() {}

    public Song(String name, String artist, String length) {
        this.name = name;
        this.artist = artist;
        this.length = length;
        this.active = true;
    }

    @Override
    public String toString() {
        return String.format(
                "Song[id=%d, name='%s', artist='%s', length='%s', active='%s']",
                id, name, artist, length, active);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
