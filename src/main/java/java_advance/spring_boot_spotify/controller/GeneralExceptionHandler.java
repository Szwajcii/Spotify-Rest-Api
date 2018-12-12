package java_advance.spring_boot_spotify.controller;

import java_advance.spring_boot_spotify.exceptions.PlaylistNotFoundException;
import java_advance.spring_boot_spotify.exceptions.SongNotFoundException;
import java_advance.spring_boot_spotify.exceptions.UserNotFoundException;
import java_advance.spring_boot_spotify.service.statusInfo.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GeneralExceptionHandler {

    MailService mailService;

    @Autowired
    public GeneralExceptionHandler(MailService mailService){
        this.mailService = mailService;
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {PlaylistNotFoundException.class, SongNotFoundException.class, UserNotFoundException.class})
    public String internalServerErrorHandler(HttpServletRequest request, Exception ex){

        mailService.send("testspringboot@gmail.com", "Internal server error 500.", "Exception " + ex + "\nCaused by: method" + request.getMethod()
                + "\npath: "+ request.getRequestURI());

        return "Internal server error";
    }

}
