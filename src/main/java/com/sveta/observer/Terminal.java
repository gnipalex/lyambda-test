package com.sveta.observer;

public class Terminal implements Registry.Callback {

    public void print(String message) {
        System.out.println("Terminal-> " + message);
    }

    @Override
    public void handle(String message) {
        this.print(message);
    }
}
