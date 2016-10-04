/**
 * Wrapper interface for order items.
 */
interface Item {

    String MENU_PATTERN = "%1s%2s$%3$.2f\n";
    String INVOICE_PATTERN = "%1$-22s %2$9d $%3$7.2f\n";
    String INVOICE_HEADER_PATTERN = "%1$-28s %2$3s %3$8s\n";
    String INVOICE_SEPARATOR = "-----------------------------------------";

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
    static void printInvoiceLine(String item, int quantity, double totalPrice) {
        System.out.printf(INVOICE_PATTERN, item, quantity, totalPrice);
    }

    static void printInvoiceHeader() {
        System.out.printf(INVOICE_HEADER_PATTERN, "Item", "Qty", "Price");
    }

    static void printInvoiceSeparator() {
        System.out.println(INVOICE_SEPARATOR);
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
