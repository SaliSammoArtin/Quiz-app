package service;// src/service.QuizGame.java

import interfaces.IQuestion;
import interfaces.IQuiz;
import repository.FileScoreRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizGame implements IQuiz {
    private final ArrayList<IQuestion> questions;
    private final Scanner scanner;

    public QuizGame(ArrayList<IQuestion> questions) {
        this.questions = questions;
        this.scanner = service.ScannerHelper.getScanner();
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
                System.out.println("Your current score is " + score);
            } else {
                System.out.println("✘ Wrong! The correct answer is: " + q.getCorrectAnswer() + "\n");
                System.out.println("Your current score is " + score);
            }
        }

        showResult(score);
        saveScore(score);
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
                } else {
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

    private void saveScore(int score) {
        System.out.println("Would you like to save your score in the scoreboard?");
        System.out.println("1. yes");
        System.out.println("2. no");
        Scanner input = service.ScannerHelper.getScanner();
        String userChoice = input.nextLine();
        if (userChoice.equals("1")) {
            while (true) {
                System.out.println("Please write your nickname:");
                String inputNickname = input.nextLine();
                if ((inputNickname.isEmpty()) || !inputNickname.matches("[a-zA-Z0-9_-]+") || inputNickname.length() > 12) {
                    System.out.println("Invalid Nickname. You can only use letters, numbers, underscores, and dashes. The name can be max 12 symbols long.");
                    continue;
                }
                try {
                    FileScoreRepository repo = new FileScoreRepository();
                    repo.saveScore(score, inputNickname);
                } catch (Exception e) {
                    System.out.println("Error saving score: " + e.getMessage());
                }
                break;
            }
        } else if (userChoice.equals("2")) {
            System.out.println("Doing nothing");
        } else {
            System.out.println("Incorrect input");
        }
    }
}