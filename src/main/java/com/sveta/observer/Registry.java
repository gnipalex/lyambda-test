package com.sveta.observer;

import java.util.HashSet;
import java.util.Set;

public class Registry {

    private Set<Callback> callbacks = new HashSet<>();


    public void unSubscribe(Callback callback) {
        callbacks.remove(callback);
    }

    public void publishMessage(String message) {
        callbacks.forEach(c -> c.handle(message));
    }

    public void subscribe(Callback callback) {
        callbacks.add(callback);
    }

    @FunctionalInterface
    public static interface Callback {
        void handle(String message);
    }

}
