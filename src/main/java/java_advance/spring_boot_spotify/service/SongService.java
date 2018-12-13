package java_advance.spring_boot_spotify.service;

import java_advance.spring_boot_spotify.model.Playlist;
import java_advance.spring_boot_spotify.model.Song;
import java_advance.spring_boot_spotify.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SongService implements SongServiceInterface {
    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    @Override
    public Song getSongById(Long id) {
        Song song = this.songRepository.findById(id).orElse(null);
        if (!(song == null)) {
            if (song.isActive() == false) {
                return null;
            }
        }
        return song;
    }

    @Override
    public List<Song> getAllSongs() {
        return this.songRepository.findAll();
    }

    @Override
    public Song safeDeleteSongById(Long id) {
        Song song = this.songRepository.findById(id).orElse(null);
        song.setActive(false);
        return this.songRepository.save(song);
    }

    @Override
    public Song addSong(List<String> songDetails) {
        Song song = new Song(songDetails.get(0), songDetails.get(1), songDetails.get(2));
        return this.songRepository.save(song);
    }

    @Override
    public void addSongToPLaylist(Long id, Playlist playlist) {
        this.songRepository.findById(id).orElse(null).addToPlaylist(playlist);
    }
}
