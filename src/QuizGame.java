// src/QuizGame.java
import java.util.ArrayList;
import java.util.Scanner;

public class QuizGame implements IQuiz {
    private final ArrayList<IQuestion> questions;

    public QuizGame(ArrayList<IQuestion> questions) {
        this.questions = questions;
    }

    @Override
    public void start() {
        Scanner input = new Scanner(System.in);
        int score = 0;

        System.out.println("\n--- Quiz begins! ---\n");

        for (IQuestion q : questions) {
            q.showQuestion();
            System.out.print("Your answer: ");
            String userAnswer = input.nextLine();

            try {
                int parsed = Integer.parseInt(userAnswer.trim());
                if (q.checkAnswer(parsed)) {
                    System.out.println("✔ Correct!\n");
                    score++;
                } else {
                    System.out.println("✘ Wrong! The correct answer is: " + q.getCorrectAnswer() + "\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("✘ Invalid input. The correct answer is: " + q.getCorrectAnswer() + "\n");
            }
        }

        showResult(score);
    }

    private void showResult(int score) {
        System.out.println("Quiz done!");
        System.out.println("You got " + score + " out of " + questions.size() + " correct!");
    }
}
