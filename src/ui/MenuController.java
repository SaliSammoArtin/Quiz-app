package ui;

import interfaces.IQuiz;
import repository.FileScoreRepository;
import service.QuizSelectHelper;
import model.scoreInstance;

import java.util.List;
import java.util.Scanner;

public class MenuController {
    private final Scanner scanner;
    private boolean running;

    public MenuController() {
        this.scanner = service.ScannerHelper.getScanner();
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
    }

    public void handleChoice() {
        System.out.println("Your choice: ");
        String input = scanner.nextLine();
        FileScoreRepository repo = new FileScoreRepository();

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
                    try {
                        List<scoreInstance> entries = repo.loadScore(); //This loads the scoreboard
                        repo.printScore(entries); // This prints the scoreboard
                    } catch (Exception e) {
                        System.out.println("Error loading scores: " + e.getMessage());
                    }
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

