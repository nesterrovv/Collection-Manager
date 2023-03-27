package com.nesterrovv.commands.executors;

import com.nesterrovv.commands.commandActions.CountGreaterThanNationalityAction;
import com.nesterrovv.commands.interfaces.OneArgCommand;
import com.nesterrovv.data.Country;

public class CountGreaterThanNationalityCommand implements OneArgCommand {

    private final CountGreaterThanNationalityAction countGreaterThanNationalityAction;

    public CountGreaterThanNationalityCommand(CountGreaterThanNationalityAction countGreaterThanNationalityAction) {
        this.countGreaterThanNationalityAction = countGreaterThanNationalityAction;
    }

    public String execute(String stringNationality) {
        Country nationality = Country.valueOf(stringNationality);
        return this.countGreaterThanNationalityAction.doAction(nationality);
    }

}
