package ru.job4j.io;

import java.io.*;

public class ByteArrayStream {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[] {'J', 'a', 'v', 'a'};
        ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
        int data;
        while ((data = stream.read()) != -1) {
            System.out.print((char)data);
        }
        String str = "123456789";
        byte[] bytes1 = str.getBytes();
        ByteArrayInputStream byteStream2 = new ByteArrayInputStream(bytes1, 3, 4);
        int temp;
        while ((temp = byteStream2.read()) != -1) {
            System.out.print((char)temp);
        }
        FileOutputStream file = new FileOutputStream("data/exemple.txt");
        byte[] array = "1,2,3,4,word".getBytes();
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        byteArray.writeBytes(array);
        byteArray.writeTo(file);
    }
}
