package com.nesterrovv.commands.executors;

import com.nesterrovv.commands.commandActions.UpdateAction;
import com.nesterrovv.commands.interfaces.TwoArgsCommand;
import com.nesterrovv.data.Person;
import com.nesterrovv.serializers.PersonSerializer;

public class UpdateCommand implements TwoArgsCommand {

    private UpdateAction updateAction;

    public UpdateCommand(UpdateAction updateAction) {
        this.updateAction = updateAction;
    }

    public String execute(String stringID, String stringPerson) {
        long id = Long.parseLong(stringID);
        Person person = PersonSerializer.deserialize(stringPerson);
        return this.updateAction.doAction(id, person);
    }

}
