package com.sveta.streamipi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamsTask {

    /*** Created by Svitlana_Peleshenko on 4/27/2018.*/
    static class Value<T> {
        String name;
        T value;

        Value(String name, T value) {
            this.name = name;
            this.value = value;
        }
    }

    static class MinMax {

        Integer min;
        Integer max;

        public MinMax(Integer min, Integer max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public String toString() {
            return "MinMax{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    }


    static class WorkWithFiles {
        static File createFile(String filePath) {
            File f = new File(filePath);
//            f.getParentFile().mkdirs();
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return f;
        }

        static void writeStringIntoFile(String value, File file) {
            try (FileWriter outFile = new FileWriter(file); BufferedWriter bWriter = new BufferedWriter(outFile)) {
                bWriter.write(value);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        static List<Integer> readContentFromFile(File file) {
            List<Integer> list = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(file.getPath()))) {
                list = Pattern.compile(";").splitAsStream(reader.readLine()).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.println(list.toString());
            return list;
        }
    }

    public static void main(String[] args) {
        String pathFirstFile = "one.txt";
        String pathSecondFile = "two.txt";
        String firstString = "1;2;3;4;5;6";
        String secondString = "1;2;7;4;7;6";
        File firstFile = WorkWithFiles.createFile(pathFirstFile);
        File secondFile = WorkWithFiles.createFile(pathSecondFile);
        WorkWithFiles.writeStringIntoFile(firstString, firstFile);
        WorkWithFiles.writeStringIntoFile(secondString, secondFile);
        List<File> files = new ArrayList<>();
        files.add(firstFile);
        files.add(secondFile);

        List<Value<List<Integer>>> nameAndValues = files.stream()
                .map(f -> new Value<>(f.getName(), WorkWithFiles.readContentFromFile(f)))
                .collect(Collectors.toList());

        List<Value<MinMax>> results = nameAndValues.stream().map(v ->
                new Value<>(v.name, new MinMax(
                        v.value.stream().mapToInt(Integer::intValue).min().getAsInt(),
                        v.value.stream().mapToInt(Integer::intValue).max().getAsInt()
                ))
        ).collect(Collectors.toList());

        results.forEach(System.out::println);
    }

}