
public enum MainMenu {
    OPTION_ONE(1, "Add transaction"),
    OPTION_TWO(2, "Show account balance"),
    OPTION_THREE(3, "Delete a transaction"),
    OPTION_FOUR(4, "Display expenses"),
    OPTION_FIVE(5, "Display income"),
    OPTION_SIX(6,"Exit");

    private final int number;
    private final String description;

    MainMenu (int number, String description){
        this.number = number;
        this.description = description;
    }

    public void print() {
        System.out.println(number + ". " + description);
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("--- MENU ---");
        for (MainMenu option : MainMenu.values()) {
            option.print();
        }
    }
}