package com.nesterrovv.commands.commandActions;
import com.nesterrovv.application.CollectionManager;
import com.nesterrovv.data.Person;
import com.nesterrovv.inputUtils.IDGenerator;

import java.util.HashSet;
import java.util.Set;

public class RemoveLowerAction {

    private final CollectionManager collectionManager;

    public RemoveLowerAction(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public String doAction(Person person) {
        Set<Person> collection = this.collectionManager.getCollection();
        Set<Person> newCollection = new HashSet<>();
        for (Person current : collection) {
            if (current.compareTo(person) > 0) {
                IDGenerator.removeId(current.getId());
            } else {
                newCollection.add(current);
            }
        }
        this.collectionManager.setCollection(newCollection);
        return "All elements which are lower then given were removed\n";
    }
}