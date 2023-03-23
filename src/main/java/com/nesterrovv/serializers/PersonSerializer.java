package com.nesterrovv.serializers;

import com.nesterrovv.data.Person;
import com.nesterrovv.wrappers.LocalDateTimeAdapter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class PersonSerializer {

    public static String serializePerson(Person person) {
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = context.createMarshaller();
            LocalDateTimeAdapter adapter = new LocalDateTimeAdapter();
            marshaller.setAdapter(LocalDateTimeAdapter.class, adapter);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter writer = new StringWriter();
            marshaller.marshal(person, writer);
            return writer.toString();
        } catch (JAXBException jaxbException) {
            System.err.println(jaxbException.getMessage());
            return "";
        }
    }

    public static Person deserialize(String xml) {
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            LocalDateTimeAdapter adapter = new LocalDateTimeAdapter();
            unmarshaller.setAdapter(LocalDateTimeAdapter.class, adapter);
            StringReader reader = new StringReader(xml);
            return (Person) unmarshaller.unmarshal(reader);
        } catch (JAXBException jaxbException) {
            System.err.println(jaxbException.getMessage());
            return new Person();
        }
    }

}
