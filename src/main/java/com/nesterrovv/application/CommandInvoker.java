package com.nesterrovv.application;

import com.nesterrovv.commands.commandActions.*;
import com.nesterrovv.commands.executors.*;
import com.nesterrovv.inputUtils.FileManager;

public class CommandInvoker {

    private final CollectionManager collectionManager;

    public CommandInvoker(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public String add(String stringPerson) {
        return new AddCommand(new AddAction(this.collectionManager)).execute(stringPerson);
    }

    public String addIfMin(String stringPerson) {
        return new AddIfMinCommand(new AddIfMinAction(this.collectionManager)).execute(stringPerson);
    }

    public String clear() {
        return new ClearCommand(new ClearAction(this.collectionManager)).execute();
    }

    public String countGreaterThanNationality(String stringNationality) {
        return new CountGreaterThanNationalityCommand
                (new CountGreaterThanNationalityAction(this.collectionManager)).execute(stringNationality);
    }

    public String exit() {
        return new ExitCommand(new ExitAction()).execute();
    }

    public String groupCountingByNationality() {
        return new GroupCountingByNationalityCommand
                (new GroupCountingByNationalityAction(this.collectionManager)).execute();
    }

    public String help() {
        return new HelpCommand(new HelpAction(this.collectionManager)).execute();
    }

    public String info() {
        return new InfoCommand(new InfoAction(this.collectionManager)).execute();
    }

    public String removeByID(String stringId) {
        return new RemoveByIDCommand(new RemoveByIDAction(collectionManager)).execute(stringId);
    }

    public String removeGreater(String stringPerson) {
        return new RemoveGreaterCommand(new RemoveGreaterAction(this.collectionManager)).execute(stringPerson);
    }

    public String removeLower(String stringPerson) {
        return new RemoveLowerCommand(new RemoveLowerAction(this.collectionManager)).execute(stringPerson);
    }

    public String show() {
        return new ShowCommand(new ShowAction(this.collectionManager)).execute();
    }

    public String sumOfHeight() {
        return new SumOfHeightCommand(new SumOfHeightAction(this.collectionManager)).execute();
    }

    public String update(String stringID, String stringPerson) {
        return new UpdateCommand(new UpdateAction(this.collectionManager)).execute(stringID, stringPerson);
    }

    public String save() {
        boolean isSaved = FileManager.saveCollection(FileManager.getPathToCollection(),
                collectionManager.getCollection());
        if (isSaved) {
            return "Collection saved!\n";
        } else {
            return "Cannot save collection. Try again.\n";
        }
    }

    public String executeScript(String filePath) {
        return new ExecuteScriptCommand(new ExecuteScriptAction(this.collectionManager)).execute(filePath);
    }

}
