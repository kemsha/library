package com.library.core.exceptions.auth;


import com.library.core.exceptions.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class UserAlreadyExistsException extends GeneralException {
    public UserAlreadyExistsException(){
        super(HttpStatus.CONTINUE.value());
    }

    public UserAlreadyExistsException(String message){
        super(HttpStatus.CONFLICT.value(), message);
    }
}
