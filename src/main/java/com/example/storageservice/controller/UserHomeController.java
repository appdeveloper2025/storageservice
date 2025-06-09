package com.example.storageservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@RequestMapping("/api")
public class UserHomeController {

    @PostMapping("/createUserHome")
    public ResponseEntity<String> createUserHome(@RequestBody String userId) {
        if (!userId.matches("^[a-z0-9]+$")) {
            return ResponseEntity.badRequest().body("Invalid user ID");
        }
        File dir = new File("/opt/home/" + userId);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return ResponseEntity.status(201).body("User home created for: " + userId);
    }
}