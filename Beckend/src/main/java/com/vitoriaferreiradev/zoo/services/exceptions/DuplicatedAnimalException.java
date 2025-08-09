//DuplicatedAnimalException.java
package com.vitoriaferreiradev.zoo.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//exceção de negócio
@ResponseStatus(HttpStatus.BAD_REQUEST) // 400 Bad Request
public class DuplicatedAnimalException extends RuntimeException {

    public DuplicatedAnimalException(String message) {
        super(message);
    }

}