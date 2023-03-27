package com.nesterrovv.commands.commandActions;

import com.nesterrovv.application.CollectionManager;
import com.nesterrovv.data.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShowAction {

    private final CollectionManager collectionManager;

    public ShowAction(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public String doAction() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Person> collectionCopy = new ArrayList<>(collectionManager.getCollection());
        Collections.sort(collectionCopy);
        stringBuilder.append("Collection content:").append("\n");
        for (Person person : collectionCopy) {
            stringBuilder.append(person.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

}
