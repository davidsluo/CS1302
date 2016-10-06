/**
 * @author David Luo
 *         Represents an Item you can order.
 */
interface Item {

    String MENU_PATTERN = "%1s%2s$%3$.2f\n";

    /**
     * @return Quantity of Item ordered.
     */
    int getQuantity();

    /**
     * @param quantity Quantity of Item to order.
     */
    void setQuantity(int quantity);

    /**
     * @param quantity Quantity of Item(s) to be added.
     */
    void addQuantity(int quantity);

    /**
     * @return Price of Quantity count of Items
     */
    double calcTotal();

    /**
     * @return The formalized name of the <code>Item</code>.
     */
    String getName();

    /**
     * @return The cost of one unit of the <code>Item</code>.
     */
    double getPrice();

    /**
     * Helper method to print available choices.
     *
     * @param item  The name of the item on the menu.
     * @param price Corresponding price to the item.
     */
    static String getMenuLine(String item, double price) {
        StringBuilder filler = new StringBuilder();

        // Magic Number™
        int fillerAmount = 36 - String.format(MENU_PATTERN, item, "", price).length();

        for (int i = 0; i < fillerAmount; i++) {
            filler.append(".");
        }

        return String.format(MENU_PATTERN, item, filler.toString(), price);
    }


}
