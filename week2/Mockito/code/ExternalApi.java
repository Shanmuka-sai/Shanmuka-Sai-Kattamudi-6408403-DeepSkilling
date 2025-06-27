package com.example;

public interface ExternalApi {
    String getData();
    void log(String message);
    void reset();
    void stepOne();
    void stepTwo();
    void process(String value);
}
