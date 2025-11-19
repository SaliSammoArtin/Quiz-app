import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Desirée gör menyn till Enum
        System.out.println("Choose a quiz:");
        System.out.println("1. Animals Quiz");
        System.out.println("2. Sweden cities generic quiz");
        System.out.print("Write the number of your choice: ");

        int choice = input.nextInt();
        input.nextLine();

        /* This declares that QuizGame exists, but the value is assign according to
        ... what the user chooses */

        IQuiz quiz;

        if (choice == 1) {
            quiz = new QuizGame(QuizManager.createAnimalQuiz());
        } else if (choice == 2) {
            quiz = new QuizGame(QuizManager.createGeneralQuiz());
        } else {
            System.out.println("Invalid choice!");
            return;
        }

        quiz.start();
    }
}