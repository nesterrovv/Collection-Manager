package com.nesterrovv.commands.commandActions;

import com.nesterrovv.application.CollectionManager;
import com.nesterrovv.data.Person;

import java.util.Set;

public class UpdateAction {

    private final CollectionManager collectionManager;

    public UpdateAction(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public String doAction(long id, Person updatedPerson) {
        Set<Person> collection = this.collectionManager.getCollection();
        for (Person person : collection) {
            if (person.getId().equals(id)) {
                collection.remove(person);
                updatedPerson.setId(id);
                collection.add(updatedPerson);
                return "Element has been updated!\n";
            }
        }
        return "Element has not been updated because there are no element with entered ID.\n";
    }

}
