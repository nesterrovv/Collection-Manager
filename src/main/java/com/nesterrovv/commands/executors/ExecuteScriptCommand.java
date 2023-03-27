package com.nesterrovv.commands.executors;

import com.nesterrovv.commands.commandActions.ExecuteScriptAction;
import com.nesterrovv.commands.interfaces.OneArgCommand;

public class ExecuteScriptCommand implements OneArgCommand {

    private final ExecuteScriptAction executeScriptAction;

    public ExecuteScriptCommand(ExecuteScriptAction executeScriptAction) {
        this.executeScriptAction = executeScriptAction;
    }

    public String execute(String filePath) {
        return this.executeScriptAction.doAction(filePath);
    }

}
