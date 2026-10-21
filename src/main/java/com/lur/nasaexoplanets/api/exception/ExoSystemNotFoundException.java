package com.lur.nasaexoplanets.api.exception;

public class ExoSystemNotFoundException extends RuntimeException {
    public ExoSystemNotFoundException(String message) {
        super(message);
    }
}
