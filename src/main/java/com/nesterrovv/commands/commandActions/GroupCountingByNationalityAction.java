package com.nesterrovv.commands.commandActions;

import com.nesterrovv.application.CollectionManager;
import com.nesterrovv.data.Country;
import com.nesterrovv.data.Person;

import java.util.Set;

public class GroupCountingByNationalityAction {

    private final CollectionManager collectionManager;

    public GroupCountingByNationalityAction(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public String doAction() {
        Set<Person> collection = collectionManager.getCollection();
        int germansCounter = 0;
        int koreansCounter = 0;
        int chineseCounter = 0;
        for (Person person : collection) {
            Country nationality = person.getNationality();
            switch (nationality) {
                case GERMANY:
                    germansCounter++;
                    break;
                case NORTH_KOREA:
                    koreansCounter++;
                    break;
                case CHINA:
                    chineseCounter++;
                    break;
                default:
                    break;
            }
        }
        return  String.format("%-22s", "Germans number:")       + germansCounter + "\n" +
                String.format("%-22s", "North koreans number:") + koreansCounter + "\n" +
                String.format("%-22s", "Chinese number:")       + chineseCounter + "\n";
    }
}
