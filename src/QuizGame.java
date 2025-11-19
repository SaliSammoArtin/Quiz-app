import java.util.ArrayList;
import java.util.Scanner;

public class QuizGame implements IQuiz {
    private ArrayList<IQuestion> questions;

    public QuizGame(ArrayList<IQuestion> questions) {
        this.questions = questions;
    }

    // hämta svaren med index?
    @Override
    public void start() {
        Scanner input = new Scanner(System.in);
        int score = 0;

        System.out.println("\n--- Quiz begins! ---\n");

        for (IQuestion q : questions) {
            q.showQuestion();
            System.out.print("Your answer: ");
            String userAnswer = input.nextLine();

            if (q.checkAnswer(userAnswer)) {
                System.out.println("✔ Correct!\n");
                score++;
            } else {
                System.out.println("✘ Wrong! The correct answer is: " + q.getCorrectAnswer() + "\n");
            }
        }

        showResult(score);
    }

    private void showResult(int score) {
        System.out.println("Quiz done!");
        System.out.println("You got " + score + " out of " + questions.size() + " correct!");
    }
}
