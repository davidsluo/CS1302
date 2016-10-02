import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by David on 10/1/2016.
 */
public class PizzaTest {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = "y";

        while (input.equals("y")) {
            // if for whatever reason this throws an error...
            try {
                run();
                break;
            } catch (Exception e) {
                input = Order.askForValidStringInput("An error has occurred. Restart? (Y/N)", new String[]{"y", "n"});
            }
        }

        System.out.println("Exiting.");
    }

    private static void run() {
        List<CustomerOrder> orders = new ArrayList<>();

        String input;

        do {
            CustomerOrder order = new CustomerOrder();
            orders.add(order);

            // Input validation
            input = Order.askForValidStringInput(
                    "Order finished.\nEnter N for new customer order or E to exit.",
                    new String[]{"n", "e"}
            );

        } while (input.toLowerCase().equals("n"));

        int numPizzaOrders = 0;
        int numAppetizerOrders = 0;
        int numDrinkOrders = 0;

        for (CustomerOrder order : orders) {
            List<CustomerOrder> orderContents = order.getItems();

            for (CustomerOrder item : orderContents) {
                if (item instanceof Pizza)
                    numPizzaOrders++;
                else if (item instanceof Appetizer)
                    numAppetizerOrders++;
                else if (item instanceof Drink)
                    numDrinkOrders++;
            }
        }

        final String SUMMARY_PATTERN = "%-25s%5s\n";

        System.out.println("Sales Session Summary\n");
        System.out.printf(SUMMARY_PATTERN, "Total number of orders:", orders.size());
        System.out.printf(SUMMARY_PATTERN, "Total number of pizzas sold:", numPizzaOrders);
        System.out.printf(SUMMARY_PATTERN, "Total number of appetizers sold:", numAppetizerOrders);
        System.out.printf(SUMMARY_PATTERN, "Total number of drinks sold:", numDrinkOrders);
    }
}
