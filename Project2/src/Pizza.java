/**
 * Created by David on 9/27/2016.
 */
class Pizza extends CustomerOrder {

    private PizzaType type;
    private SizeType size;
    private int quantity = 0;

    private enum PizzaType {
        VEGETARIAN("Vegetarian"),
        CHEESE("Cheese"),
        PEPPERONI("Pepperoni");

        private final String formattedName;

        PizzaType(String formattedName) {
            this.formattedName = formattedName;
        }

        public String getFormattedName() {
            return formattedName;
        }

        @Override
        public String toString() {
            return getFormattedName();
        }
    }

    private enum SizeType {
        SMALL,
        MEDIUM,
        LARGE
    }

    Pizza() {
        printHeading();

        switch (askForValidStringInput(getSizeMenu(), new String[]{"1", "2", "3"})) {
            case "1":
                type = PizzaType.VEGETARIAN;
            case "2":
                type = PizzaType.CHEESE;
            case "3":
                type = PizzaType.PEPPERONI;
        }

        switch (askForValidStringInput(getTypeMenu(), new String[]{"1", "2", "3"})) {
            case "1":
                size = SizeType.SMALL;
                break;
            case "2":
                size = SizeType.MEDIUM;
                break;
            case "3":
                size = SizeType.LARGE;
                break;
        }

        quantity = askForValidIntegerInput(getQuantityMenu());

    }

    @Override
    public double calculateTotal() {

        double total = 0;

        if (type == null || size == null)
            return 0;
        else {
            if (type.equals(PizzaType.VEGETARIAN) && size.equals(SizeType.SMALL))
                total += PizzaStore.S_VEGETARIAN_PRICE;
            else if (type.equals(PizzaType.VEGETARIAN) && size.equals(SizeType.MEDIUM)) {
                total += PizzaStore.M_VEGETARIAN_PRICE;
            } else if (type.equals(PizzaType.VEGETARIAN) && size.equals(SizeType.LARGE)) {
                total += PizzaStore.L_VEGETARIAN_PRICE;
            } else if (type.equals(PizzaType.CHEESE) && size.equals(SizeType.SMALL)) {
                total += PizzaStore.S_CHEESE_PRICE;
            } else if (type.equals(PizzaType.CHEESE) && size.equals(SizeType.MEDIUM)) {
                total += PizzaStore.M_CHEESE_PRICE;
            } else if (type.equals(PizzaType.CHEESE) && size.equals(SizeType.LARGE)) {
                total += PizzaStore.L_CHEESE_PRICE;
            } else if (type.equals(PizzaType.PEPPERONI) && size.equals(SizeType.SMALL)) {
                total += PizzaStore.S_PEPPERONI_PRICE;
            } else if (type.equals(PizzaType.PEPPERONI) && size.equals(SizeType.MEDIUM)) {
                total += PizzaStore.M_PEPPERONI_PRICE;
            } else if (type.equals(PizzaType.PEPPERONI) && size.equals(SizeType.LARGE)) {
                total += PizzaStore.L_PEPPERONI_PRICE;
            }
        }

        return total * quantity;
    }

    private String getTypeMenu() {
        return "Enter Pizza choice (1-3).\n" +
                "1) Vegetarian\n" +
                "2) Cheese\n" +
                "3) Pepperoni\n";
    }

    private String getSizeMenu() {
        return "Enter Size choice (1-3).\n" +
                "1) Small\n" +
                "2) Medium\n" +
                "3) Large\n";
    }

    private String getQuantityMenu() {
        return "Enter quantity.";
    }

    @Override
    public void printHeading() {
        System.out.println("Pizza Menu");
    }
}
