package com.sveta.drinks;

public class CoffeWithMilk extends Drink {

    private Coffee coffee;

    public CoffeWithMilk(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String toString() {
        return coffee.toString() + " with milk";
    }
}
