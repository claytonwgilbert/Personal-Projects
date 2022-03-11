package com.cg.classrosterfullstackapp.students.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class IdMismatchException extends RuntimeException{
    public IdMismatchException() {
        super();
    }

    public IdMismatchException(String message) {
        super(message);
    }
}
