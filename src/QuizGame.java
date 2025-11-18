import java.util.ArrayList;
import java.util.Scanner;

public class QuizGame {
    private ArrayList<Question> questions;

    public QuizGame(ArrayList<Question> questions) {
        this.questions = questions;
    }
// hämta svaren med index?
    public void startaQuiz() {
        Scanner input = new Scanner(System.in);
        int score = 0;

        System.out.println("\n--- Quiz begins! ---\n");

        for (Question q : questions) {
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
        System.out.println("You got " + score + " of " + questions.size() + " correct!");
    }
}
