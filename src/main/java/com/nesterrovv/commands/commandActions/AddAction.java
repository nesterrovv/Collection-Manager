package com.nesterrovv.commands.commandActions;

import com.nesterrovv.application.CollectionManager;
import com.nesterrovv.data.Person;
import com.nesterrovv.inputUtils.IDGenerator;

public class AddAction {

    private final CollectionManager collectionManager;

    public AddAction(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public String doAction(Person person) {
        this.collectionManager.getCollection().add(person);
        IDGenerator.saveId(person.getId());
        return "Element has been added!\n";
    }
}
