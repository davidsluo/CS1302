/**
 * @author David Luo
 *         Represents a Drink.
 */
public final class Drink implements Item {

    private static final double DRINK_PRICE = 2.0;

    private int quantity;

    /**
     * Constructor
     *
     * @param quantity Number of drinks in this order.
     */
    public Drink(int quantity) {
        // will complain if this is true.
        assert quantity <= 0;
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

    /**
     * @param quantity Quantity of drink(s) to be added.
     */
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
     * @return "Drink"
     */
    @Override
    public String getName() {
        return "Drink";
    }

    /**
     * @return The price of 1 drink.
     */
    @Override
    public double getPrice() {
        return DRINK_PRICE;
    }

    /**
     * Prints the list of available drink(s) and their prices.
     */
    public static String getMenu() {
        return "Drinks\n" +
                Item.getMenuLine("Drink", DRINK_PRICE);
    }

    /**
     * Mainly assists in the consolidation of duplicate items in an order.
     *
     * @param obj the object to check for equality
     * @return if the two objects are both Drinks
     */
    public boolean equals(Object obj) {
        return obj instanceof Drink;
    }
}
