class Question {
    String question;
    String[] options;
    int correctIndex;

    // Constructor
    public Question(String question, String[] options, int correctIndex) {
        this.question = question;
        this.options = options;
        this.correctIndex = correctIndex;
    }

    // Method to display the question and options
    public void display() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    // Method to get the correct answer as a string
    public String getCorrectAnswer() {
        return options[correctIndex];
    }
}