import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import javax.swing.Box;
import javax.swing.BoxLayout;


public class CardLayoutFrame extends JFrame {
    private JButton startButton;
    private JButton nextButton;
    private JButton usernameButton;
    private JButton playButton;
    private JButton restartButton;

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel usernamePanel;

    private JTextField inputField;
    private String username;
    private JLabel questionLabel;
    private JButton[] optionButtons = new JButton[4];
    private int currentQuestionIdx;
    private List<List<String>> questionGroups;
    private ArrayList<Integer> correctAnswers;


    private JButton cs;
    private JButton cap;
    private JButton ptable;
    private JButton math;

    private Color RED =  new Color(160,27,27);
    private Color GREEN = new Color(46, 160, 96);


    private int Correct;

    public CardLayoutFrame() {
        username = "default name";
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        currentQuestionIdx = 0;
        importQuestions();

        // first page - welcome
        createWelcomePanel();

        // username page
        createUsernamePanel();

        // second page - quiz
        createGamePanel();

        createResultsPanel();
//        //third page - results
//        createResultsPanel();

        add(cardPanel);

        ButtonHandler handler = new ButtonHandler();
        startButton.addActionListener(handler);
        usernameButton.addActionListener(handler);
        //playButton.addActionListener(handler);
        nextButton.addActionListener(handler);
    }

    private void createResultsPanel() {
        JPanel resultsPanel = new JPanel();
        resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel("Results:");
        JLabel userLabel = new JLabel("Username: " + username);
        JLabel scoreLabel = new JLabel("Score: " + Correct + " / 5");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        userLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 32));

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        restartButton = new JButton("Restart");
        restartButton.setFont(new Font("Arial", Font.BOLD, 20));
        restartButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        ButtonHandler rst = new ButtonHandler();
        restartButton.addActionListener(rst);

        resultsPanel.add(Box.createVerticalGlue());
        resultsPanel.add(titleLabel);
        resultsPanel.add(Box.createVerticalStrut(20));
        resultsPanel.add(userLabel);
        resultsPanel.add(Box.createVerticalStrut(10));
        resultsPanel.add(scoreLabel);
        resultsPanel.add(Box.createVerticalStrut(30));
        resultsPanel.add(restartButton);
        resultsPanel.add(Box.createVerticalGlue());

        cardPanel.add(resultsPanel, "R");
    }


    private void createGamePanel() {
        JPanel gamePanel = new JPanel(new BorderLayout());
        questionLabel = new JLabel("Place holder for questions", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gamePanel.add(questionLabel, BorderLayout.NORTH);

        nextButton = new JButton("Go to results");
        gamePanel.add(nextButton, BorderLayout.SOUTH);
        JPanel nestedButtonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JButton("Option" + (i + 1));
            optionButtons[i].addActionListener(new OptionButtonHandler(i));
            nestedButtonPanel.add(optionButtons[i]);
        }

        gamePanel.add(nestedButtonPanel, BorderLayout.CENTER);

        /* remember to add this username panel to the cardPanel object, and give it a name */
        cardPanel.add(gamePanel, "G");
    }

    private void createWelcomePanel() {
        JPanel welcomePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Trivia Game!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        welcomePanel.add(title, BorderLayout.CENTER);

        startButton = new JButton("Start game!");
        welcomePanel.add(startButton, BorderLayout.SOUTH);

        /* remember to add this username panel to the cardPanel object, and give it a name */
        cardPanel.add(welcomePanel, "W");
    }

    private void createUsernamePanel() {
        //create main panel
        usernamePanel = new JPanel(new BorderLayout());

        /* create a nested username button panel */
        JPanel nestedUsernamePanel = new JPanel(new FlowLayout());
        //create input field
        inputField = new JTextField("Enter a username");
        inputField.setFont(new Font("Arial", Font.PLAIN, 20));

        //buttons
        usernameButton = new JButton("set username");
        cs = new JButton("CS");
        math = new JButton("Math");
        ptable = new JButton("Chem");
        cap = new JButton("Capitals");
        //add the input field to the username button panel
        nestedUsernamePanel.add(inputField);
        //add the username button to the username button panel
        nestedUsernamePanel.add(usernameButton);

        //add this nested username button panel to the main username panel
        usernamePanel.add(nestedUsernamePanel, BorderLayout.NORTH);

        /* create a nested play button panel */
        JPanel playButtonPanel = new JPanel(new FlowLayout());
        //create play button to start the game
        //playButton = new JButton("Play!");
        //add the play button the play button panel
        //playButtonPanel.add(playButton);
        JPanel quizSelect = new JPanel(new GridLayout(2, 2, 10, 10));
        
        
        
        quizSelect.add(cs);
        quizSelect.add(ptable);
        quizSelect.add(math);
        quizSelect.add(cap);

        gameSelect sel = new gameSelect();
        cs.addActionListener(sel);
        ptable.addActionListener(sel);
        math.addActionListener(sel);
        cap.addActionListener(sel);
        
        usernamePanel.add(playButtonPanel, BorderLayout.SOUTH);
        usernamePanel.add(quizSelect, BorderLayout.CENTER);

        /* remember to add this username panel to the cardPanel object, and give it a name */
        cardPanel.add(usernamePanel, "U");

    }

    private class gameSelect implements ActionListener {
        @Override

        public void actionPerformed(ActionEvent e) {
            QuestionsLoader Loader = new QuestionsLoader();
            if(e.getSource() == cs) {
                List<Question> questions = Loader.readFile("cs.txt");
                cardLayout.show(cardPanel, "G");
            }else if(e.getSource() == math) {
                List<Question> questions = Loader.readFile("math.txt");
                cardLayout.show(cardPanel, "G");
            }else if(e.getSource() == ptable) {
                List<Question> questions = Loader.readFile("ptable.txt");
                cardLayout.show(cardPanel, "G");
            }else if(e.getSource() == cap) {
                List<Question> questions = Loader.readFile("cap.txt");
                cardLayout.show(cardPanel, "G");
            }
        }
    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == startButton) {
                cardLayout.show(cardPanel, "U"); // show username
            } else if (e.getSource() == usernameButton) {
                //save username
                username = inputField.getText();
                //show message to welcome the user
                JOptionPane.showMessageDialog(null, "Welcome " + username + "!");

            } else if (e.getSource() == playButton) {
                loadNextQuestion();
                cardLayout.show(cardPanel, "G"); // show quiz game
            } else if (e.getSource() == restartButton) {
                Correct = 0;
                currentQuestionIdx = 0;
                cardLayout.show(cardPanel, "U");

            } else if (e.getSource() == nextButton) {
                createResultsPanel();
                cardLayout.show(cardPanel, "R"); // show results
            }
        }
    }

    private class OptionButtonHandler implements ActionListener {
        private int index;
        private OptionButtonHandler(int index) {
            this.index = index;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // check answer
            for(int i = 0;i < optionButtons.length;i++)
            {
                if(i != correctAnswers.get(currentQuestionIdx))
                {
                    optionButtons[i].setBackground(RED);
                }
                else
                {
                    optionButtons[i].setBackground(GREEN);
                }
            }
            if (index == correctAnswers.get(currentQuestionIdx)) {
                JOptionPane.showMessageDialog(null, "Correct!");
                Correct++;

            } else {
                JOptionPane.showMessageDialog(null, "that was incorrect.");
            }

            // go to the next question
            currentQuestionIdx++;
            loadNextQuestion();
        }
    }

    private void importQuestions() {
        questionGroups = new ArrayList<>();
        correctAnswers = new ArrayList<>();

//        List<String> list = new ArrayList<>();
//        list.add("Question 1: What do we refer to BST in 4319 ?");
//        list.add("British Summer Time");
//        list.add("Breadth Search Tree");
//        list.add("Binary Search Tree");
//        list.add("None of above");
//        questionGroups.add(list);
        questionGroups.add(List.of("Question 1: What do we refer to BST in 4319 ?",
                "British Summer Time",
                "Breadth Search Tree",
                "Binary Search Tree",
                "None of above"));
        correctAnswers.add(2);

        questionGroups.add(List.of("Which class belongs to Java Swing?",
                "NumberFormatException",
                "String",
                "Graphics",
                "None of above"));
        correctAnswers.add(3);

        questionGroups.add(List.of("What is the capital of France?", "Paris", "London", "Berlin", "Rome"));
        correctAnswers.add(0);

        questionGroups.add(List.of("Which planet is known as the Red Planet?", "Earth", "Venus", "Mars", "Jupiter"));
        correctAnswers.add(2);

        questionGroups.add(List.of("Recursion always needs a?", "Loop", "Base Case", "Queue", "Stack"));
        correctAnswers.add(1);
    }

    private void loadNextQuestion() {
        if (questionGroups == null || questionGroups.size() == 0
                || currentQuestionIdx >= questionGroups.size()) {
            createResultsPanel();
            cardLayout.show(cardPanel, "R"); // show results
            return;
        }
        questionLabel.setText(questionGroups.get(currentQuestionIdx).get(0));
        for (int i = 0; i < 4; i++) {
            optionButtons[i].setText(questionGroups.get(currentQuestionIdx).get(i + 1));
            optionButtons[i].setBackground(Color.white);
        }
    }
}

