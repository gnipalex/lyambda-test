package com.sveta.lyamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    Main(){}

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InterruptedException {
        List<Integer> elements = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Collection<Integer> filteredCollection = filterElements(elements, new GreaterFivePredicate());

        System.out.println(filteredCollection);

        Collection<Integer> evenElements = filterElements(elements, e -> e % 2 == 0);

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();

        Thread.sleep(2000);

        thread.start();

    }

    static class GreaterFivePredicate implements Predicate<Integer> {

        @Override
        public boolean test(Integer integer) {
            return integer > 5;
        }
    }

    private static <E> Collection<E> filterElements(Collection<E> collection, Predicate<E> condition) {
        List<E> filteredCollection = new ArrayList<E>();
        for (E item : collection) {
            if (condition.test(item)) {
                filteredCollection.add(item);
            }
        }
        return filteredCollection;
    }
}
