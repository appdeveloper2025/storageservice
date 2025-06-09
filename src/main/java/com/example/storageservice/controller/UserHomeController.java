package com.example.storageservice.controller;

import com.example.storageservice.service.UserHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class UserHomeController {

    private final UserHomeService userHomeService;

    @Autowired
    public UserHomeController(UserHomeService userHomeService) {
        this.userHomeService = userHomeService;
    }

    @PostMapping("/createUserHome")
    public ResponseEntity<String> createUserHome(@RequestParam String userid) {
        if (!isValidUserId(userid)) {
            return ResponseEntity.badRequest().body("Invalid userid. It must contain only lowercase letters and numbers.");
        }

        boolean isCreated = userHomeService.createDirectory(userid);
        if (isCreated) {
            return ResponseEntity.ok("User home directory created successfully at /opt/home/" + userid);
        } else {
            return ResponseEntity.status(500).body("Failed to create user home directory.");
        }
    }

    private boolean isValidUserId(String userid) {
        String regex = "^[a-z0-9]+$";
        return Pattern.matches(regex, userid);
    }
}