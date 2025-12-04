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
        //initiate score
        int score = 0;
        //
        System.out.println("\n--- Quiz begins! ---\n");

        //Print out the array of questions
        for (int i = 0; i < questions.size(); i++) {
            IQuestion q = questions.get(i);

            System.out.println("Question " + (i + 1) + " of " + questions.size());
            System.out.println("--------------------");

            q.showQuestion();
            //get user input
            int userAnswer = getValidIntInput();

            //if exit is chosen
            if (userAnswer == -1) {
                System.out.println("\n Quiz cancelled! Returning to main menu.");
                return;
            }

            //if correct answer is chosen OR if incorrect answer is chosen
            if (q.checkAnswer(userAnswer)) {
                System.out.println("✔ Correct!\n");
                score++;
                System.out.println("Your current score is " + score);
            } else {
                System.out.println("✘ Wrong! The correct answer is: " + q.getCorrectAnswer() + "\n");
                System.out.println("Your current score is " + score);
            }
        }

        //Showing the score when the quiz ends
        showResult(score);
        //Saving the score to the scoreboard
        saveScore(score);
    }

    //Validator for the input
    private int getValidIntInput() {
        while (true) {
            System.out.print("Your answer (1-4) or 'q' to quit: ");
            String input = scanner.nextLine();

            //If exit chosen
            if (input.trim().equalsIgnoreCase("q")) {
                return -1;
            }
            //Try making int of input
            try {
                int parsedInput = Integer.parseInt(input.trim());

                //If the int is within the expected range OR if not
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

    //When quiz finished
    private void showResult(int score) {
        System.out.println("Quiz done!");
        System.out.println("You got " + score + " out of " + questions.size() + " correct!");
    }

    //Saving score to a scoreboard when finished
    private void saveScore(int score) {
        System.out.println("Would you like to save your score in the scoreboard?");
        System.out.println("1. yes");
        System.out.println("2. no");
        //Getting the answer grom the user
        Scanner input = service.ScannerHelper.getScanner();
        String userChoice = input.nextLine();
        //If user chooses to save the score
        if (userChoice.equals("1")) {
            while (true) {
                //Getting a nickname to identify the score later
                System.out.println("Please write your nickname:");
                String inputNickname = input.nextLine();
                //Validate that only allowed input is there
                if ((inputNickname.isEmpty()) || !inputNickname.matches("[a-zA-Z0-9_-]+") || inputNickname.length() > 12) {
                    System.out.println("Invalid Nickname. You can only use letters, numbers, underscores, and dashes. The name can be max 12 symbols long.");
                    continue;
                }
                //Try to save the score and nickname to the file OR give error
                try {
                    FileScoreRepository repo = new FileScoreRepository();
                    repo.saveScore(score, inputNickname);
                } catch (Exception e) {
                    System.out.println("Error saving score: " + e.getMessage());
                }
                break;
            }
            //If user chooses to not save the score
        } else if (userChoice.equals("2")) {
            System.out.println("Returning to main menu...");
        } else {
            System.out.println("Incorrect input");
        }
    }
}