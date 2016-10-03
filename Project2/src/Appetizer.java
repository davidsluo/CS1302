/**
 * Created by David on 10/1/2016.
 */
final class Appetizer extends CustomerOrder {
    enum ApptType {
        SOUP,
        SALAD
    }

    @Override
    public void displayMenu() {
        System.out.println(
                "Enter Appetizer choice(1-2) or hit any key to exit this menu.\n" +
                        "1) Salad\n" +
                        "2) Soup\n"
        );
    }
}
