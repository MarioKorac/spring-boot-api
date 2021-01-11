package com.mario.api.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GenerateUserId {


    private String userId;

    public GenerateUserId() {
    }


    public String generateString() {
        return UUID.randomUUID().toString();
    }

}
