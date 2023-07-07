package ru.hogwarts.school.exceptions;

public class NoSuchMusicEndpointException extends RuntimeException {
    public NoSuchMusicEndpointException() {
        super();
    }

    public NoSuchMusicEndpointException(String message) {
        super(message);
    }


}
