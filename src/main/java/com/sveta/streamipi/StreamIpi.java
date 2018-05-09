package com.sveta.streamipi;

import java.util.Arrays;

public class StreamIpi {

    public static class Cat{

        private String name;
        private String male;
        private int age;

        private Cat(String name,String male,int age ) {
            this.name = name;
            this.male = male;
            this.age = age;
        }

        public static CatBuilder builder() {
            return new CatBuilder();
        }

        private static class CatBuilder {
            private String name;
            private String male;
            private int age;

            public CatBuilder  setName(String name) {
                this.name=name;
                return this;
            }

            public CatBuilder  setMale(String male) {              this.male=male;
                return this;
            }

            public CatBuilder  setAge(int age) {
                this.age=age;
                return this;
            }

            public Cat build() {
                return new Cat(name,male,age);
            }

        }
    }

    public static void main(String[] args) {

        Object[][] names = new Object [][] {{"tom", 2, true},{"murka", 5, false},{"barsik", 0.5, true}};
        Arrays.stream(names);

        Cat.builder().setAge(1).setMale("male").build();

    }

}
