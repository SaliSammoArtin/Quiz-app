import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose a quiz:");
        System.out.println("1. Animals Quiz");
        System.out.println("2. Sweden cities generic quiz");
        System.out.print("Write the number of your choice: ");

        int choice = input.nextInt();
        input.nextLine();

        /* Tis declares that QuizGame exists, but the value is assign according to
        ... what the user chooses */

        QuizGame quiz = null;

        switch (choice) {
            case 1:
                quiz = new QuizGame(QuizManager.createAnimalQuiz());
                break;
            case 2:
                quiz = new QuizGame(QuizManager.createGeneralQuiz());
                break;
            default:
                System.out.println("Wrong choice!");
                return;
        }

        quiz.startaQuiz();
    }
}