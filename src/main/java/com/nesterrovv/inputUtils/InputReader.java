package com.nesterrovv.inputUtils;

import com.nesterrovv.application.CollectionManager;
import com.nesterrovv.data.Coordinates;
import com.nesterrovv.data.Country;
import com.nesterrovv.data.EyeColor;
import com.nesterrovv.data.HairColor;
import com.nesterrovv.data.Location;
import com.nesterrovv.data.Person;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputReader {

    private final CollectionManager collectionManager;

    public InputReader(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Method for receiving name of element
     * @return String name
     */
    public String receiveName() {
        for ( ; ; ) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a name: ");
                String name = scanner.nextLine().trim();
                if (name.equals("")) {
                    System.out.println("This value cannot be empty. Try again");
                    continue;
                }
                return name;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be string. Try again.");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully.");
                System.exit(0);
            }
        }
    }

    /**
     * Method for receiving x-coordinate of element
     * @return long x
     */
    public double receiveX() {
        for ( ; ; ) {
            try {
                System.out.print("Enter X coordinate. Max value is 690. Value cannot be empty: ");
                Scanner scanner = new Scanner(System.in);
                double x = scanner.nextDouble();
                String xx = Double.toString(x);
                if (x > 690) {
                    System.out.println("Max value is 690. Try again. ");
                    continue;
                }
                if (xx.equals("") ) {
                    System.out.println("This value cannot be empty. Try again. ");
                    continue;
                }
                return x;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a double-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(0);
            }
        }
    }

    /**
     * Method for receiving y-coordinate of element
     * @return Float y
     */
    public int receiveY() {
        for ( ; ; ) {
            try {
                System.out.print("Enter Y coordinate. This value cannot be empty: ");
                Scanner scanner = new Scanner(System.in);
                return scanner.nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a int-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully.");
                System.exit(0);
            }
        }
    }

    /** Method for making coordinates by using methods receiveX() and receiveY() */
    public Coordinates receiveCoordinates() {
        return new Coordinates(receiveX(), receiveY());
    }

    /**
     * Method for receiving height of element
     * @return long height
     */
    public double receiveHeight() {
        for ( ; ; ) {
            try {
                System.out.print("Enter height. Value must be greater than 0: ");
                Scanner scanner = new Scanner(System.in);
                double height = scanner.nextDouble();
                if (height <= 0) {
                    System.out.println("This value must be greater than 0. Try again. ");
                    continue;
                }
                return height;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a double-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully.");
                System.exit(0);
            }
        }
    }

    /**
     * Method for receiving x-coordinate of location of element
     * @return long xLocation
     */
    public double receiveXLocation() {
        for ( ; ; ) {
            try {
                System.out.print("Enter X coordinate of location: ");
                Scanner scanner = new Scanner(System.in);
                return scanner.nextDouble();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a double-type number. Try again. ");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully.");
                System.exit(0);
            }
        }
    }

    /**
     * Method for receiving y-coordinate of element
     * @return Double yLocation
     */
    public float receiveYLocation() {
        for ( ; ; ) {
            try {
                System.out.print("Enter Y coordinate of location: ");
                Scanner scanner = new Scanner(System.in);
                return scanner.nextFloat();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a float-type number. Try again.");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully.");
                System.exit(0);
            }
        }
    }

    /**
     * Method for receiving name of element`s location
     * @return String nameLocation
     */
    public String receiveNameLocation() {
        for ( ; ; ) {
            try {
                System.out.print("Enter a name of location: ");
                Scanner scanner = new Scanner(System.in);
                String nameLocation = scanner.nextLine();
                if (nameLocation.equals("")) {
                    System.out.println("This value cannot be empty. Try again.");
                }
                return nameLocation;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a string. Try again.");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully.");
                System.exit(0);
            }
        }
    }

    /**
     * Method for receiving Location field by using methods receiveXLocation(),
     * receiveYLocation() and receiveNameLocation()
     * @return Location location
     */
    public Location receiveLocation() {
        return new Location(receiveXLocation(), receiveYLocation(), receiveNameLocation());
    }

    /**
     * Method for receiving eye color of element
     * @return EyeColor eyeColor
     */
    public EyeColor receiveEyeColor() {
        for ( ; ; ) {
            try {
                System.out.println("Choose variant of eye color. Enter color or the number corresponding " +
                        "to the desired option.");
                System.out.print("Variants: \n1. GREEN; \n2. RED; \n3. BLUE.\nEnter your variant here: ");
                Scanner scanner = new Scanner(System.in);
                String eyeChoose = scanner.nextLine().toUpperCase(Locale.ROOT);
                switch (eyeChoose) {
                    case "1":
                    case "GREEN":
                        return EyeColor.GREEN;
                    case "2":
                    case "RED":
                        return EyeColor.RED;
                    case "3":
                    case "BLUE":
                        return EyeColor.BLUE;
                    default:
                        System.out.println("You should to choose the color from list or it's number. Try again.");
                        break;
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a string with color name or it's number. Try again.");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully.");
                System.exit(0);
            }
        }
    }

    /**
     * Method for receiving hair color of element
     * @return HairColor hairColor
     */
    public HairColor receiveHairColor() {
        for ( ; ; ) {
            try {
                System.out.println("Choose variant of hair color. Enter color or the number corresponding " +
                        "to the desired option.");
                System.out.print("Variants: \n1. BLUE; \n2. YELLOW; \n3. ORANGE.\nEnter your variant here: ");
                Scanner scanner = new Scanner(System.in);
                String hairChoice = scanner.nextLine().toUpperCase(Locale.ROOT);
                switch (hairChoice) {
                    case "1":
                    case "BLUE":
                        return HairColor.BLUE;
                    case "2":
                    case "YELLOW":
                        return HairColor.YELLOW;
                    case "3":
                    case "ORANGE":
                        return HairColor.ORANGE;
                    default:
                        System.out.println("You should to choose the color from list or it's number. Try again.");
                        break;
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a string with color name or it's number. Try again.");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(0);
            }
        }
    }

    /**
     * Method for receiving nationality of element
     * @return Country nationality
     */
    public Country receiveNationality() {
        for ( ; ; ) {
            try {
                System.out.println("Choose variant of nationality. Enter the country name or the number corresponding "
                        + "to the desired option.");
                System.out.print("Variants: \n1. GERMANY; \n2. CHINA; \n3. NORTH KOREA.\nEnter your variant here: ");
                Scanner scanner = new Scanner(System.in);
                String nationalityChoice = scanner.nextLine().toUpperCase(Locale.ROOT);
                switch (nationalityChoice) {
                    case "1":
                    case "GERMANY":
                        return Country.GERMANY;
                    case "2":
                    case "CHINA":
                        return Country.CHINA;
                    case "3":
                    case "NORTH_KOREA":
                        return Country.NORTH_KOREA;
                    default:
                        System.out.println("You should to choose the country name from list or it's number. " +
                                "Try again.");
                        break;
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a string with country name or it's number. Try again.");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was stopped successfully. ");
                System.exit(0);
            }
        }
    }

    public Person receivePerson() {
        return new Person.PersonBuilder(this.collectionManager)
                .id()
                .name(receiveName())
                .coordinates(receiveCoordinates())
                .creationDate()
                .height(receiveHeight())
                .eyeColor(receiveEyeColor())
                .hairColor(receiveHairColor())
                .nationality(receiveNationality())
                .location(receiveLocation())
                .build();
    }

}