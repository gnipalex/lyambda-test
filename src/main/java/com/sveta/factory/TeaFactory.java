package com.sveta.factory;

import com.sveta.drinks.Drink;
import com.sveta.drinks.Tea;

public class TeaFactory  implements DrinkFactory{
    @Override
    public Drink makeDrink() {
        return new Tea();
    }
}
