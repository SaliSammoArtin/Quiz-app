public class Question implements IQuestion {
    private String questionText;
    private String[] alternatives;
    private String correctAnswer; // göra om detta till int, anpassa koden

    public Question(String questionText, String[] alternatives, String correctAnswer) {
        this.questionText = questionText;
        this.alternatives = alternatives;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void showQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < alternatives.length; i++) {
            System.out.println((i + 1) + ". " + alternatives[i]);
        }
    }

    @Override
    public boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
