package interfaces;

public interface IQuestion {
    void showQuestion();

    boolean checkAnswer(int answer);

    int getCorrectAnswer();
    // Gör att vi i framtiden kan ha många olika typer av frågor, utan att ändra något i service.QuizGame.

}
