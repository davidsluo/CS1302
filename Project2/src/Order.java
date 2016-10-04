import java.util.ArrayList;
import java.util.List;

/**
 * Represents an order. Can have multiple Drinks, Pizzas, Appetizers, etc.
 */
public class Order {

    public static double TAX = 0.07;

    private List<Item> items = new ArrayList<>();

    public void consolidateDuplicates() {

        List<Item> uniqueItems = new ArrayList<>();

        for (Item item : items) {

            if (!uniqueItems.contains(item)) {
                uniqueItems.add(item);
            } else {
                for (Item uItem : uniqueItems) {
                    if (item.equals(uItem)) {
                        uItem.addQuantity(item.getQuantity());
                    }
                }
            }
        }

        this.items = uniqueItems;
    }

    public double calcTotal() {
        double total = 0;
        for (Item item: items) {
            total += item.calcTotal();
        }

        return total;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    static void printMenu() {
        System.out.println(Pizza.getMenu());
        System.out.println(Appetizer.getMenu());
        System.out.println(Drink.getMenu());
    }

    static String getOptionsMenu() {
        return "Enter (1-3) to select an option or any other key to finish ordering.\n" +
                "1) Order a pizza.\n" +
                "2) Order an appetizer.\n" +
                "3) Order a drink.";
    }

    public void printInvoice() {
        // TODO: 10/4/2016 This
        consolidateDuplicates();
        System.out.println("\nInvoice");
        Item.printInvoiceSeparator();
        Item.printInvoiceHeader();
        for (Item item : items) {
            item.printInvoiceLine();
        }
        Item.printInvoiceSeparator();
        System.out.printf("%1$-32s $%2$7.2f\n", "Total", calcTotal());
        System.out.println();
    }
}
