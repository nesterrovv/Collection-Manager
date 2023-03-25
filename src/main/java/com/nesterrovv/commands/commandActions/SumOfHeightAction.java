package com.nesterrovv.commands.commandActions;

import com.nesterrovv.application.CollectionManager;
import com.nesterrovv.data.Person;

import java.util.Set;

public class SumOfHeightAction {

    private final CollectionManager collectionManager;

    public SumOfHeightAction(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public String doAction() {
        Set<Person> collection = collectionManager.getCollection();
        double sumOfHeights = 0;
        for (Person person : collection) {
            sumOfHeights += person.getHeight();
        }
        return "Sum of height fields for all collection elements is: " + sumOfHeights;
    }

}
