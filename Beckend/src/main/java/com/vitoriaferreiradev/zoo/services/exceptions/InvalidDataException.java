package com.vitoriaferreiradev.zoo.services.exceptions;

//exceção de negócio
public class InvalidDataException extends RuntimeException {

    public InvalidDataException(String message) {
        super(message);
    }

}
