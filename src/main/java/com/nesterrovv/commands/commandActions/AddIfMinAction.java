package com.nesterrovv.commands.commandActions;

import com.nesterrovv.application.CollectionManager;
import com.nesterrovv.data.Person;
import com.nesterrovv.inputUtils.IDGenerator;

import java.util.*;

public class AddIfMinAction {

    private final CollectionManager collectionManager;

    public AddIfMinAction(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public String doAction(Person newPerson) {
        Set<Person> collection = collectionManager.getCollection();
        List<Person> personList = new ArrayList<>(collectionManager.getCollection());
        Collections.sort(personList);
        if (newPerson.compareTo(personList.get(0)) < 0) {
            collection.add(newPerson);
            IDGenerator.saveId(newPerson.getId());
            return "Element has been added!\n";
        } else {
            return "Element has not been added because it's not lower then minimal element of collection.\n";
        }

    }
}
