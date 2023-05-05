package ru.job4j.io;

import java.io.*;

public class Buffered {
    public static void main(String[] args) {
        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream("data/input.txt"));
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("data/output.txt"));
            BufferedInputStream in2 = new BufferedInputStream(new FileInputStream("data/input.txt"));
            BufferedOutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream("data/newData.txt", true)))
        {  outputStream.write(in.readAllBytes());
            outputStream1.write(in2.readAllBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
