import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by David on 9/26/2016.
 */
abstract class Order implements PizzaStore {

    static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        final String ALL_ITEMS_PATTERN = "%-25s | $%-4.2f\n";

        String output = "All Items\n------------------\n" +
                String.format("%-25s | %-5s\n", "Item", "Price") +
                String.format(ALL_ITEMS_PATTERN, "Small Vegetarian Pizza", S_VEGETARIAN_PRICE) +
                String.format(ALL_ITEMS_PATTERN, "Medium Vegetarian Pizza", M_VEGETARIAN_PRICE) +
                String.format(ALL_ITEMS_PATTERN, "Large Vegetarian Pizza", L_VEGETARIAN_PRICE) +
                String.format(ALL_ITEMS_PATTERN, "Small Cheese Pizza", S_CHEESE_PRICE) +
                String.format(ALL_ITEMS_PATTERN, "Medium Cheese Pizza", M_CHEESE_PRICE) +
                String.format(ALL_ITEMS_PATTERN, "Large Cheese Pizza", L_CHEESE_PRICE) +
                String.format(ALL_ITEMS_PATTERN, "Small Pepperoni Pizza", S_PEPPERONI_PRICE) +
                String.format(ALL_ITEMS_PATTERN, "Medium Pepperoni Pizza", M_PEPPERONI_PRICE) +
                String.format(ALL_ITEMS_PATTERN, "Large Pepperoni Pizza", L_PEPPERONI_PRICE) +
                String.format(ALL_ITEMS_PATTERN, "Drink", DRINK_PRICE) +
                String.format(ALL_ITEMS_PATTERN, "Salad", SALAD_PRICE) +
                String.format(ALL_ITEMS_PATTERN, "Soup", SOUP_PRICE);

        System.out.println(output);
    }

    static String askForValidStringInput(String inputQuery, String[] validInput) {
        String input;
        while (true) {
            System.out.print(inputQuery);

            input = scanner.next().toLowerCase();

            for (String valid : validInput) {
                if (valid.toLowerCase().equals(input))
                    return input;
            }

            System.out.println("Invalid input.");
        }
    }

    static int askForValidIntegerInput(String inputQuery) {
        int input;

        while (true) {
            System.out.print(inputQuery);

            try {
                input = scanner.nextInt();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
            }
        }
    }
}