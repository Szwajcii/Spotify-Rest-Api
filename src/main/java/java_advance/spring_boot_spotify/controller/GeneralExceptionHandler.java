package java_advance.spring_boot_spotify.controller;

import java_advance.spring_boot_spotify.exceptions.PlaylistNotFoundException;
import java_advance.spring_boot_spotify.exceptions.SongNotFoundException;
import java_advance.spring_boot_spotify.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class GeneralExceptionHandler {

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {PlaylistNotFoundException.class, SongNotFoundException.class, UserNotFoundException.class})
    public String internalServerErrorHandler(){


        return "Internal server error";
    }

}
