package com.nesterrovv.commands.executors;

import com.nesterrovv.commands.commandActions.ClearAction;
import com.nesterrovv.commands.interfaces.NoArgsCommand;

public class ClearCommand implements NoArgsCommand {

    private final ClearAction clearAction;

    public ClearCommand(ClearAction clearAction) {
        this.clearAction = clearAction;
    }

    public String execute() {
        return this.clearAction.doAction();
    }

}
