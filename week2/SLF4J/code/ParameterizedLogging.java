package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogging {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLogging.class);

    public static void main(String[] args) {
        String user = "Sai";
        int attempts = 3;

        logger.info("User {} has {} login attempts left", user, attempts);
        logger.debug("Debug log for user {}, attempt count: {}", user, attempts);
    }
}
