package com.library.core.exceptions.auth;


import com.library.core.exceptions.GeneralException;
import com.library.core.exceptions.general.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends GeneralException {
    public UnauthorizedException(){
        super(HttpStatus.UNAUTHORIZED.value());
    }

    public UnauthorizedException(String message){
        super(HttpStatus.UNAUTHORIZED.value(), message);
    }
}
