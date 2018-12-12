package java_advance.spring_boot_spotify.exceptions;

public class PlaylistNotFoundException extends RuntimeException {

    public PlaylistNotFoundException(String message){
        super(message);
    }

}
