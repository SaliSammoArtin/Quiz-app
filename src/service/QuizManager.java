package service;

import interfaces.IQuestion;
import model.Question;

import java.util.ArrayList;

public class QuizManager {

    // Generates the Animal quiz (10 questions)
    public static ArrayList<IQuestion> createAnimalQuiz() {
        ArrayList<IQuestion> list = new ArrayList<>();

        list.add(new Question(
                "What is the biggest animal?",
                new String[]{"Elephant", "Blue whale", "Giraffe", "Panda"},
                2
        ));

        list.add(new Question(
                "Which animal can fly?",
                new String[]{"Ostrich", "Penguin", "Falcon", "Rat"}, // Changed "Falk" to "Falcon"
                3
        ));

        list.add(new Question(
                "Which animal is the fastest land animal?",
                new String[]{"Lion", "Cheetah", "Horse", "Kangaroo"},
                2
        ));

        list.add(new Question(
                "Which animal has the longest lifespan?",
                new String[]{"Elephant", "Blue whale", "Giant tortoise", "Shark"},
                3
        ));

        list.add(new Question(
                "Which animal is known for changing its color?",
                new String[]{"Iguana", "Chameleon", "Frog", "Gecko"},
                2
        ));

        list.add(new Question(
                "Which bird is famous for its ability to mimic sounds?",
                new String[]{"Sparrow", "Peacock", "Parrot", "Eagle"},
                3
        ));

        list.add(new Question(
                "Which animal sleeps the most per day (up to 20 hours)?",
                new String[]{"Cat", "Koala", "Sloth", "Hamster"},
                2
        ));

        list.add(new Question(
                "Which animal is the largest land carnivore?",
                new String[]{"Lion", "Grizzly bear", "Polar bear", "Tiger"},
                3
        ));

        list.add(new Question(
                "Which animal uses echolocation to navigate?",
                new String[]{"Bat", "Horse", "Snake", "Rabbit"},
                1
        ));

        list.add(new Question(
                "Which animal is known for having a pouch for its young?",
                new String[]{"Platypus", "Kangaroo", "Python", "Seal"},
                2
        ));

        return list;
    }

    // Generates the Swedish cities quiz
    public static ArrayList<IQuestion> createSwedishPlacesQuiz() {
        ArrayList<IQuestion> list = new ArrayList<>();

        list.add(new Question(
                "What is the capital of Sweden?", // Added "What is" for a complete sentence
                new String[]{"Göteborg", "Malmö", "Stockholm", "Uppsala"},
                3
        ));

        list.add(new Question(
                "What is the third biggest city in Sweden?",
                new String[]{"Göteborg", "Malmö", "Stockholm", "Uppsala"},
                2
        ));

        list.add(new Question(
                "Which country borders Sweden to the west?",
                new String[]{"Finland", "Norway", "Denmark", "Iceland"},
                2
        ));

        list.add(new Question(
                "What is Sweden's longest river?",
                new String[]{"Dalälven", "Göta älv", "Klarälven", "Torne älv"},
                4
        ));

        list.add(new Question(
                "Which Swedish city is home to the amusement park Liseberg?", // Clarified the question
                new String[]{"Göteborg", "Malmö", "Stockholm", "Karlstad"},
                1
        ));

        list.add(new Question(
                "Which island is the largest in Sweden?",
                new String[]{"Öland", "Gotland", "Hisingen", "Orust"},
                2
        ));

        list.add(new Question(
                "Which Swedish city is known for the university founded in 1477?",
                new String[]{"Stockholm", "Uppsala", "Lund", "Umeå"},
                2
        ));

        list.add(new Question(
                "Which sea is to the east of Sweden?",
                new String[]{"North Sea", "Baltic Sea", "Mediterranean Sea", "Arctic Ocean"},
                2
        ));

        list.add(new Question(
                "Which city is the second largest in Sweden?",
                new String[]{"Malmö", "Göteborg", "Uppsala", "Linköping"},
                2
        ));

        list.add(new Question(
                "Which Swedish city is known as the home of IKEA's headquarters?",
                new String[]{"Växjö", "Halmstad", "Malmö", "Älmhult"},
                4
        ));

        return list;
    }
}