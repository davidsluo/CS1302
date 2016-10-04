/**
 * Wrapper interface for order items.
 */
interface Item {

    String MENU_PATTERN = "%1s%2s$%3$.2f\n";
    String INVOICE_PATTERN = "%1$-20s $%2$4.2f\n";

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
    double calcPrice();

    /**
     * Helper method to print available choices.
     * @param item The name of the item on the menu.
     * @param price Corresponding price to the item.
     */
    static String getMenu(String item, double price) {
        StringBuilder filler = new StringBuilder();

        // Magic Number™
        int fillerAmount = 36 - String.format(MENU_PATTERN, item, "", price).length();

        for (int i = 0; i < fillerAmount; i++) {
            filler.append(".");
        }

        return String.format(MENU_PATTERN, item, filler.toString(), price);
    }

    /**
     * Utility method used to print the final receipt/invoice
     * @param item Name of item.
     * @param totalPrice Total price of items.
     */
    static void printInvoiceLine(String item, double totalPrice) {
        System.out.printf(INVOICE_PATTERN, item, totalPrice);
    }

    static String getQuantityMenu() {
        return "Enter Quantity";
    }

    /**
     * Prints the invoice.
     */
    void printInvoiceLine();

    String getName();
    double getPrice();


}
