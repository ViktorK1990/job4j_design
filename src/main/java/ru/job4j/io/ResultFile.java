package ru.job4j.io;
import java.io.FileOutputStream;
public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/dataresult.txt")) {
            out.write("1 2 3 4".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("2 4 6 8".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("3 6 9 12".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("4 8 12 16".getBytes());
            out.write(System.lineSeparator().getBytes());

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
