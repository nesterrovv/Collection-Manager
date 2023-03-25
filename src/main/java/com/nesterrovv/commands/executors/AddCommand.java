package com.nesterrovv.commands.executors;

import com.nesterrovv.commands.commandActions.AddAction;
import com.nesterrovv.commands.interfaces.OneArgCommand;
import com.nesterrovv.data.Person;
import com.nesterrovv.serializers.PersonSerializer;

public class AddCommand implements OneArgCommand {

    private AddAction addAction;

    public AddCommand(AddAction addAction) {
        this.addAction = addAction;
    }

    public String execute(String stringPerson) {
        Person person = PersonSerializer.deserialize(stringPerson);
        return this.addAction.doAction(person);
    }

}
