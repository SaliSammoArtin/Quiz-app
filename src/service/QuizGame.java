package service;// src/service.QuizGame.java

import interfaces.IQuestion;
import interfaces.IQuiz;
import repository.FileScoreRepository;

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

        for (int i = 0; i < questions.size(); i++) {
            IQuestion q = questions.get(i);

            System.out.println("model.Question " + (i + 1) + " of " + questions.size());
            System.out.println("--------------------");

            q.showQuestion();
            System.out.print("Your answer: ");
            String userAnswer = input.nextLine();

            try {
                int parsed = Integer.parseInt(userAnswer.trim());
                if (q.checkAnswer(parsed)) {
                    System.out.println("✔ Correct!\n");
                    score++;
                    System.out.println("Your score is " + score);
                } else {
                    System.out.println("✘ Wrong! The correct answer is: " + q.getCorrectAnswer() + "\n");
                    System.out.println("Your score is " + score);
                }
            } catch (NumberFormatException e) {
                System.out.println("✘ Invalid input. The correct answer is: " + q.getCorrectAnswer() + "\n");
                System.out.println("Your score is " + score);
            }
        }

        showResult(score);
        saveScore(score);
    }

    private void showResult(int score) {
        System.out.println("Quiz done!");
        System.out.println("You got " + score + " out of " + questions.size() + " correct!");
    }

    private void saveScore(int score) {
        System.out.println("Would you like to save your score in the scoreboard?");
        System.out.println("1. yes");
        System.out.println("2. no");
        Scanner input = new Scanner(System.in);
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



