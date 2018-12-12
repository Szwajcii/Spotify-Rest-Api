package java_advance.spring_boot_spotify.exceptions;

public class SongNotFoundException extends RuntimeException {

    public SongNotFoundException(String message){
        super(message);
    }

}
