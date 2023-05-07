package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
       try( BufferedReader reader = new BufferedReader(new FileReader(source));
            PrintWriter writer = new PrintWriter(new FileOutputStream(target, true));) {
           String text;
           while ((text = reader.readLine()) != null) {
                if(text.startsWith("200") || text.startsWith("300")) {
                    writer.println(text);
                }
           }

        }
       catch (Exception e) {
           e.printStackTrace();
       }

    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
