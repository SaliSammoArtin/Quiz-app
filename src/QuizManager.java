import java.util.ArrayList;

public class QuizManager {

    public static ArrayList<Question> createAnimalQuiz() {
        ArrayList<Question> list = new ArrayList<>();

        list.add(new Question(
                "What is the biggest animal?",
                new String[]{"Elephant", "Blue whale", "Giraffe", "Panda"},
                "2"
        ));

        list.add(new Question(
                "Which animal can fly?",
                new String[]{"Ostrich", "Penguin", "Falk", "Rat"},
                "3"
        ));

        // Add more questions here

        return list;
    }

    public static ArrayList<Question> createGeneralQuiz() {
        ArrayList<Question> list = new ArrayList<>();

        list.add(new Question(
                "The capital of Sweden?",
                new String[]{"Göteborg", "Malmö", "Stockholm", "Uppsala"},
                "3"
        ));

        list.add(new Question(
                "What is the third biggest city in Sweden?",
                new String[]{"Göteborg", "Malmö", "Stockholm", "Uppsala"},
                "2"
        ));

        return list;
    }
}
// IQuiz som QuizManager implementerar? (Sali kan fixa interfaces?)