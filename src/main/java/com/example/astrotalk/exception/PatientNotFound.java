package com.example.astrotalk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PatientNotFound extends RuntimeException{

    public PatientNotFound(String message){
        super(message);
    }

}
