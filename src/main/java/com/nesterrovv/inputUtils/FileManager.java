package com.nesterrovv.inputUtils;

import com.nesterrovv.data.Person;
import com.nesterrovv.serializers.CollectionSerializer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FileManager {

    private static String pathToCollection;

    public static boolean checkFilePermissions(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) return false;
        if (!file.canRead()) return false;
        return file.canWrite();
    }

    public static boolean validatePerson(Person person) {
        if (person.getId() == null) return false;
        if (person.getId() <= 0) return false;
        // TODO if person.getId() not unique
        if (person.getName() == null) return false;
        if (person.getCoordinates() == null) return false;
        if (person.getCoordinates().getX() > 690) return false;
        if (person.getCreationDate() == null) return false;
        if (person.getHeight() <= 0) return false;
        if (person.getEyeColor() == null) return false;
        if (person.getNationality() == null) return false;
        if (person.getLocation() == null) return false;
        return person.getLocation().getName() != null;
    }

    public static Set<Person> downloadCollection(String filePath) {
        int counterOfValidatedItems = 0;
        int counterOfNotValidatedItems = 0;
        Set<Person> collection = new HashSet<>();
            if (checkFilePermissions(filePath)) {
                pathToCollection = filePath;
                //String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
                Set<Person> set = CollectionSerializer.unmarshal(filePath);
                for (Person current : set) {
                    if (validatePerson(current)) {
                        collection.add(current);
                        IDGenerator.saveId(current.getId());
                        counterOfValidatedItems++;
                    } else {
                        counterOfNotValidatedItems++;
                    }
                }
                System.out.println("Collection downloaded. All items has been validated.");
                System.out.println(counterOfValidatedItems + " items has been validated and loaded.");
                System.out.println(counterOfNotValidatedItems + " items has not been validated and not loaded.");
            } else {
                System.err.println("File not found or permissions for read/write are denied. " +
                        "Downloaded empty collection.");
            }
            return collection;
    }

    public static boolean saveCollection(String filePath, Set<Person> collection) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            String xml = CollectionSerializer.marshal(collection);
            writer.write(xml);
            writer.close();
            return true;
        } catch (IOException ioException) {
            System.err.println("Cannot save collection to file. Try again.");
            return false;
        }
    }

    public static String getPathToCollection() {
        return pathToCollection;
    }

    public static void setPathToCollection(String newPathToCollection) {
        pathToCollection = newPathToCollection;
    }

}
