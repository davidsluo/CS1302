/**
 * Represents a Drink.
 */
public class Drink implements Item {

    public static final double DRINK_PRICE = 2.0;

    private int quantity;

    /**
     * Constructor
     *
     * @param quantity Number of drinks in this order.
     */
    public Drink(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return Quantity of drink(s) ordered.
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity Number of drink(s) to order.
     */
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    /**
     * @return Price of quantity of drink(s) ordered.
     */
    @Override
    public double calcTotal() {
        return DRINK_PRICE * quantity;
    }

    /**
     * Prints receipt line for this drink.
     */
    @Override
    public void printInvoiceLine() {
        Item.printInvoiceLine("Drink", quantity, getPrice());
    }

    @Override
    public String getName() {
        return "Drink";
    }

    @Override
    public double getPrice() {
        return DRINK_PRICE;
    }

    /**
     * Prints the drink selection menu.
     */
    public static String getSelectionMenu() {
        return "Select a drink (1-2).\n" +
                "1) Add drink" +
                "2) No drink";
    }

    /**
     * Prints the list of available drink(s) and their prices.
     */
    public static String getMenu() {
        return "Drinks\n" +
                Item.getMenu("Drink", DRINK_PRICE);
    }

    /**
     * Returns true if it has the same (non-existent) properties.
     *
     * @param obj the object to check for equality
     * @return if the two objects are both Drinks
     */
    public boolean equals(Object obj) {
        return obj instanceof Drink;
    }
}
