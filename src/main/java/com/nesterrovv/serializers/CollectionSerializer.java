package com.nesterrovv.serializers;

import com.nesterrovv.data.Person;
import com.nesterrovv.inputUtils.IDGenerator;
import com.nesterrovv.wrappers.PersonsHashSet;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class CollectionSerializer {

    public static Set<Person> unmarshal(String filepath) {
        Set<Person> collection = new HashSet<>();
        try {
            final QName qName = new QName("person");
            InputStream inputStream = new FileInputStream(filepath);
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(inputStream);
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            XMLEvent e;
            while ((e = xmlEventReader.peek()) != null) {
                if (e.isStartElement() && ((StartElement) e).getName().equals(qName)) {
                    Person unmarshalledPerson = unmarshaller.unmarshal(xmlEventReader, Person.class).getValue();
                    collection.add(unmarshalledPerson);
                } else {
                    xmlEventReader.next();
                }
            }
            return collection;
        } catch (JAXBException jaxbException) {
            System.err.println("XML syntax error");
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println(filepath);
            fileNotFoundException.printStackTrace();
            System.err.println("File not found");
        } catch (XMLStreamException xmlStreamException) {
            System.err.println("XML file reading exception");
        }
        return collection;
    }

    public static String marshal(Set<Person> collection) {
        try {
            PersonsHashSet personSetWrapper = new PersonsHashSet(collection);
            JAXBContext jaxbContext = JAXBContext.newInstance(PersonsHashSet.class, Person.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(personSetWrapper, stringWriter);
            return stringWriter.toString();
        } catch (JAXBException e) {
            System.out.println("here");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return "";
        }
    }


}
