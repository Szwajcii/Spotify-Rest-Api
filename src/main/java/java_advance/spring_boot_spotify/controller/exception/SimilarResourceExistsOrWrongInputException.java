package java_advance.spring_boot_spotify.controller.exception;

public class SimilarResourceExistsOrWrongInputException extends RuntimeException {
    public SimilarResourceExistsOrWrongInputException(String message) {
        super(message);
    }
}
