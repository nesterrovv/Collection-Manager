package com.nesterrovv.commands.executors;

import com.nesterrovv.commands.commandActions.InfoAction;
import com.nesterrovv.commands.interfaces.NoArgsCommand;

public class InfoCommand implements NoArgsCommand {

    private InfoAction infoAction;

    public InfoCommand(InfoAction infoAction) {
        this.infoAction = infoAction;
    }

    public String execute() {
        return this.infoAction.doAction();
    }

}
