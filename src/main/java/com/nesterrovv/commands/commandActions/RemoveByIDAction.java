package com.nesterrovv.commands.commandActions;

import com.nesterrovv.application.CollectionManager;
import com.nesterrovv.data.Person;
import com.nesterrovv.inputUtils.IDGenerator;

import java.util.Set;

public class RemoveByIDAction {

    private final CollectionManager collectionManager;

    public RemoveByIDAction(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public String doAction(long id) {
        Set<Person> collection = this.collectionManager.getCollection();
        for (Person person : collection) {
            if (person.getId().equals(id)) {
                collection.remove(person);
                IDGenerator.removeId(id);
                return "Element has been removed!\n";
            }
        }
        return "Element has not been removed because item with entered ID does not exists!\n";
    }
}
