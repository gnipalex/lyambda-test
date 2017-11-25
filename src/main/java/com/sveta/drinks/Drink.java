package com.sveta.drinks;

public class Drink {

    public static void main(String[] args) {
        Drink coffee = new Coffee("");
        Drink coffeWithMilk = new CoffeWithMilk((Coffee) coffee);

        System.out.println(coffee);
        System.out.println(coffeWithMilk);
    }
}
