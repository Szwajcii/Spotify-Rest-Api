package java_advance.spring_boot_spotify.exceptionMessage;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

public class ClientMessage extends Message {

    private String tip;

    public ClientMessage(Timestamp timestamp, HttpStatus status, String message, String path, String tip) {
        super(timestamp, status, message, path);
        this.tip = tip;

    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
