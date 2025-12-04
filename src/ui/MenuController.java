package ui;

import interfaces.IQuiz;
import repository.FileScoreRepository;
import service.QuizSelectHelper;
import model.scoreInstance;

import java.util.List;
import java.util.Scanner;

//This class prints out the Main menu and gathers user choices for it
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

    //Handle user´s choice
    public void handleChoice() {
        System.out.println("Your choice: ");
        String input = scanner.nextLine();
        FileScoreRepository repo = new FileScoreRepository();

        try {
            int choice = Integer.parseInt(input.trim());

            switch (choice) {
                case 1: //Take a quiz
                    IQuiz quiz = QuizSelectHelper.chooseQuiz();
                    quiz.start();
                    break;
                case 2: //Make a quiz (not ready yet, planned for the future)
                    System.out.println("This option has not been implemented yet");
                    break;
                case 3: // View Scoreboard
                    try {
                        List<scoreInstance> entries = repo.loadScore(); //This loads the scoreboard
                        repo.printScore(entries); // This prints the scoreboard
                    } catch (Exception e) {
                        System.out.println("Error loading scores: " + e.getMessage());
                    }
                    break;
                case 4://Exit
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

