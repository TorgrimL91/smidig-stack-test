package no.smidig.test.testrepo.exceptions;

public class EventNotFoundExceptionResponse {

    private String EventNotFound;

    public EventNotFoundExceptionResponse(String eventNotFound){
        EventNotFound = eventNotFound;
    }

    public String getEventNotFound() {
        return EventNotFound;
    }

    public void setEventNotFound(String eventNotFound) {
        EventNotFound = eventNotFound;
    }
}
