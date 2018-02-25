package com.sveta.streamipi;

import java.util.Arrays;

public class StreamIpi {

    public static class Cat{

        private String name;
        private String male;
        private int age;

        public Cat(String name,String male,int age ) {
            this.name = name;
            this.male = male;
            this.age = age;
        }
    }

    public static void main(String[] args) {

        Object[][] names = new Object [][] {{"tom", 2, true},{"murka", 5, false},{"barsik", 0.5, true}};
        Arrays.stream(names);
    }
}
