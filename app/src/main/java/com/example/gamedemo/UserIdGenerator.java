package com.example.gamedemo;

import java.util.Random;

public class UserIdGenerator {

    // Function to generate a random 6-digit user ID
    public static String generateUserId() {
        Random random = new Random();
        int min = 100000; // Minimum 6-digit number
        int max = 999999; // Maximum 6-digit number

        int userId = random.nextInt(max - min + 1) + min;
        return String.valueOf(userId);
    }
}

