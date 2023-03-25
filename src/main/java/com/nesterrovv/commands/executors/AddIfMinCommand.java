package com.nesterrovv.commands.executors;

import com.nesterrovv.commands.commandActions.AddIfMinAction;
import com.nesterrovv.commands.interfaces.OneArgCommand;
import com.nesterrovv.data.Person;
import com.nesterrovv.serializers.PersonSerializer;

public class AddIfMinCommand implements OneArgCommand {

    private AddIfMinAction addIfMinAction;

    public AddIfMinCommand(AddIfMinAction addIfMinAction) {
        this.addIfMinAction = addIfMinAction;
    }

    public String execute(String stringPerson) {
        Person person = PersonSerializer.deserialize(stringPerson);
        return this.addIfMinAction.doAction(person);
    }

}
