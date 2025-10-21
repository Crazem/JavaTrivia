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
import java.util.*;
import java.util.List;
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

    private boolean clicked = false;

    private JLabel nameLabel;
    private JLabel timerLabel;
    private javax.swing.Timer countdownTimer; // Swing timer (NOT java.util.Timer)
    private int timeLeft; // seconds remaining
    private Timer tmr = new Timer();


    private int Correct;

    public CardLayoutFrame() {
        username = "default name";
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        currentQuestionIdx = 0;

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
        JLabel scoreLabel = new JLabel("Score: " + Correct + " / 25");
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

        nextButton = new JButton("Go to results");
        gamePanel.add(nextButton, BorderLayout.SOUTH);
        JPanel nestedButtonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JButton("Option" + (i + 1));
            optionButtons[i].addActionListener(new OptionButtonHandler(i));
            nestedButtonPanel.add(optionButtons[i]);
        }

        gamePanel.add(nestedButtonPanel, BorderLayout.CENTER);

        JPanel topPanel = new JPanel(new BorderLayout());

        nameLabel = new JLabel();
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        nameLabel.setText("Player: " + username);
        cardLayout.show(cardPanel, "G");

        timerLabel = new JLabel("Time: 10s");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        timerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        topPanel.add(nameLabel, BorderLayout.WEST);
        topPanel.add(timerLabel, BorderLayout.EAST);
        topPanel.add(questionLabel, BorderLayout.NORTH);

        gamePanel.add(topPanel, BorderLayout.NORTH);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, "Times up!");
            }
        };

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
            QuestionsLoader loader = new QuestionsLoader();
            List<Question> loadedQuestions = null;
            if (e.getSource() == cs) {
                loadedQuestions = loader.readFile("cs.txt");
            } else if (e.getSource() == math) {
                loadedQuestions = loader.readFile("math.txt");
            } else if (e.getSource() == ptable) {
                loadedQuestions = loader.readFile("ptable.txt");
            } else if (e.getSource() == cap) {
                loadedQuestions = loader.readFile("statecap.txt");
            }
            if (loadedQuestions != null && loadedQuestions.size() > 0) {
                Collections.shuffle(loadedQuestions);
                importQuestions(loadedQuestions);
                currentQuestionIdx = 0;
                nameLabel.setText("Player: " + username);
                cardLayout.show(cardPanel, "G");
                loadNextQuestion();
            } else {
                JOptionPane.showMessageDialog(null, "No questions found for this category.");
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
                if (countdownTimer != null && countdownTimer.isRunning()) {
                    countdownTimer.stop();
                }
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
            if(clicked)
                return;
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    clicked = false;
                    loadNextQuestion();
                }
            };
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
                Correct++;
            }
            // go to the next question
            if (countdownTimer != null && countdownTimer.isRunning()) {
                countdownTimer.stop();
            }
            currentQuestionIdx++;
            clicked = true;
            timer.schedule(task, 2500);
        }
    }

    private void importQuestions(List<Question> loadedQuestions) {
        questionGroups = new ArrayList<List<String>>();
        correctAnswers = new ArrayList<Integer>();
        for (int i = 0; i < loadedQuestions.size(); i = i + 1) {
            Question q = loadedQuestions.get(i);
            List<String> questionData = new ArrayList<String>();
            questionData.add(q.question);
            questionData.add(q.options[0]);
            questionData.add(q.options[1]);
            questionData.add(q.options[2]);
            questionData.add(q.options[3]);
            questionGroups.add(questionData);
            correctAnswers.add(q.correctIndex);
        }
    }

    private void loadNextQuestion() {
        if (countdownTimer != null && countdownTimer.isRunning()) {
            countdownTimer.stop();
        }
        if (questionGroups == null || questionGroups.isEmpty() || currentQuestionIdx >= questionGroups.size()) {
            createResultsPanel();
            cardLayout.show(cardPanel, "R");
            return;
        }
        questionLabel.setText(questionGroups.get(currentQuestionIdx).get(0));
        for (int i = 0; i < 4; i++) {
            optionButtons[i].setText(questionGroups.get(currentQuestionIdx).get(i + 1));
            optionButtons[i].setBackground(Color.white);
        }

        timeLeft = 10;
        timerLabel.setText("Time: " + timeLeft + "s");

        countdownTimer = new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                timerLabel.setText("Time: " + timeLeft + "s");
                if (timeLeft <= 0) {
                    ((javax.swing.Timer) e.getSource()).stop();
                    JOptionPane.showMessageDialog(null, "Time's up!");
                    currentQuestionIdx++;
                    loadNextQuestion();
                }
            }
        });
        countdownTimer.start();
    }

};

