package com.sveta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Svitlana_Peleshenko on 1/23/2018.
 */
public class CollectionTasks {

    public static Map<Integer, Integer> getElementsStatistics(List<List<Integer>> lists) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int size = lists.size();
        int a;
        int b;
        for (int i = 0; i < size; i++) {
            List<Integer> list1 = lists.get(i);
            int list1Size = list1.size();
            for (int j = 0; j < list1Size; j++) {
                int countOfRepeat = 0;
                List<Integer> listNext = lists.get(i + 1);
                int listNextSize = listNext.size();
                for (int k = 0; k < listNextSize; k++) {
                    System.out.println(a = list1.get(j));
                    System.out.println(b = listNext.get(k));
                    if (list1.get(j) == listNext.get(k)) {
                        ++countOfRepeat;
                    }
                }
                map.put(list1.get(j), countOfRepeat);
            }

        }

        return map;

    }

    public static Map<Integer, Integer> getElementsStatistics1(List<List<Integer>> lists) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (List<Integer> innerList : lists) {
            for (Integer innerListValue : innerList) {
                Integer countOfMatches = map.get(innerListValue);
                if (countOfMatches != null) {
                    countOfMatches++;
                } else {
                    countOfMatches = 1;
                }
                map.put(innerListValue, countOfMatches);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 8));

        getElementsStatistics1(lists).entrySet()
                .stream()
                .forEach(e -> System.out.println(e.getKey() + "-" + e.getValue()));

    }

    static class Record {

    }


}
