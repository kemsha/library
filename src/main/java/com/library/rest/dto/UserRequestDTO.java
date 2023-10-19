package com.library.rest.dto;

import com.library.core.model.User;
import com.library.core.model.enums.UserType;
import org.springframework.stereotype.Component;

import java.util.Date;

public class UserRequestDTO {
    private UserType userType;

    private String firstName;

    private String lastName;

    private String email;

    private String userName;

    private String password;

    public UserRequestDTO() { }

    public UserRequestDTO(User user){
        this.userType = user.getUserType();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.userName = user.getUsername();
        this.password = user.getPassword();
    }


    public UserType getUserType() { return userType; }

    public void setUserType(UserType userType) { this.userType = userType; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public User toEntity() {
        User user = new User();
        user.setUserType(userType);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setUsername(userName);
        user.setPassword(password);
        user.setCreationDate(new Date());
        return user;
    }
}
