import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Question> quiz = new ArrayList<>();
        quiz.add(new Question("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Rome"}, 0));
        quiz.add(new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Venus", "Mars", "Jupiter"}, 2));
        quiz.add(new Question("What is 2 + 2?", new String[]{"3","4","5","6"}, 1));
        quiz.add(new Question("Which element has the chemical symbol 'O'?", new String[]{"Oxygen","Gold","Iron","Helium"}, 0));
        quiz.add(new Question("Who wrote 'Romeo and Juliet'?", new String[]{"Shakespeare","Hemingway","Tolkien","Austen"}, 0));
        quiz.add(new Question("What is the largest ocean on Earth?", new String[]{"Atlantic","Indian","Pacific","Arctic"}, 2));
        quiz.add(new Question("How many continents are there on Earth?", new String[]{"5","6","7","8"}, 2));
        quiz.add(new Question("What is the fastest land animal?", new String[]{"Cheetah","Lion","Tiger","Horse"}, 0));
        quiz.add(new Question("Which planet is closest to the Sun?", new String[]{"Venus","Earth","Mercury","Mars"}, 2));
        quiz.add(new Question("Which language is primarily spoken in Brazil?", new String[]{"Spanish","Portuguese","English","French"}, 1));

        Collections.shuffle(quiz);

        int score = 0;
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < quiz.size(); i++) {
            Question q = quiz.get(i);
            System.out.println("\nQuestion " + (i + 1) + ":");
            q.display();

            System.out.print("Your answer (1-4): ");
            int answer = input.nextInt() - 1;

            if (answer == q.correctIndex) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " + q.getCorrectAnswer());
            }
        }

        System.out.println("\nQuiz finished!");
        System.out.println("Your score: " + score + "/" + quiz.size());
    }
}