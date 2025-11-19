public interface IQuestion {
    void showQuestion();

    boolean checkAnswer(String answer);

    String getCorrectAnswer();
    // Gör att vi i framtiden kan ha många olika typer av frågor, utan att ändra något i QuizGame.

}
