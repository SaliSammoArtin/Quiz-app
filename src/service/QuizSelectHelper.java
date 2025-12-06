package service;

import java.util.Scanner;

public class QuizSelectHelper {
    public static QuizGame chooseQuiz() {

        //Choose the available quiz menu
        System.out.println("\nChoose a quiz:");
        System.out.println("1. Animals Quiz");
        System.out.println("2. Sweden cities generic quiz");
        System.out.print("Enter the number of your choice: ");

        while (true) {
            //Get input
            Scanner input = service.ScannerHelper.getScanner();
            String userInput = input.nextLine();
            int choice;
            try {
                // Try converting to int
                choice = Integer.parseInt(userInput.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue; // ask again if failed
            }

            switch (choice) {

                case 1: //Animal quiz
                    return new QuizGame(QuizManager.createAnimalQuiz());
                case 2: //Swedish places
                    return new QuizGame(QuizManager.createSwedishPlacesQuiz());
                default: //Invalid choice
                    System.out.println("Invalid selection. Try again.");

            }
        }
    }
}
