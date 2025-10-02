import javax.swing.JFrame;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CardLayoutFrame frame = new CardLayoutFrame();
        frame.setSize(800, 600);
        frame.setTitle("Trivia Game_by Justin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        String[] num = {"test", "test1","test2","test3","test4","test5","test6","test7","test8"};
        List<String> list = Arrays.asList(num);
        Collections.shuffle(list);
        System.out.println(Arrays.toString(num));
    }
}