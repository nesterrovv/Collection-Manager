package com.nesterrovv.application;
public class Application {

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.out.println("Collection Manager application by Ivan Nesterov has been started!");
            System.out.println("Type any command. Type [help] for receiving list of available commands " +
                    "and it's descriptions");
            System.out.println("Type [exit] during command entering or click [ctrl + D] at any moment " +
                    "to over the program");
            new CommandReader(CollectionManager.getInstance(args[0])).run();
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.err.println("You forgot type path to file with collection as command line argument");
            System.err.println("Restart the program with entered argument.");
        }
    }

}
