package ru.job4j.serialization;
import java.io.*;
import java.nio.file.Files;
public class Contact implements Serializable {
    private String name;
    private int age;
    private int weight;

    public Contact(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact("Viktor", 32, 78);
        System.out.println(contact);

        File tempfile = Files.createTempFile(null,null).toFile();
        FileOutputStream fos = new FileOutputStream(tempfile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(contact);

        FileInputStream fis = new FileInputStream(tempfile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        final Contact contact1 = (Contact) ois.readObject();
        System.out.println(contact1);

    }
}
