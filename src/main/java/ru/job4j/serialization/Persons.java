package ru.job4j.serialization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "person")
@XmlAccessorType (XmlAccessType.FIELD)
public class Persons {
    @XmlAttribute
    private  String name;
    @XmlAttribute
    private  int age;
    @XmlAttribute
    private boolean language;
    private Contact contact;

    public  Persons() {

    };
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