package com.springmobile.springmobile.ui.model.response;

import org.springframework.lang.NonNull;

public class UserRest {
    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private String password;
    
    public String getFirstName() {
        return firstName;
    }
    public String getPassword() {
        return password;
    }
    
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
