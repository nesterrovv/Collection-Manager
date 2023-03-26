package com.nesterrovv.application;

import com.nesterrovv.inputUtils.InputReader;
import com.nesterrovv.serializers.PersonSerializer;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CommandReader {

    private String command = "";
    private final CollectionManager collectionManager;

    public CommandReader(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void run() {
        try {
            try (Scanner commandReader = new Scanner(System.in)) {
                CommandInvoker commandInvoker = new CommandInvoker(this.collectionManager);
                while (!command.equals("exit")) {
                    System.out.print("Enter a command: ");
                    command = commandReader.nextLine();
                    String[] splitCommand = command.trim().toLowerCase().split(" ", 2);
                    InputReader inputReader = new InputReader(this.collectionManager);
                    try {
                        switch (splitCommand[0]) {
                            case "":
                                break;
                            case "help":
                                System.out.println(commandInvoker.help());
                                break;
                            case "info":
                                System.out.println(commandInvoker.info());
                                break;
                            case "show":
                                System.out.println(commandInvoker.show());
                                break;
                            case "add":
                                System.out.println(commandInvoker.add(PersonSerializer
                                        .serializePerson(inputReader.receivePerson())));
                                break;
                            case "update":
                                System.out.println(commandInvoker.update(splitCommand[1],
                                        PersonSerializer.serializePerson(inputReader.receivePerson())));
                                break;
                            case "remove_by_id":
                                System.out.println(commandInvoker.removeByID(splitCommand[1]));
                                break;
                            case "clear":
                                System.out.println(commandInvoker.clear());
                                break;
                            case "save":
                                System.out.println(commandInvoker.save());
                                break;
                            case "execute_script":
                                System.out.println(commandInvoker.executeScript(splitCommand[1]));
                                break;
                            case "exit":
                                System.out.println(commandInvoker.exit());
                                break;
                            case "add_if_min":
                                System.out.println(commandInvoker.addIfMin(PersonSerializer
                                        .serializePerson(inputReader.receivePerson())));
                                break;
                            case "remove_greater":
                                System.out.println(commandInvoker.removeGreater(PersonSerializer
                                        .serializePerson(inputReader.receivePerson())));
                                break;
                            case "remove_lower":
                                System.out.println(commandInvoker.removeLower(PersonSerializer
                                        .serializePerson(inputReader.receivePerson())));
                                break;
                            case "sum_of_height":
                                System.out.println(commandInvoker.sumOfHeight());
                                break;
                            case "group_counting_by_nationality":
                                System.out.println(commandInvoker.groupCountingByNationality());
                                break;
                            case "count_greater_than_nationality":
                                System.out.println(commandInvoker.countGreaterThanNationality(
                                        String.valueOf(inputReader.receiveNationality())));
                                break;
                            default:
                                System.out.println("Unknown command. Write help for getting list of available" +
                                        "commands and it's descriptions.");
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Argument of command is absent. Write help for getting list of available " +
                                "commands and it's descriptions.");
                    }
                }
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program will be finished now.");
            System.exit(0);
        }
    }
}
