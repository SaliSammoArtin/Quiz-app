import java.util.Scanner;

public class QuizSelectHelper {
    public static QuizGame createQuiz() {
        while (true) {
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            int choice = -1;// read as string
            try {
                choice = Integer.parseInt(userInput); // try converting to int
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue; // ask again
            }

            switch (choice) {
                case 1:
                    return new QuizGame(QuizManager.createAnimalQuiz());
                case 2:
                    return new QuizGame(QuizManager.createGeneralQuiz());
                default:
                    System.out.println("Invalid selection. Try again.");
                    return createQuiz();
            }
        }
    }
}
