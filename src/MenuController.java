import java.util.Scanner;

public class MenuController {
    private final Scanner scanner;
    private boolean running;

    public MenuController() {
        this.scanner = new Scanner(System.in);
        this.running = true;
    }

    public void run() {
        System.out.println("\n╔═══════════════════════════════╗");
        System.out.println("║  WELCOME TO THE QUIZ GAME!    ║");
        System.out.println("╚═══════════════════════════════╝\n");

        while (running) {
            MainMenu.printMainMenu();
            handleChoice();
        }
        System.out.println("Thanks for playing!");
        scanner.close();
    }

    public void handleChoice() {
        System.out.println("Your choice: ");
        String input = scanner.nextLine();

        try {
            int choice = Integer.parseInt(input.trim());

            switch (choice) {
                case 1:
                    IQuiz quiz = QuizSelectHelper.chooseQuiz();
                    quiz.start();
                    break;
                case 2:
                    System.out.println("This option has not been implemented yet");
                    break;
                case 3:
                    System.out.println("This option isn't working atm");
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Please enter a valid number!");
        }
    }
}

