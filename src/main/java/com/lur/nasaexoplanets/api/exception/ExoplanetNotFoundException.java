package com.lur.nasaexoplanets.api.exception;

public class ExoplanetNotFoundException extends RuntimeException{
    public ExoplanetNotFoundException(String message){
        super(message);
    }
}
