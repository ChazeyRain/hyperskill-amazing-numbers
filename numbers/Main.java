package numbers;

import numbers.operations.*;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Amazing Numbers!\n" +
                "\n" +
                "Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");

        boolean isRunning = true;

        Scanner scanner = new Scanner(System.in);

        while (isRunning) {

            System.out.println("Enter a request:");

            String input = scanner.nextLine().toLowerCase(Locale.ROOT);

            if ("0".equals(input.trim())) {
                isRunning = false;
            } else {
                try {
                    Operation operation = Operation.operationFactory(input);
                    operation.start();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Goodbye!");
    }

}
