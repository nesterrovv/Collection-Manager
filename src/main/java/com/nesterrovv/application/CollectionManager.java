package com.nesterrovv.application;

import com.nesterrovv.data.Person;
import com.nesterrovv.inputUtils.FileManager;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CollectionManager {

    private static CollectionManager INSTANCE;
    private Set<Person> collection;
    private final LocalDateTime collectionInitializationTime;
    private final Map<String, String> tutorial;

    public static CollectionManager getInstance(String pathToCollection) {
        if (INSTANCE == null) {
            INSTANCE = new CollectionManager(pathToCollection);
        }
        return INSTANCE;
    }

    public CollectionManager(String pathToCollection) {
        this.collectionInitializationTime = LocalDateTime.now();
        tutorial = new HashMap<>();
        tutorial.put("help", "get help on alternative commands");
        tutorial.put("info", "print all collection items into the string representation");
        tutorial.put("add {element}", "add new item to collection");
        tutorial.put("update id {element}", "update the value of the collection element " +
                "whose ID matches the given one");
        tutorial.put("remove_by_id id", "remove an element from the collection by its ID");
        tutorial.put("clear", "remove all items from collection");
        tutorial.put("save", "save collection to file");
        tutorial.put("execute_script filename", "read and execute script from given file. " +
                "The same views are found in the script as in the interactive mode");
        tutorial.put("exit", "exit the program (without closing in the file)");
        tutorial.put("add_if_min {element}", "add a new element to the collection if its value is " +
                "less than the smallest element in this collection");
        tutorial.put("remove_greater {element}", "remove from the collection all elements " +
                "strictly greater than the given one");
        tutorial.put("remove_lower", "remove from the collection all elements smaller than the given one");
        tutorial.put("sum_of_height", "print in the sum of the height field values for " +
                "all elements in the collection");
        tutorial.put("group_counting_by_nationality", "group the elements of the collection by belonging " +
                "to the fields of nationality, display the number of elements in each group.");
        tutorial.put("count_greater_than_nationality nationality", "display the number of items whose " +
                "nationality field value is greater than the given one");
        this.collection = FileManager.downloadCollection(pathToCollection);
    }

    public Set<Person> getCollection() {
        return collection;
    }

    public Map<String, String> getTutorial() {
        return tutorial;
    }

    public LocalDateTime getCollectionInitializationTime() {
        return collectionInitializationTime;
    }

    public void setCollection(Set<Person> collection) {
        this.collection = collection;
    }

}
