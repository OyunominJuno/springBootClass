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
    private String userId;
    
    public String getFirstName() {
        return firstName;
    }
    public String getUserId() {
        return userId;
    }
    
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setUserId(String userId) {
        this.userId = userId;
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
