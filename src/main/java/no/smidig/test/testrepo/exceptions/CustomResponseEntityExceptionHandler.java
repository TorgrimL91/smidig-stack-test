package no.smidig.test.testrepo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request){
        UserNotFoundExceptionResponse exceptionResponse = new UserNotFoundExceptionResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    /*
    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectIdException(ProjectIdException ex, WebRequest request){
        ProjectIdExceptionResponse exceptionResponse = new ProjectIdExceptionResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectNotFoundException(ProjectNotFoundException ex, WebRequest request){
        ProjectNotFoundExceptionResponse exceptionResponse = new ProjectNotFoundExceptionResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);

    }

}

     */
}
