package service;// src/service.QuizGame.java
import interfaces.IQuestion;
import interfaces.IQuiz;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizGame implements IQuiz {
    private final ArrayList<IQuestion> questions;
    private final Scanner scanner;

    public QuizGame(ArrayList<IQuestion> questions) {
        this.questions = questions;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void start() {

        int score = 0;

        System.out.println("\n--- Quiz begins! ---\n");

        for (int i = 0; i < questions.size(); i++) {
            IQuestion q = questions.get(i);

            System.out.println("Question " + (i + 1) + " of " + questions.size());
            System.out.println("--------------------");

            q.showQuestion();

            int userAnswer = getValidIntInput();

            if (userAnswer == -1) {
                System.out.println("\n Quiz cancelled! Returning to main menu.");
                return;
            }

            if (q.checkAnswer(userAnswer)) {
                System.out.println("✔ Correct!\n");
                score++;
            } else {
                System.out.println("✘ Wrong! The correct answer is: " + q.getCorrectAnswer() + "\n");
            }
        }

        showResult(score);
    }

    private int getValidIntInput() {
        while (true) {
            System.out.print("Your answer (1-4) or 'q' to quit: ");
            String input = scanner.nextLine();

            if (input.trim().equalsIgnoreCase("q")) {
                return -1;
            }
            try {
                int parsedInput = Integer.parseInt(input.trim());

                if (parsedInput >= 1 && parsedInput <= 4) {
                    return parsedInput;
                }
                else {
                    System.out.println("Invalid choice. Pick a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number (e.g., 1, 2, 3).");
            }
        }
    }

    private void showResult(int score) {
        System.out.println("Quiz done!");
        System.out.println("You got " + score + " out of " + questions.size() + " correct!");
    }
}