package com.example;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

    public void performAction() {
        api.log("Hello");
    }

    public void doReset() {
        api.reset();
    }

    public void processInOrder() {
        api.stepOne();
        api.stepTwo();
    }

    public void processWithArg(String value) {
        api.process(value);
    }
}
