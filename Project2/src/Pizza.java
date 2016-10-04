/**
 * Represents a Pizza.
 */
public class Pizza implements Item {

    public static final double S_VEGETARIAN_PRICE = 6.5;
    public static final double M_VEGETARIAN_PRICE = 10.5;
    public static final double L_VEGETARIAN_PRICE = 13.5;

    public static final double S_CHEESE_PRICE = 5.5;
    public static final double M_CHEESE_PRICE = 8.0;
    public static final double L_CHEESE_PRICE = 10.0;

    public static final double S_PEPPERONI_PRICE = 6.0;
    public static final double M_PEPPERONI_PRICE = 8.5;
    public static final double L_PEPPERONI_PRICE = 12.0;


    public enum Topping {
        VEGETARIAN("Vegetarian"),
        CHEESE("Cheese"),
        PEPPERONI("Pepperoni");

        private String formattedName;

        Topping(String formattedName) {
            this.formattedName = formattedName;
        }

        @Override
        public String toString() {
            return formattedName;
        }
    }

    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }

    // Should these be mutable or immutable?
    // i.e. to edit an order should I make a new Pizza object, or edit an existing one?
    private Topping topping;
    private Size size;
    private int quantity;

    /**
     * Constructor
     *
     * @param topping  The topping on the pizza(s)
     * @param size     Size of pizza(s)
     * @param quantity Number of pizza(s)
     */
    public Pizza(Topping topping, Size size, int quantity) {
        this.topping = topping;
        this.size = size;
        this.quantity = quantity;
    }

    /**
     * @return Topping on the pizza(s)
     */
    public Topping getTopping() {
        return topping;
    }


    /**
     * @return Size of the pizza(s)
     */
    public Size getSize() {
        return size;
    }

    /**
     * @return Quantity of pizza(s) ordered.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity Number of pizza(s) to order.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    /**
     * @return Price of quantity of pizza(s) ordered.
     */
    public double calcTotal() {
        double total = 0;

        if (topping == null || size == null)
            return -1;
        else {
            if (topping.equals(Topping.VEGETARIAN) && size.equals(Size.SMALL))
                total += S_VEGETARIAN_PRICE;
            else if (topping.equals(Topping.VEGETARIAN) && size.equals(Size.MEDIUM))
                total += M_VEGETARIAN_PRICE;
            else if (topping.equals(Topping.VEGETARIAN) && size.equals(Size.LARGE))
                total += L_VEGETARIAN_PRICE;
            else if (topping.equals(Topping.CHEESE) && size.equals(Size.SMALL))
                total += S_CHEESE_PRICE;
            else if (topping.equals(Topping.CHEESE) && size.equals(Size.MEDIUM))
                total += M_CHEESE_PRICE;
            else if (topping.equals(Topping.CHEESE) && size.equals(Size.LARGE))
                total += L_CHEESE_PRICE;
            else if (topping.equals(Topping.PEPPERONI) && size.equals(Size.SMALL))
                total += S_PEPPERONI_PRICE;
            else if (topping.equals(Topping.PEPPERONI) && size.equals(Size.MEDIUM))
                total += M_PEPPERONI_PRICE;
            else if (topping.equals(Topping.PEPPERONI) && size.equals(Size.LARGE))
                total += L_PEPPERONI_PRICE;
        }

        return total * quantity;
    }

    /**
     * Prints line of receipt for this item.
     */
    @Override
    public void printInvoiceLine() {
        Item.printInvoiceLine(getName(), quantity, getPrice());
    }

    @Override
    public String getName() {
        String name = "";
        switch (topping) {
            case CHEESE:
                name += "Cheese ";
                break;
            case PEPPERONI:
                name += "Pepperoni ";
                break;
            case VEGETARIAN:
                name += "Vegetarian ";
                break;
        }

        switch (size) {
            case SMALL:
                name += "Small ";
                break;
            case MEDIUM:
                name += "Medium ";
                break;
            case LARGE:
                name += "Large ";
                break;
        }

        name += "Pizza";

        return name;
    }

    @Override
    public double getPrice() {

        if (topping == null || size == null)
            return 0;

        if (topping.equals(Topping.VEGETARIAN) && size.equals(Size.SMALL))
            return S_VEGETARIAN_PRICE;
        else if (topping.equals(Topping.VEGETARIAN) && size.equals(Size.MEDIUM))
            return M_VEGETARIAN_PRICE;
        else if (topping.equals(Topping.VEGETARIAN) && size.equals(Size.LARGE))
            return L_VEGETARIAN_PRICE;
        else if (topping.equals(Topping.CHEESE) && size.equals(Size.SMALL))
            return S_CHEESE_PRICE;
        else if (topping.equals(Topping.CHEESE) && size.equals(Size.MEDIUM))
            return M_CHEESE_PRICE;
        else if (topping.equals(Topping.CHEESE) && size.equals(Size.LARGE))
            return L_CHEESE_PRICE;
        else if (topping.equals(Topping.PEPPERONI) && size.equals(Size.SMALL))
            return S_PEPPERONI_PRICE;
        else if (topping.equals(Topping.PEPPERONI) && size.equals(Size.MEDIUM))
            return M_PEPPERONI_PRICE;
        else if (topping.equals(Topping.PEPPERONI) && size.equals(Size.LARGE))
            return L_PEPPERONI_PRICE;

        return 0;
    }

    /**
     * Prints all topping/size combos and their respective prices
     */
    public static String getMenu() {
        final String PIZZA_PATTERN = "%1$-12s $%2$-5.2f $%3$-5.2f $%4$-5.2f\n";

        return "Pizza\n" +
                String.format("%1$-12s %2$-6s %3$-6s %4$-6s\n",
                        "",
                        "Small",
                        "Medium",
                        "Large") +
                String.format(PIZZA_PATTERN,
                        "Vegetarian",
                        S_VEGETARIAN_PRICE,
                        M_VEGETARIAN_PRICE,
                        L_VEGETARIAN_PRICE) +
                String.format(PIZZA_PATTERN,
                        "Cheese",
                        S_CHEESE_PRICE,
                        M_CHEESE_PRICE,
                        L_CHEESE_PRICE) +
                String.format(PIZZA_PATTERN,
                        "Pepperoni",
                        S_PEPPERONI_PRICE,
                        M_PEPPERONI_PRICE,
                        L_PEPPERONI_PRICE);
    }

    public static String getToppingSelectionMenu() {
        return "Select a topping (1-3).\n" +
                "1) Vegetarian\n" +
                "2) Cheese\n" +
                "3) Pepperoni";
    }

    public static String getSizeSelectionMenu() {
        return "Select a size (1-3).\n" +
                "1) Small\n" +
                "2) Medium\n" +
                "3) Large";
    }

    /**
     * Equal = if they're both the same type of pizza (same size, same topping)
     *
     * @param obj The object to be compared.
     * @return If the two Pizzas have the same toppings/pizza.
     */
    public boolean equals(Object obj) {
        return obj instanceof Pizza &&
                ((Pizza) obj).getSize().equals(getSize()) &&
                ((Pizza) obj).getTopping().equals(getTopping());
    }

}
