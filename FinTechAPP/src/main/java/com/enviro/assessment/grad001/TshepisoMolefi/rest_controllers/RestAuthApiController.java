package com.enviro.assessment.grad001.TshepisoMolefi.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.TshepisoMolefi.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class RestAuthApiController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public ResponseEntity validateUserEmail(@PathVariable("user1")String user1){
        // Get User Name:
        String userName = userRepository.getUserName(user1);
        // Init User Password:
        String userPassword = null;

        // Check User Name:
        if(userName != null){
            userPassword = userRepository.getUserPassword(user1);
            // Return Response:
            return new ResponseEntity<>(userPassword, HttpStatus.OK);
        }else{
            // Return Response:
            return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
        }
        
    }
  
}

