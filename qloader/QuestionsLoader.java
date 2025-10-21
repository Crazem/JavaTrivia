import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class QuestionsLoader {

    public List<Question> readFile(String fileName) {
        List<Question> questions = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int readCount = 0;
            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                readCount++;
                String[] parts = line.split(",");
                String questionText = parts[0];
                String[] options = Arrays.copyOfRange(parts, 1, parts.length - 1);
                int correctIndex = Integer.parseInt(parts[parts.length - 1]);
                Question q = new Question(questionText, options, correctIndex);
                questions.add(q);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException happened.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException happened.");
        }
        return questions;
    }
}
