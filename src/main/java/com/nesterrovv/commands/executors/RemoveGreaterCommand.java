package com.nesterrovv.commands.executors;

import com.nesterrovv.commands.commandActions.RemoveGreaterAction;
import com.nesterrovv.commands.interfaces.OneArgCommand;
import com.nesterrovv.data.Person;
import com.nesterrovv.serializers.PersonSerializer;

public class RemoveGreaterCommand implements OneArgCommand {

    private final RemoveGreaterAction removeGreaterAction;

    public RemoveGreaterCommand(RemoveGreaterAction removeGreaterAction) {
        this.removeGreaterAction = removeGreaterAction;
    }

    public String execute(String stringPerson) {
        Person person = PersonSerializer.deserialize(stringPerson);
        return this.removeGreaterAction.doAction(person);
    }

}
