package com.sveta.comparator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyEntity implements Comparable<MyEntity> {
    private long id;
    private String description;
    private double weight;

    public MyEntity(long id, String description, double weight) {
        this.id = id;
        this.description = description;
        this.weight = weight;
    }

    @Override
    public int compareTo(MyEntity obj) {
        if (this.description == null) {
            return -1;
        } else if (obj.description==null) {
            return 1;
        }
        int cmp = this.description.length() - obj.description.length();
        return cmp > 0 ? 1 : cmp == 0 ? 0 : -1;
    }

    public static int compareByWeightDesc(MyEntity obj1, MyEntity obj2){
        double cmp = obj1.weight - obj2.weight;
        return cmp > 0 ? -1 : cmp == 0 ? 0 : 1;
    }

    @Override
    public String toString() {
        return "MyEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static void main(String[] args) {
        List<MyEntity> myEntityList = new ArrayList<MyEntity>();
        myEntityList.add(new MyEntity(1,"1",2));
        myEntityList.add(new MyEntity(2,"12",20));
        myEntityList.add(new MyEntity(3,"12",8));
        myEntityList.add(new MyEntity(4,"1",21));
        myEntityList.add(new MyEntity(5,"1",24));
        myEntityList.add(new MyEntity(6,"12345",26));
        myEntityList.add(new MyEntity(7,null,28));
        myEntityList.add(new MyEntity(8,"12345678",28));
        myEntityList.add(new MyEntity(9,"123",50));
        myEntityList.add(new MyEntity(10,"1123456789",27));
        myEntityList.add(new MyEntity(11,"1234",8));

        System.out.println(myEntityList);
        List<MyEntity> myFinalEntityList= myEntityList.stream().sorted()
                .limit(10)
                .peek(System.out::println)
                .sorted(MyEntity::compareByWeightDesc)
                .collect(Collectors.toList());
        System.out.println(myFinalEntityList.size());
        System.out.println(myFinalEntityList);
    }
}
