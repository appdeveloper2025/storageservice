package com.example.storageservice.service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class UserHomeService {
    private static final String BASE_PATH = "/opt/home/";

    public boolean createUserHome(String userid) {
        File dir = new File(BASE_PATH + userid);
        if (dir.exists()) {
            return false;
        }
        return dir.mkdirs();
    }
}