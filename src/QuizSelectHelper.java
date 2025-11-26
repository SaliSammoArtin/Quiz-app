import java.util.Scanner;

public class QuizSelectHelper {
    public static QuizGame chooseQuiz() {

        /* Right now we need to manually write a title of every new quiz in this menu.
        But I think there is a solution to it:
        This menu can be made better if we Implement Iquiz for Quizes we have, not for the
        QuizGame, and make a getter method for the titles of the quizes. Then program can
         Automatically get titles of quizes and we will not have to get it manually */
        System.out.println("\nChoose a quiz:");
        System.out.println("1. Animals Quiz");
        System.out.println("2. Sweden cities generic quiz");
        System.out.print("Write the number of your choice: ");

        while (true) {
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(userInput.trim()); // try converting to int
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

            }
        }
    }
}
