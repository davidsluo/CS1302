interface PizzaStore {
    // Why are we declaring class-specific variables here?
    double TAX = 0.07;

    double S_VEGETARIAN_PRICE = 6.5;
    double M_VEGETARIAN_PRICE = 10.5;
    double L_VEGETARIAN_PRICE = 13.5;

    double S_CHEESE_PRICE = 5.5;
    double M_CHEESE_PRICE = 8.0;
    double L_CHEESE_PRICE = 10.0;

    double S_PEPPERONI_PRICE = 6.0;
    double M_PEPPERONI_PRICE = 8.5;
    double L_PEPPERONI_PRICE = 12.0;

    double DRINK_PRICE = 2.0;
    double SALAD_PRICE = 4.5;
    double SOUP_PRICE = 5.0;

    // These were listed twice in the project sheet and the costs didn't make sense logically
    // I'm assuming these were supposed to be the large prices and added them in as such
    //    double S_CHEESE_PRICE     = 10.0;
    //    double S_PEPPERONI_PRICE = 12.0;

    double calculateTotal();

    void printHeading();

    void printInvoice();

    void displayMenu();

}
