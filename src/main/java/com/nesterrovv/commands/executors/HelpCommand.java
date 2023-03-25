package com.nesterrovv.commands.executors;

import com.nesterrovv.commands.interfaces.NoArgsCommand;
import com.nesterrovv.commands.commandActions.HelpAction;

public class HelpCommand implements NoArgsCommand {

    private final HelpAction helpAction;

    public HelpCommand(HelpAction helpAction) {
        this.helpAction = helpAction;
    }

    @Override
    public String execute() {
        return helpAction.doAction();
    }

}
