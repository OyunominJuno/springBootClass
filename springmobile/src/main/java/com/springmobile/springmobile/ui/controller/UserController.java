package com.springmobile.springmobile.ui.controller;

import javax.validation.Valid;

import com.springmobile.springmobile.ui.model.request.UserDetailsRequestModel;
import com.springmobile.springmobile.ui.model.response.UserRest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users") // http://localhost:8080/users

public class UserController {

    @GetMapping()
    public ResponseEntity<UserRest> getUser(@RequestParam(value="page", defaultValue = "1") int page,
                          @RequestParam(value="limit", defaultValue = "50") int limit) {
        UserRest returnValue = new UserRest();
        returnValue.setFirstName("Juno");
        returnValue.setLastName("Munkhkhurel");
        returnValue.setEmail("email@email.com");

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @GetMapping(path="/{userId}", 
        produces = {
            org.springframework.http.MediaType.APPLICATION_XML_VALUE, 
            org.springframework.http.MediaType.APPLICATION_JSON_VALUE })
    public String getUser(@PathVariable String userId) {
        return "get user was called with userId" + userId;
    }

    @PostMapping(
        produces = {
            org.springframework.http.MediaType.APPLICATION_XML_VALUE, 
            org.springframework.http.MediaType.APPLICATION_JSON_VALUE },
        consumes  = {
            org.springframework.http.MediaType.APPLICATION_XML_VALUE, 
            org.springframework.http.MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<UserRest> postUser(@Valid @RequestBody UserDetailsRequestModel userDetail) {

        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetail.getFirstName());
        returnValue.setLastName(userDetail.getLastName());
        returnValue.setEmail(userDetail.getEmail());
        //returnValue.setPassword(userDetail.getPassword());

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.ACCEPTED);
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