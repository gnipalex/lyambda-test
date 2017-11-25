package com.sveta.observer;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Registry registry = new Registry();

        Computer computer = new Computer();
        Terminal terminal = new Terminal();

        registry.subscribe(new Registry.Callback() {
            @Override
            public void handle(String message) {
                computer.saveMessageToFile(message);
            }
        });

        registry.subscribe(terminal::print);

        registry.subscribe(terminal);

        for (int i=0; i<5; i++) {
            Thread.sleep(1000);
            String message = "message" + i;
            System.out.println("publishing message : " + message);
            registry.publishMessage(message);
        }
    }

}
