package com.library.core.exceptions.auth;


import com.library.core.exceptions.GeneralException;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidParametersSentException extends GeneralException {
    public InvalidParametersSentException(){
        super(HttpStatus.BAD_REQUEST.value());
    }

    public InvalidParametersSentException(String message){
        super(HttpStatus.BAD_REQUEST.value(), message);
    }
}
