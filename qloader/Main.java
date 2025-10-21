import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        // debug/testing/sample
        QuestionsLoader loader = new QuestionsLoader();
        List<Question> ptable = loader.readFile("src/ptable.txt");
        List<Question> statecap = loader.readFile("src/statecap.txt");
        List<Question> math = loader.readFile("src/math.txt");
        List<Question> cs = loader.readFile("src/cs.txt");

        System.out.println("Loaded " + statecap.size() + " state capital questions.");
        System.out.println("Loaded " + ptable.size() + " ptable questions.");
        System.out.println("Loaded " + cs.size() + " cs questions.");
        System.out.println("Loaded " + math.size() + " math questions.");

    }
}