package com.nesterrovv.commands.executors;

import com.nesterrovv.commands.commandActions.SumOfHeightAction;
import com.nesterrovv.commands.interfaces.NoArgsCommand;

public class SumOfHeightCommand implements NoArgsCommand {

    private final SumOfHeightAction sumOfHeightAction;

    public SumOfHeightCommand(SumOfHeightAction sumOfHeightAction) {
        this.sumOfHeightAction = sumOfHeightAction;
    }

    public String execute() {
        return this.sumOfHeightAction.doAction();
    }

}
