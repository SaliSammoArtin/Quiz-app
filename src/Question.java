public class Question {
    private String questionText;
    private String[] alternatives;
    private String correctAnswer;

    public Question(String questionText, String[] alternatives, String correctAnswer) {
        this.questionText = questionText;
        this.alternatives = alternatives;
        this.correctAnswer = correctAnswer;
    }

    public void showQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < alternatives.length; i++) {
            System.out.println((i + 1) + ". " + alternatives[i]);
        }
    }

    public boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
