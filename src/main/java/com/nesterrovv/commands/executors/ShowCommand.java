package com.nesterrovv.commands.executors;

import com.nesterrovv.commands.commandActions.ShowAction;
import com.nesterrovv.commands.interfaces.NoArgsCommand;

public class ShowCommand implements NoArgsCommand {

    private final ShowAction showAction;

    public ShowCommand(ShowAction showAction) {
        this.showAction = showAction;
    }

    public String execute() {
        return this.showAction.doAction();
    }

}
