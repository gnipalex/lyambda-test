package com.sveta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class CollectionTasks {
    public static List<ComparableMap<String, String>> getComparableMapsFromMaps(final List<Map<String, String>> maps) {
        List<ComparableMap<String, String>> expectedRows = new ArrayList<>();
        maps.stream().forEach(map -> {
                    ComparableMap<String, String> mapped = map.entrySet().stream()
                            .collect(toMap(
                                    e -> e.getKey(),
                                    e -> e.getValue().toString().replaceAll("\\s{2,}", " "),
                                    (v1, v2) -> v1,
                                    ComparableMap::new
                            ));
                    expectedRows.add(mapped);
                }
        );
        return expectedRows;
    }

    public static void main(String[] args) {
        List<Map<String, String>> expectedRows = new ArrayList<>();
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("description", "AISLE 0 LE");
        map1.put("description1", "Aisle  01");
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("location", "001L01");
        map2.put("location1", "001L03");
        expectedRows.add(map1);
        expectedRows.add(map2);

        System.out.println(getComparableMapsFromMaps(expectedRows));


//        forEach(e -> e.entrySet().stream()
//                .collect(Collectors.toMap(k -> System.out.println(k.getKey()), k -> System.out.println(k.getValue().toString().replaceAll("\\s{2,}", " ")))));
    }
}

class ComparableMap<K, V> extends HashMap {

    public ComparableMap() {
    }

    public ComparableMap(Map<K, V> source) {
        super(source);
    }
}