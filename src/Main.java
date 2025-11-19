public class Main {
    public static void main(String[] args) {

        IQuiz quiz = QuizSelectHelper.chooseQuiz();

        quiz.start();
    }
}