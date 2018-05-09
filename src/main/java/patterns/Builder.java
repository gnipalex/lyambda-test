package patterns;

import java.util.Comparator;

public class Builder {
    public static class Cat {

        private String name;
        private String male;
        private int age;

        private Cat(String name, String male, int age) {
            this.name = name;
            this.male = male;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getMale() {
            return male;
        }

        public int getAge() {
            return age;
        }

        public static Cat.CatBuilder builder() {
            return new Cat.CatBuilder();
        }

        public static class CatBuilder {
            private String name;
            private String male;
            private int age;

            public CatBuilder setName(String name) {
                this.name = name;
                return this;
            }

            public CatBuilder setMale(String male) {
                this.male = male;
                return this;
            }

            public CatBuilder setAge(int age) {
                this.age = age;
                return this;
            }

            public Cat build() {
                return new Cat(name, male, age);
            }

        }
    }

    public static class CatsByAgeComparator implements Comparator<Cat> {

        @Override
        public int compare(Cat c1, Cat c2) {

            if (c1.age < c2.age) {
                return -1;
            }

            if (c1.age > c2.age) {
                return 1;
            } else
                return 0;
        }

    }


    public static void main(String[] args) {
        Cat.builder().setAge(1).setMale("male").build();
    }

}
