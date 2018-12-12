package java_advance.spring_boot_spotify.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message){
        super(message);
    }

}
