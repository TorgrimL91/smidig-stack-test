package no.smidig.test.testrepo.exceptions;

public class EventsNotFoundExceptionResponse {


    private String EventNotFound;

    public EventsNotFoundExceptionResponse(String eventNotFound){
        EventNotFound = eventNotFound;
    }

    public String getEventNotFound() {
        return EventNotFound;
    }

    public void setEventNotFound(String eventNotFound) {
        EventNotFound = eventNotFound;
    }
}


