package com.sveta.factory;

import com.sveta.drinks.Coffee;
import com.sveta.drinks.Drink;

public class CoffeeFactory implements DrinkFactory {

    @Override
    public Drink makeDrink() {
        return new Coffee("black");
    }
}
