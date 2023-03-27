package com.nesterrovv.commands.executors;

import com.nesterrovv.commands.commandActions.GroupCountingByNationalityAction;
import com.nesterrovv.commands.interfaces.NoArgsCommand;

public class GroupCountingByNationalityCommand implements NoArgsCommand {

    private final GroupCountingByNationalityAction groupCountingByNationalityAction;

    public GroupCountingByNationalityCommand(GroupCountingByNationalityAction groupCountingByNationalityAction) {
        this.groupCountingByNationalityAction = groupCountingByNationalityAction;
    }

    public String execute() {
        return this.groupCountingByNationalityAction.doAction();
    }

}
