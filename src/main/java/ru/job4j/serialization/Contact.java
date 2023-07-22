package ru.job4j.serialization;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.nio.file.Files;
@XmlRootElement (name = "contact")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contact implements Serializable {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private int age;
    @XmlAttribute
    private int weight;

    public Contact() {
    };

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
