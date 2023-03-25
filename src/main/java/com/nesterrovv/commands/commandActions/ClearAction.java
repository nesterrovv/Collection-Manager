package com.nesterrovv.commands.commandActions;

import com.nesterrovv.application.CollectionManager;
import com.nesterrovv.inputUtils.IDGenerator;

public class ClearAction {

    private final CollectionManager collectionManager;

    public ClearAction(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public String doAction() {
        this.collectionManager.getCollection().clear();
        IDGenerator.removeAllIds();
        return "Collection has been cleaned!\n";
    }

}
