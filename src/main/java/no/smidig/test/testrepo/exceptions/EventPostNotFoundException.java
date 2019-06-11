package no.smidig.test.testrepo.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EventPostNotFoundException extends RuntimeException{


    public EventPostNotFoundException(String message){
        super(message);
    }
}
