import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 9/27/2016.
 */
class CustomerOrder extends Order {

    private List<CustomerOrder> items = new ArrayList<>();


    CustomerOrder() {
        printHeading();

        String input;

        do {
            displayMenu();
            input = scanner.next();

            switch (input) {
                case "1":
                    items.add(new Pizza());
                    break;
                case "2":
                    items.add(new Appetizer());
                    break;
                case "3":
                    items.add(new Drink());
                    break;
                default:
                    // Do nothing and exit order.
            }

            // Input validation
            do {
                System.out.println("Order more? (Y/N)");
                input = scanner.next();
                if (!input.toLowerCase().equals("y") && !input.toLowerCase().equals("n"))
                    System.out.println("Invalid input.");
                else
                    break;
            } while (true);

        } while (input.toLowerCase().equals("y"));

        printInvoice();
    }

    List<CustomerOrder> getItems() {
        return items;
    }

    @Override
    public double calculateTotal() {
        double total = 0;

        for (CustomerOrder item : items) {
            total += item.calculateTotal();
        }

        return total * (1 + PizzaStore.TAX);
    }

    @Override
    public void printHeading() {
        final String PIZZA_PATTERN = "%1$-12s $%2$-5.2f $%3$-5.2f $%4$-5.2f\n";
        final String APPETIZER_PATTERN = "%1$-12s %2$-14s $%3$.2f\n";

        System.out.println("Welcome to the Pizza Store.");

        System.out.println("Pizza");
        System.out.printf("%1$-12s %2$-6s %3$-6s %4$-6s\n",
                "",
                "Small",
                "Medium",
                "Large");
        System.out.printf(PIZZA_PATTERN,
                "Vegetarian",
                S_VEGETARIAN_PRICE,
                M_VEGETARIAN_PRICE,
                L_VEGETARIAN_PRICE);
        System.out.printf(PIZZA_PATTERN,
                "Cheese",
                S_CHEESE_PRICE,
                M_CHEESE_PRICE,
                L_CHEESE_PRICE);
        System.out.printf(PIZZA_PATTERN,
                "Pepperoni",
                S_PEPPERONI_PRICE,
                M_PEPPERONI_PRICE,
                L_PEPPERONI_PRICE);
        System.out.println();

        System.out.println("Appetizers");
        System.out.printf(APPETIZER_PATTERN, "Salad", "", DRINK_PRICE);
        System.out.printf(APPETIZER_PATTERN, "Soup", "", SALAD_PRICE);
        System.out.printf(APPETIZER_PATTERN, "Soft Drinks", "", SOUP_PRICE);
        System.out.println("\nStart Order...");
    }

    @Override
    public void printInvoice() {

    }

    @Override
    public void displayMenu() {
        System.out.println(
                "Enter Choice (1-3) or hit any key to exit this menu.\n" +
                        "1) PIZZA\n" +
                        "2) APPETIZERS\n" +
                        "3) DRINKS\n"
        );
    }
}
