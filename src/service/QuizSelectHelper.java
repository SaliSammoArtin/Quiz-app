package service;

import java.util.Scanner;

public class QuizSelectHelper {
    public static QuizGame chooseQuiz() {

        System.out.println("\nChoose a quiz:");
        System.out.println("1. Animals Quiz");
        System.out.println("2. Sweden cities generic quiz");
        System.out.print("Write the number of your choice: ");

        while (true) {
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            int choice = -1;
            try {
                choice = Integer.parseInt(userInput); // try converting to int
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue; // ask again if failed
            }

            switch (choice) {
                case 1:
                    return new QuizGame(QuizManager.createAnimalQuiz());
                case 2:
                    return new QuizGame(QuizManager.createGeneralQuiz());
                default:
                    System.out.println("Invalid selection. Try again.");
                    return chooseQuiz();
            }
        }
    }
}
