package model;

import interfaces.IQuestion;

// Class representing a quiz question
public class Question implements IQuestion {
    private final String questionText;
    private final String[] alternatives;
    private final int correctAnswer;

    public Question(String questionText, String[] alternatives, int correctAnswer) {
        this.questionText = questionText;
        this.alternatives = alternatives;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public int getCorrectAnswer() {
        return correctAnswer;
    }

    // Method to display the question
    @Override
    public void showQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < alternatives.length; i++) {
            System.out.println((i + 1) + ". " + alternatives[i]);
        }
    }

    // Method to check if the answer is correct
    @Override
    public boolean checkAnswer(int answer) {
        return answer == correctAnswer;
    }
}