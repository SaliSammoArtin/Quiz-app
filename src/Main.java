import java.util.Scanner;

// Kolla upp hur mapstruktur kan se ut
// Någon får göra om int i Question - Leo
// Någon kan iterera flera frågor till varje quiz. - Sali
// Sali kollar upp kring interfaces
// Enum - Desiree

//Sali kollar om det går att hämta svaren med index?
public class Main {
    public static void main(String[] args) {

        //Desirée gör menyn till Enum
        System.out.println("Choose a quiz:");
        System.out.println("1. Animals Quiz");
        System.out.println("2. Sweden cities generic quiz");
        System.out.print("Write the number of your choice: ");

        /* This declares that QuizGame exists, but the value is assign according to
        ... what the user chooses */

        QuizGame quiz = QuizSelectHelper.chooseQuiz();
        quiz.startaQuiz();
    }
}
// Göra en IQuestion interface som Question klassen kan implementera (Sali kan fixa?)
// eller ett ICOMMANDS som innehåller olika kommandon, kopplad till en kommando klass