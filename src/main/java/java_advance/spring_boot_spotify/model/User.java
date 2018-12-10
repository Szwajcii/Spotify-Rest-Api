package java_advance.spring_boot_spotify.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId", updatable = false, nullable = false)
    private Long userId;

    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;

    @Size(min = 2, max = 30)
    @NotNull
    private String lastName;

    @Pattern(regexp = "^[^\\s]([A-Za-z0-9_.]{2,20})@([A-Za-z0-9]{2,20}).([a-z]{2,13})$")
    @NotNull
    private String email;

    @NotNull
    @Pattern(regexp = "^([0-9]{3})-([0-9]{3})-([0-9]{3})$")
    private String phone;

    @OneToMany(mappedBy = "playlistUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Playlist> playlists;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
