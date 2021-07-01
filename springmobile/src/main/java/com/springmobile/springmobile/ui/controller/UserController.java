package com.springmobile.springmobile.ui.controller;

import com.springmobile.springmobile.ui.model.response.UserRest;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users") // http://localhost:8080/users

public class UserController {

    @GetMapping()
    public UserRest getUser(@RequestParam(value="page", defaultValue = "1") int page,
                          @RequestParam(value="limit", defaultValue = "50") int limit) {
        UserRest returnValue = new UserRest();
        returnValue.setFirstName("Juno");
        returnValue.setLastName("Munkhkhurel");
        returnValue.setEmail("email@email.com");
        returnValue.setPassword("123");

        return returnValue;
    }

    @GetMapping(path="/{userId}", 
        produces = {
            org.springframework.http.MediaType.APPLICATION_XML_VALUE, 
            org.springframework.http.MediaType.APPLICATION_JSON_VALUE })
    public String getUser(@PathVariable String userId) {
        return "get user was called with userId" + userId;
    }

    @PostMapping
    public String postUser() {
        return "post user was called";
    }

    @PutMapping
    public String putUser() {
        return "put user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}