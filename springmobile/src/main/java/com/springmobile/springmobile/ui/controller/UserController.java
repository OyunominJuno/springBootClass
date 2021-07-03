package com.springmobile.springmobile.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import com.springmobile.springmobile.ui.model.request.UserDetailsRequestModel;
import com.springmobile.springmobile.ui.model.response.UserRest;

import org.apache.catalina.User;
import org.apache.tomcat.util.http.parser.MediaType;
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

    Map<String, UserRest> users;

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
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
        if(users.containsKey(userId)) {
            return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
        }
        
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

        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);

        if (users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.ACCEPTED);
    }

    @PutMapping(path="/{userId}", 
        produces = {
            org.springframework.http.MediaType.APPLICATION_XML_VALUE, 
            org.springframework.http.MediaType.APPLICATION_JSON_VALUE },
        consumes  = {
            org.springframework.http.MediaType.APPLICATION_XML_VALUE, 
            org.springframework.http.MediaType.APPLICATION_JSON_VALUE }  
    )
    public ResponseEntity<UserRest> putUser(@PathVariable String userId, @RequestBody UserDetailsRequestModel userDetail) {
        if (users.containsKey(userId)) {
            //UserRest updatingUser = users.get(userId);
            if(userDetail.getFirstName() != null) {
                users.get(userId).setFirstName(userDetail.getFirstName());
            }
            if(userDetail.getLastName() != null) {
                users.get(userId).setLastName(userDetail.getLastName());
            }
            return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping(path="/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        users.remove(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}