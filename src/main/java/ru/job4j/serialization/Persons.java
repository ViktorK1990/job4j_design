package ru.job4j.serialization;

public class Persons {
    private final String name;
    private final int age;
    private boolean language;
    private Contact contact;

    public Persons(String name, int age, boolean language, Contact contact) {
        this.name = name;
        this.age = age;
        this.language = language;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", language=" + language +
                ", contact=" + contact +
                '}';
    }
}