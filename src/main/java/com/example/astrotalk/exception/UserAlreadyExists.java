package com.example.astrotalk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class UserAlreadyExists extends RuntimeException{

    public UserAlreadyExists(String message){
        super(message);
    }

}
