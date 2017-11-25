package com.sveta.factory;

public class Account {

    private String name;
    private String email;
    private int age;
    private boolean male;

    private static void assertIsNotEmpty(String value, String message) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static class AccountBuilder1 {

        Account instance = new Account();

        public AccountBuilder1(String name, String email) {
            assertIsNotEmpty(name, "name must be set");
            assertIsNotEmpty(email, "email must be set");
            instance.name = name;
            instance.email = email;
        }

        public AccountBuilder1 withAge(int age) {
            instance.age = age;
            return this;
        }

        public Account build() {
            return instance;
        }


    }

    public static class AccountBuilder {
        private String name;
        private String email;
        private int age = 15;
        private boolean male = true;

        public AccountBuilder(String name, String email) {
            assertIsNotEmpty(name, "name must be set");
            assertIsNotEmpty(email, "email must be set");
            this.name = name;
            this.email = email;
        }

        public AccountBuilder withAge(int age) {
//            this.instance = null;
            this.age = age;
            return this;
        }

        public AccountBuilder withMale(boolean male) {
//            this.instance = null;
            this.male = male;
            return this;
        }

        public AccountBuilder withMaleAndAge(boolean male, int age) {
            if (!male && age < 18) {
                throw new IllegalArgumentException("you cant be female and have age less than 18");
            }
            this.male = male;
            this.age = age;
            return this;
        }

        private Account instance;

        public Account build() {
            if (instance != null) {
                return instance;
            }
            if (age < 0) {
                throw new IllegalArgumentException("age should be positive");
            }
            Account account = new Account();
            account.age = this.age;
            account.email = this.email;
            account.male = this.male;
            account.name = this.name;
            instance = account;
            return account;
        }



    }

    private Account() {

    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public boolean isMale() {
        return male;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", male=" + male +
                "} , " + super.toString();
    }

    public static void createAndRegisterAccount(AccountBuilder accountBuilder) {
        Account acc = accountBuilder.build();
        System.out.println("saving account " + acc);
    }

    public static void main(String[] args) {
        //new Account("vova", null, 15, true);
        AccountBuilder eugeneBuilder =
                new Account.AccountBuilder("eugene", "eugene@email")
                .withAge(10).withMale(false);
//        Account eugene = eugeneBuilder.build();

        createAndRegisterAccount(eugeneBuilder);

        createAndRegisterAccount(eugeneBuilder);

        eugeneBuilder.withAge(100);

        createAndRegisterAccount(eugeneBuilder);

        createAndRegisterAccount(eugeneBuilder);

        AccountBuilder1 eugeneBuilder1 =
                new Account.AccountBuilder1("eugene1", "eugene1@email")
                        .withAge(10);
        System.out.println(eugeneBuilder1.build());
        System.out.println(eugeneBuilder1.build());
        System.out.println(eugeneBuilder1.build());

    }

}
