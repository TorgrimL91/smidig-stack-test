package no.smidig.test.testrepo.exceptions;

public class LocationNotFoundExceptionResponse {


    private String LocationNotFound;

    public LocationNotFoundExceptionResponse(String locationNotFound){
        LocationNotFound = locationNotFound;
    }

    public String getLocationNotFound() {
        return LocationNotFound;
    }

    public void setLocationNotFound(String locationNotFound) {
        LocationNotFound = locationNotFound;
    }
}
