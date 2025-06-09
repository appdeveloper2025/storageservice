package com.example.storageservice.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class UserHomeService {

    public void createDirectory(String userId) throws IOException {
        String directoryPath = "/opt/home/" + userId;
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (!created) {
                throw new IOException("Failed to create directory: " + directoryPath);
            }
        }
    }
}