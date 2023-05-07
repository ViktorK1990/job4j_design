package ru.job4j.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() throws IOException {
       BufferedReader read = new BufferedReader(new FileReader(this.path));
            String text;
            while ((text = read.readLine()) != null) {
            if (text.startsWith("#") || text.isEmpty()) {
                continue;
            }
            if(!text.contains("=") || text.startsWith("=") || text.endsWith("=")){
                throw new IllegalArgumentException();
            }

            else  {
                String[] split = text.split("=", 2);
                values.put(split[0], split[1]);
            }
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Config("data/app.properties"));
        Config config = new Config("data/app.properties");
    }

}