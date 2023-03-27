# Collection-Manager

## Foreword

A few years ago, while learning about the Java Collections Framework and working with user input, 
I wrote an application to process collection items in user mode. However, a lot of time has passed 
and I decided to update that project, correcting old shortcomings in it and improving the quality 
of the code. Using the good coding practices I've learned over the years, whether it's using the 
Command, Wrapper, Singletone, and Builder patterns (which can be found in code) or just better
decomposition of tasks, I'm sure improved the quality of this project compared to its "ancestor" 
written about a year and a half ago. In addition, I plan to introduce some additional functionality 
and write good test scripts for the code to work correctly. The project will be supplemented 
and updated. So...

## Overview

An application for processing elements of a `java.util.HashSet` collection in user mode. The collection 
is stored in `.xml` format in a third-party file, the path to which must be specified as a 
command line argument. When the application starts, the collection is read and deserialized, 
the loaded data is validated and gets into the application. In the future, the user can enter 
various commands, initiating procedures for analyzing these data or changing them. The result 
of each command is displayed on the screen for informational purposes. Before starting work, 
it is recommended to enter a `help` to find out about the list of available commands and their
description (including the expected syntax). Type `exit` command or `ctrl + D` (Windows / *NIX) / `cmd + D` (macOS) 
for finishing a program.

## Functionality
1. ```help```: display help for available commands
1. ```info```: print information about the collection (type, date of initialization, number of elements, etc.) to standard output
1. ```show```: display all elements of the collection in string representation to standard output
1. ```add {element}```: add a new element to the collection
1. ```update id {element}```: update the value of the collection element whose id is equal to the given
1. ```remove_by_id id```: remove an item from the collection by its id
1. ```clear```: clear the collection
1. ```save```: save the collection to a file
1. ```execute_script file_name```: read and execute the script from the specified file. The script contains 
commands in the same form in which the user enters them interactively. A check to prevent ring recursion is included in the work of the team.
1. ```exit```: exit the program (without saving to file)
1. ```add_if_min {element}```: add a new element to the collection if its value is less than the smallest element in this collection
1. ```remove_greater {element}```: remove all elements greater than the specified one from the collection
1. ```remove_lower {element}```: remove all elements from the collection that are less than the given one
1. ```sum_of_height```: Print the sum of the values of the height field for all elements of the collection
1. ```group_counting_by_nationality```: group the elements of the collection by the value of the nationality field, display the number of 
elements in each group
1. ```count_greater_than_nationality nationality```: Print the number of items whose nationality is greater than the specified value

`{element}` syntax means, that user input is required after command executing start.

## Quick guide for starting

Download `CollectionManager.jar` file from root repository folder and run it your terminal via `java -jar CollectionManager.jar /path/to/collection`, 
where entered path is path to file with your xml-collection. 

## Future plans:
1. Writing an exhaustive test coverage to enable automatic testing of the code in the process of its refinement;
2. Documenation in `javadoc` format adding;
2. Adding new functionality, which is currently in the planning stage.

## At the end

If you find the project useful, I'll be happy to see your `star` tag on it. In addition, you can discuss it with me, 
suggest your ideas and corrections, as well as leave any feedback using the contact details indicated in my profile.
