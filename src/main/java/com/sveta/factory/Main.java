package com.sveta.factory;

import com.sveta.drinks.Coffee;
import com.sveta.drinks.Drink;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        DrinkFactory drinkFactory = new TeaFactory(); //new CoffeeFactory(); //

        Cafe cafe = new Cafe(drinkFactory);

        System.out.println(cafe.prepareDrink());

        Coffee cofe1 = new Coffee("asdf");
        Coffee cofe2 = cofe1.clone();



    }

    public static class Cafe {

        private DrinkFactory drinkFactory;

        public Cafe(DrinkFactory drinkFactory){
            this.drinkFactory = drinkFactory;
        }

        public Drink prepareDrink() {
            return drinkFactory.makeDrink();
        }

    }

}
