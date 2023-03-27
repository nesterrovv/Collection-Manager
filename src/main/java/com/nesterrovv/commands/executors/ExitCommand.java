package com.nesterrovv.commands.executors;

import com.nesterrovv.commands.commandActions.ExitAction;
import com.nesterrovv.commands.interfaces.NoArgsCommand;

public class ExitCommand implements NoArgsCommand {

    private final ExitAction exitAction;

    public ExitCommand(ExitAction exitAction) {
        this.exitAction = exitAction;
    }

    public String execute() {
        return this.exitAction.doAction();
    }

}
