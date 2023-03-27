package com.nesterrovv.commands.commandActions;

import com.nesterrovv.application.CollectionManager;
import com.nesterrovv.commands.executors.*;
import com.nesterrovv.inputUtils.FileManager;
import com.nesterrovv.inputUtils.InputReader;
import com.nesterrovv.serializers.PersonSerializer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class ExecuteScriptAction {

    private final CollectionManager collectionManager;
    private static final Set<String> callStack = new LinkedHashSet<>();


    public ExecuteScriptAction(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public String doAction(String pathToScript) {
        if (!callStack.contains(pathToScript)) {
            callStack.add(pathToScript);
            // do script
            StringBuilder results = new StringBuilder();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(pathToScript));
                String[] splitCommand;
                String command;
                InputReader inputReader = new InputReader(this.collectionManager);
                while ((command = reader.readLine()) != null) {
                    splitCommand = command.trim().toLowerCase().split(" ", 2);
                    switch (splitCommand[0]) {
                        case "help":
                            results.append(new HelpCommand(new HelpAction(this.collectionManager)).execute())
                                    .append("\n");
                            break;
                        case "info":
                            results.append(new InfoCommand(new InfoAction(this.collectionManager)).execute())
                                    .append("\n");
                            break;
                        case "show":
                            results.append(new ShowCommand(new ShowAction(this.collectionManager)).execute())
                                    .append("\n");
                            break;
                        case "add":
                            results.append(new AddCommand(new AddAction(this.collectionManager))
                                    .execute(PersonSerializer.serializePerson(inputReader.receivePerson())))
                                    .append("\n");
                            break;
                        case "update":
                            results.append(new UpdateCommand(new UpdateAction(this.collectionManager))
                                    .execute(splitCommand[1],
                                            PersonSerializer.serializePerson(inputReader.receivePerson())))
                                    .append("\n");
                            break;
                        case "remove_by_id":
                            results.append(new RemoveByIDCommand(new RemoveByIDAction(this.collectionManager))
                                    .execute(splitCommand[1])).append("\n");
                            break;
                        case "clear":
                            results.append(new ClearCommand(new ClearAction(this.collectionManager)).execute())
                                    .append("\n");
                            break;
                        case "save":
                            results.append(FileManager.saveCollection(FileManager.getPathToCollection(),
                                    this.collectionManager.getCollection())).append("\n");
                            break;
                        case "execute_script":
                            results.append(new ExecuteScriptCommand(new ExecuteScriptAction(this.collectionManager))
                                    .execute(splitCommand[1])).append("\n");
                            System.out.println("This script cannot to contain this command.");
                            break;
                        case "exit":
                            results.append(new ExitCommand(new ExitAction()).execute()).append("\n");
                        case "add_if_min":
                            results.append(new AddIfMinCommand(new AddIfMinAction(this.collectionManager)).execute(
                                    PersonSerializer.serializePerson(inputReader.receivePerson()))).append("\n");
                            break;
                        case "remove_greater":
                            results.append(new RemoveGreaterCommand(new RemoveGreaterAction(this.collectionManager))
                                    .execute(PersonSerializer.serializePerson(inputReader.receivePerson())))
                                    .append("\n");
                            break;
                        case "remove_lower":
                            results.append(new RemoveLowerCommand(new RemoveLowerAction(this.collectionManager))
                                    .execute(PersonSerializer.serializePerson(inputReader.receivePerson())))
                                    .append("\n");
                            break;
                        case "sum_of_height":
                            results.append(new SumOfHeightCommand(new SumOfHeightAction(this.collectionManager))
                                    .execute()).append("\n");
                            break;
                        case "group_counting_by_nationality":
                            results.append(new GroupCountingByNationalityCommand(
                                    new GroupCountingByNationalityAction(this.collectionManager)).execute())
                                    .append("\n");
                            break;
                        case "count_greater_than_nationality":
                            results.append(new CountGreaterThanNationalityCommand(
                                    new CountGreaterThanNationalityAction(this.collectionManager))
                                    .execute(String.valueOf(inputReader.receiveNationality()))).append("\n");
                            break;
                        default:
                            reader.readLine();
                            break;
                    }
                }
            } catch (FileNotFoundException fileNotFoundException) {
                return "File with script not found. Check path to script and try again.\n";
            } catch (IOException ioException) {
                return "File reading problems. Try to check file permissions or syntax and try again.\n";
            }
            callStack.remove(pathToScript);
            return results.toString();
        } else {
            return "Ring recursion detected. Script executing aborted.\n";
        }
    }

}
