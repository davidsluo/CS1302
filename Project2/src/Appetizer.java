/**
 * Represents an Appetizer item.
 */
public class Appetizer implements Item {

    public static final double SALAD_PRICE = 4.5;
    public static final double SOUP_PRICE = 5.0;

    public enum AppetizerType {
        SOUP("Soup"),
        SALAD("Salad");

        private String formattedName;

        AppetizerType(String formattedName) {
            this.formattedName = formattedName;
        }

        public String toString() {
            return formattedName;
        }
    }

    private int quantity;
    private AppetizerType appetizerType;

    /**
     * Constructor
     *
     * @param appetizerType The type of appetizer ordered.
     * @param quantity      How many appetizers of this type were ordered.
     */
    public Appetizer(AppetizerType appetizerType, int quantity) {
        this.quantity = quantity;
        this.appetizerType = appetizerType;
    }

    /**
     * @return Quantity of appetizer(s) ordered.
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity Number of appetizer(s) to order.
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
     * @return Price of quantity of appetizer(s) ordered.
     */
    @Override
    public double calcTotal() {
        if (this.appetizerType.equals(AppetizerType.SOUP)) {
            return SOUP_PRICE * quantity;
        } else if (this.appetizerType.equals(AppetizerType.SALAD)) {
            return SALAD_PRICE * quantity;
        }

        // Returned if appetizerType is null for some reason.
        return 0;
    }

    /**
     * Prints the invoice line for this appetizer.
     */
    @Override
    public void printInvoiceLine() {
        Item.printInvoiceLine(this.appetizerType.toString(), quantity, getPrice());
    }

    @Override
    public String getName() {
        return appetizerType.equals(AppetizerType.SOUP) ? "Soup" : "Salad";
    }

    @Override
    public double getPrice() {
        return appetizerType.equals(AppetizerType.SOUP) ? SOUP_PRICE : SALAD_PRICE;
    }


    /**
     * @return What type of appetizer is in this order.
     */
    public AppetizerType getAppetizerType() {
        return appetizerType;
    }

    /**
     * @param appetizerType The type of appetizer to be ordered.
     */
    public void setAppetizerType(AppetizerType appetizerType) {
        this.appetizerType = appetizerType;
    }

    public static String getSelectionMenu() {
        return "Select an appetizer (1-2).\n" +
                "1) Soup\n" +
                "2) Salad";
    }

    /**
     * Lists available appetizers.
     */
    public static String getMenu() {
        return "Appetizers\n" +
                Item.getMenu("Soup", SOUP_PRICE) +
                Item.getMenu("Salad", SALAD_PRICE);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Appetizer &&
                ((Appetizer) obj).getAppetizerType().equals(getAppetizerType());
    }
}
