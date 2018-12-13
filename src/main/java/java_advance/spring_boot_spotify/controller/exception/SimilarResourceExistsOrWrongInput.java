package java_advance.spring_boot_spotify.controller.exception;

public class SimilarResourceExistsOrWrongInput extends RuntimeException {
    public SimilarResourceExistsOrWrongInput(String message) {
        super(message);
    }
}
