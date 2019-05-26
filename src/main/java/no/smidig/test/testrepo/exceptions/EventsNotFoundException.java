package no.smidig.test.testrepo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EventsNotFoundException extends RuntimeException{

    public EventsNotFoundException(String message){
        super(message);
    }

}

