/**
 * @author David Luo
 *         Represents an Appetizer item.
 */
public final class Appetizer implements Item {

    private static final double SALAD_PRICE = 4.5;
    private static final double SOUP_PRICE = 5.0;

    public static final String APPETIZER_SELECTION_PROMPT =
            "Select an appetizer (1-2).\n" +
                    "1) Soup\n" +
                    "2) Salad";

    enum AppetizerType {
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
        // will complain if these is true.
        assert appetizerType != null;
        assert quantity <= 0;

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

    /**
     * @param quantity Quantity of Appetizers(s) to be added.
     */
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
     * @return The formalized name of the Appetizer (i.e. Soup or Salad)
     */
    @Override
    public String getName() {
        return appetizerType.equals(AppetizerType.SOUP) ? "Soup" : "Salad";
    }

    /**
     * @return The cost of 1 unit of soup/salad
     */
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

    /**
     * Lists available appetizers.
     */
    static String getMenu() {
        return "Appetizers\n" +
                Item.getMenuLine("Soup", SOUP_PRICE) +
                Item.getMenuLine("Salad", SALAD_PRICE);
    }

    /**
     * Mainly assists in the consolidation of duplicate items in an order.
     *
     * @param obj object to be compared.
     * @return If the objects have the same properties (i.e. same type of appetizer.)
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Appetizer &&
                ((Appetizer) obj).getAppetizerType().equals(getAppetizerType());
    }
}
