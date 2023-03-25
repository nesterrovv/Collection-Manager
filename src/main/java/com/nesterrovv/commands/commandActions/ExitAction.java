package com.nesterrovv.commands.commandActions;

public class ExitAction {

    public String doAction() {
        System.out.println("Finishing a program...");
        System.exit(0);
        return "Program finished!\n";
    }

}
