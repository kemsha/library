package com.library.rest.dto;

public class LoginDTO {
    private String jwt;

    public LoginDTO(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return this.jwt;
    }
}
