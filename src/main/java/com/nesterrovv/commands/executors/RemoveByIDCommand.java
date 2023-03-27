package com.nesterrovv.commands.executors;

import com.nesterrovv.commands.commandActions.RemoveByIDAction;
import com.nesterrovv.commands.interfaces.OneArgCommand;

public class RemoveByIDCommand implements OneArgCommand {

    private final RemoveByIDAction removeByIDAction;

    public RemoveByIDCommand(RemoveByIDAction removeByIDAction) {
        this.removeByIDAction = removeByIDAction;
    }

    public String execute(String stringID) {
        Long id = Long.parseLong(stringID);
        return this.removeByIDAction.doAction(id);
    }

}
