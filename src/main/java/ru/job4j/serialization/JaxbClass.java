package ru.job4j.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class JaxbClass {
    public static void main(String[] args) throws JAXBException, IOException {
        File file = new File("C:/projects/job4j_design/src/main/java/ru/job4j/serialization/123.xml");
        Persons persons = new Persons("Viktor", 32, true, new Contact("Viktor", 32, 79));
        JAXBContext context = JAXBContext.newInstance(Persons.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(persons, file);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        Persons persons1 = (Persons) unmarshaller.unmarshal(file);
        System.out.println(persons1);
    }
}
