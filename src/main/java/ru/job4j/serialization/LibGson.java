package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LibGson {
    public static void main(String[] args) {
        Persons persons = new Persons("Viktor", 32, true, new Contact("Viktor", 32, 78));
        Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(persons));

        String gsonMode =
                "{"
                        + "\"name\":\"Viktor\","
                        + "\"age\":35,"
                        + "\"language\":true,"
                        + "\"contact\":"
                        + "{"
                        + "\"name\":\"Viktor\","
                        + "\"age\":32,"
                        + "\"weight\":78"
                        + "}"
                        + "}";

        Persons persons1 = gson.fromJson(gsonMode, Persons.class);
        System.out.println(persons1);
    }
}
