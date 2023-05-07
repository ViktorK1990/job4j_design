package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File dir = new File("C:/projects");
        if(!dir.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", dir.getAbsoluteFile()));
        }
        if(!dir.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", dir.getAbsoluteFile()));
        }
       for (File file : dir.listFiles()) {
           System.out.printf("Name of directory: %s, Directory size: %d\n", file.getName(), file.length());
       }

    }


}
