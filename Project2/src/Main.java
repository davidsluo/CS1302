import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by David on 10/3/2016.
 */
public class Main {

    private static List<Order> orders  = new ArrayList<>();
    private static Scanner     scanner = new Scanner(System.in);


    public static void main(String[] args) {

        boolean cont;
        System.out.println("Welcome to <Pizza Place>.");
        while (true) {
            try {

                do {
                    // TODO: 10/4/2016 Loop this for new orders
                    cont = true;
                    Order order = new Order();
                    while (cont) {
                        Order.printMenu();
                        System.out.println(Order.getOptionsMenu());
                        switch (scanner.next()) {
                            case "1":
                                do {
                                    Pizza.Topping topping = null;
                                    Pizza.Size    size    = null;
                                    int           pQuantity;
                                    // Map to array instead?
                                    // TODO: 10/3/2016 Make this prettier
                                    switch (getStrInput(Pizza.getSizeSelectionMenu(), "1", "2", "3")) {
                                        case "1":
                                            size = Pizza.Size.SMALL;
                                            break;
                                        case "2":
                                            size = Pizza.Size.MEDIUM;
                                            break;
                                        case "3":
                                            size = Pizza.Size.LARGE;
                                            break;
                                    }
                                    switch (getStrInput(Pizza.getToppingSelectionMenu(), "1", "2", "3")) {
                                        case "1":
                                            topping = Pizza.Topping.VEGETARIAN;
                                            break;
                                        case "2":
                                            topping = Pizza.Topping.CHEESE;
                                            break;
                                        case "3":
                                            topping = Pizza.Topping.PEPPERONI;
                                            break;
                                    }

                                    pQuantity = getIntInput(Item.getQuantityMenu());

                                    assert topping != null;
                                    assert size != null;
                                    assert pQuantity != 0;

                                    order.addItem(new Pizza(topping, size, pQuantity));
                                    order.printInvoice();
                                } while (getYesNo("Order another pizza? (Y/N)"));
                                break;
                            case "2":
                                do {
                                    Appetizer.AppetizerType type = null;
                                    int                     aQuantity;

                                    switch (getStrInput(Appetizer.getSelectionMenu(), "1", "2")) {
                                        case "1":
                                            type = Appetizer.AppetizerType.SOUP;
                                            break;
                                        case "2":
                                            type = Appetizer.AppetizerType.SALAD;
                                            break;
                                    }

                                    aQuantity = getIntInput(Item.getQuantityMenu());

                                    assert type != null;
                                    assert aQuantity != 0;
                                    order.addItem(new Appetizer(type, aQuantity));
                                    order.printInvoice();
                                } while (getYesNo("Order another appetizer? (Y/N)"));
                                break;
                            case "3":
                                do {
                                    int dQuantity = getIntInput(Item.getQuantityMenu());

                                    assert dQuantity != 0;
                                    order.addItem(new Drink(dQuantity));
                                    order.printInvoice();
                                } while (getYesNo("Order another drink? (Y/N)"));
                                break;
                            default:
                                cont = false;
                                break;
                        }
                    }
                    order.printInvoice();
                    orders.add(order);

                } while (getStrInput("Order finished. Enter N for new customer or E to exit.", "n", "e").equals("n"));
                break;
            } catch (Exception | Error e) {
                if (getYesNo("Something went wrong. Exit? (Y/N)"))
                    break;
            }
        }

        printSummary();

    }

    private static void printSummary() {

        final String ORDER_TITLE  = "Order %d\n";
        final String ORDER_HEADER = "%1$-25s%2$-10s$%3$4s\n";
        final String ORDER_ITEM   = "%1$-25s%2$-10s$%3$4.2f\n";

        System.out.println("Session Summary");
        for (int i = 0; i < orders.size(); i++) {
            System.out.printf(ORDER_TITLE, i + 1);
//            System.out.printf(ORDER_HEADER, "Item", "Quantity", "Price");
//            for (Item item : orders.get(i).getItems()) {
//                System.out.printf(ORDER_ITEM, item.getName(), item.getQuantity(), item.getPrice());
//            }
            orders.get(i).printInvoice();
        }
    }

    private static boolean getYesNo(String query) {
        return getStrInput(query, "y", "n").equals("y");
    }

    private static String getStrInput(String inputQuery, String... validInputs) {
        String input;
        while (true) {
            System.out.println(inputQuery);

            input = scanner.next().toLowerCase();

            for (String valid : validInputs) {
                if (valid.toLowerCase().equals(input))
                    return input;
            }

            System.out.println("Invalid input.");
        }
    }

    private static int getIntInput(String inputQuery) {
        int input;

        while (true) {
            System.out.println(inputQuery);

            try {
                // For some reason nextInt gave a weird infinite loop type situation.
                input = Integer.valueOf(scanner.next());
                if (input <= 0 || input > 100)
                    // Would make own exception class if I could be bothered to do so.
                    throw new NumberFormatException();
                else
                    return input;
            } catch (InputMismatchException | NumberFormatException e) {
//                System.out.println("Invalid input.");
                System.out.println("Input must be an integer between 1 and 100 (inclusive).");
            }
        }
    }

}
