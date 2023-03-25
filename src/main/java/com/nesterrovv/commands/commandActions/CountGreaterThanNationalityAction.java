package com.nesterrovv.commands.commandActions;

import com.nesterrovv.application.CollectionManager;
import com.nesterrovv.data.Country;
import com.nesterrovv.data.Person;

import java.util.Set;

public class CountGreaterThanNationalityAction {

    private final CollectionManager collectionManager;

    public CountGreaterThanNationalityAction(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public String doAction(Country givenCountry) {
        Set<Person> collection = this.collectionManager.getCollection();
        int greaterElementsCounter = 0;
        for (Person person : collection) {
            if (person.getNationality().ordinal() > givenCountry.ordinal()) {
                greaterElementsCounter++;
            }
        }
        return "Elements amount, which nationality field is greater than a given, is: " + greaterElementsCounter;
    }

}
