package com.sveta.observer;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Computer {

    public void saveMessageToFile(String message) {

        File f = new File("aaa.txt");
        System.out.println("Computer: saving message " + message +" to file ");
        try {
            FileUtils.writeStringToFile(f, message, "utf-8", true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
