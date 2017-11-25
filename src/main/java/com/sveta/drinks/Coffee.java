package com.sveta.drinks;

public class Coffee extends Drink implements Cloneable {

    private String type;

    public Coffee(String type) {
        this.type = type;
    }

    public Coffee(Coffee base) {
        this.type = base.type;
    }

    @Override
    public String toString() {
        return "coffee";
    }

    @Override
    public Coffee clone() throws CloneNotSupportedException {
        return new Coffee(this.type);
    }
}
