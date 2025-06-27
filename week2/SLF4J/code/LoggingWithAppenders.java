package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingWithAppenders {
    private static final Logger logger = LoggerFactory.getLogger(LoggingWithAppenders.class);

    public static void main(String[] args) {
        logger.info("Logging to console and file at INFO level");
        logger.debug("Logging to console and file at DEBUG level");
        logger.error("An error occurred in the application");
    }
}
