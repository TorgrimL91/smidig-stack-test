package no.smidig.test.testrepo.exceptions;

public class UserNotFoundExceptionResponse {

    private String UserNotFound;

    public UserNotFoundExceptionResponse(String userNotFound){
        UserNotFound = userNotFound;
    }

    public String getUserNotFound() {
        return UserNotFound;
    }

    public void setUserNotFound(String userNotFound) {
        UserNotFound = userNotFound;
    }
}
