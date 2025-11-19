
public enum MainMenu {
    OPTION_ONE(1,"Take a quiz"),
    OPTION_TWO(2,"Make a quiz"),
    OPTION_THREE(3, "Your score"),
    OPTION_FOUR(4,"Quit the game");

    private final int number;
    private final String description;

    MainMenu(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public void print() {
        System.out.println(number + ". " + description);
    }
    public static void printMenu() {
        System.out.println("~~~ QUIZ MENU ~~~");
        for (MainMenu menu : MainMenu.values()) {
            menu.print();
        }
    }
}