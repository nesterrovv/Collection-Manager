package com.nesterrovv.commands.executors;

import com.nesterrovv.commands.commandActions.RemoveLowerAction;
import com.nesterrovv.commands.interfaces.OneArgCommand;
import com.nesterrovv.data.Person;
import com.nesterrovv.serializers.PersonSerializer;

public class RemoveLowerCommand implements OneArgCommand {

    private RemoveLowerAction removeLowerAction;

    public RemoveLowerCommand(RemoveLowerAction removeLowerAction) {
        this.removeLowerAction = removeLowerAction;
    }

    public String execute(String stringPerson) {
        Person person = PersonSerializer.deserialize(stringPerson);
        return this.removeLowerAction.doAction(person);
    }

}
