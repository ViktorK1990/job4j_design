package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogFilter {
    List<String> strings = new ArrayList<>();
    public List<String> filter(String file) {
       return null;
    }

    public static void main(String[] args) throws IOException {
        LogFilter logFilter = new LogFilter();
        BufferedReader reader = new BufferedReader(new FileReader("data/log.txt"));
        String temp;
        List<String> list = new ArrayList<>();
        while ((temp = reader.readLine()) != null) {
            list.add(temp);
        }
        list.stream()
                .filter(e-> e.contains(" 404 "))
                .toList()
                .forEach(System.out::println);
    }
}