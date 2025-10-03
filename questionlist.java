import java.util.*;
import java.util.Collections;
import java.util.Scanner;

public class questionlist {
    public static void main(String[] args) {
        //cat 1: periodic table
        ArrayList<Question> ptable = new ArrayList<>();
        ptable.add(new Question("What is the chemical symbol of Aluminum?", new String[]{"Al", "Au", "Am", "An"}, 0));
        ptable.add(new Question("Which of these is a nonmetal?", new String[]{"Chlorine", "Sodium", "Zinc", "Mercury"},0)); 
        ptable.add(new Question("What is the chemical symbol of Helium?", new String[]{"He", "Hl", "H", "Hm"},0));
        ptable.add(new Question("What is the chemical symbol for Lead?", new String[]{"Pb", "Le", "Ld", "Pd"}, 0));
        ptable.add(new Question("What element has the symbol H?", new String[]{"Hydrogen", "Helium", "Mercury", "Potassium"}, 0)); 
        ptable.add(new Question("Which of these is a metal?", new String[]{"Potassium", "Sulfur", "Chlorine", "Phosphorus"}, 0)); //q6

        ptable.add(new Question("What is the chemical symbol of Gold?", new String[]{"Go", "Au", "Gl", "Ag"},1));
        ptable.add(new Question("What element has the symbol Mg?", new String[]{"Manganese", "Magnesium", "Mercury", "Molybdenum"}, 1)); 
        ptable.add(new Question("What is the chemical symbol of Platinum?", new String[]{"P", "Pt", "Pl", "Pa"}, 1));
        ptable.add(new Question("Which element has the symbol Ag?", new String[]{"Argon", "Silver", "Gold", "Astatine"}, 1));
        ptable.add(new Question("What is the chemical symbol for Titanium?", new String[]{"Ta", "Ti", "T", "Tm"},1)); 
        ptable.add(new Question("What is the chemical symbol for Iron?", new String[]{"Hg", "Fe", "Ir", "Io"}, 1));
        ptable.add(new Question("What is the chemical symbol of Nickel?", new String[]{"N", "Ni", "K", "Nc"}, 1)); //q13

        ptable.add(new Question("What is the chemical symbol of Silicon?", new String[]{"Sc", "Sl", "Si", "S"},2));
        ptable.add(new Question("What is the chemical symbol of Nitrogen?", new String[]{"Ni", "No", "N", "Ng"}, 2));
        ptable.add(new Question("Which of these elements is a noble gas?", new String[]{"Hydrogen", "Carbon", "Helium", "Nitrogen"}, 2));
        ptable.add(new Question("What element has the symbol S?", new String[]{"Selenium", "Silicon", "Sulfur", "Iron"}, 2));
        ptable.add(new Question("What is the chemical symbol of Fluorine?", new String[]{"Fo", "Fl", "F", "Fr"}, 2)); //q18

        ptable.add(new Question("Which of these elements is not a noble gas?", new String[]{"Argon", "Nitrogen", "Krypton", "Helium"},1));
        ptable.add(new Question("Which element has the symbol Sn?", new String[]{"Silicon", "Strontium", "Iron", "Tin"},3));
        ptable.add(new Question("Which of these is a metal?", new String[]{"Silicon", "Chlorine", "Arsenic", "Calcium"}, 3));
        ptable.add(new Question("What is the chemical symbol of Lithium?", new String[]{"Lt", "Lm", "L", "Li"},3));
        ptable.add(new Question("What element has the symbol C?", new String[]{"Calcium", "Copper", "Cobalt", "Carbon"},3));
        ptable.add(new Question("Which of these elements is not a noble gas?", new String[]{"Xenon", "Radon", "Neon", "Oxygen"},3 ));
        ptable.add(new Question("What element has the symbol I?", new String[]{"Lithium", "Iridium", "Potassium", "Iodine"}, 3)); //q25





        //cat 2: state capitals
        ArrayList<Question> statecap = new ArrayList<>();
        statecap.add(new Question("What is the capital of California?", new String[]{"Sacramento", "Los Angeles", "San Francisco", "San Diego"}, 0));
        statecap.add(new Question("What is the capital of Texas?", new String[]{"Austin", "Dallas", "Houston", "San Antonio"}, 0));
        statecap.add(new Question("What is the capital of Florida?", new String[]{"Tallahassee", "Orlando", "Miami", "Jacksonville"}, 0));
        statecap.add(new Question("What is the capital of New York?", new String[]{"Albany", "New York City", "Buffalo", "Syracuse"}, 0));
        statecap.add(new Question("What is the capital of Pennsylvania?", new String[]{"Harrisburg", "Philadelphia", "Pittsburgh", "Lancaster"}, 0));
        statecap.add(new Question("What is the capital of Illinois?", new String[]{"Springfield", "Chicago", "Naperville", "Aurora"}, 0)); //q6

        statecap.add(new Question("What is the capital of Ohio?", new String[]{"Cincinnati", "Columbus", "Toledo", "Cleveland"}, 1));
        statecap.add(new Question("What is the capital of North Carolina?", new String[]{"Charlotte", "Raleigh", "Greensboro", "Asheville"}, 1));
        statecap.add(new Question("What is the capital of Michigan?", new String[]{"Detroit", "Lansing", "Grand Rapids", "Ann Arbor"}, 1));
        statecap.add(new Question("What is the capital of New Jersey?", new String[]{"Newark", "Trenton", "Jersey City", "Atlantic City"}, 1));
        statecap.add(new Question("What is the capital of Virginia?", new String[]{"Virginia Beach", "Richmond", "Norfolk", "Arlington"}, 1));
        statecap.add(new Question("What is the capital of Washington?", new String[]{"Tacoma", "Olympia", "Seattle", "Spokane"}, 1)); //q12

        statecap.add(new Question("What is the capital of Arizona?", new String[]{"Tucson", "Mesa", "Phoenix", "Flagstaff"}, 2));
        statecap.add(new Question("What is the capital of Massachusetts?", new String[]{"Springfield", "Cambridge", "Boston", "Worcester"}, 2));
        statecap.add(new Question("What is the capital of Tennessee?", new String[]{"Memphis", "Knoxville", "Nashville", "Chattanooga"}, 2));
        statecap.add(new Question("What is the capital of Indiana?", new String[]{"Fort Wayne", "Evansville", "Indianapolis", "South Bend"}, 2));
        statecap.add(new Question("What is the capital of Missouri?", new String[]{"Kansas City", "St. Louis", "Jefferson City", "Springfield"}, 2));
        statecap.add(new Question("What is the capital of Maryland?", new String[]{"Baltimore", "Philadelphia", "Annapolis", "Frederick"}, 2)); //q18

        statecap.add(new Question("What is the capital of Colorado?", new String[]{"Aurora", "Colorado Springs", "Boulder", "Denver"}, 3));
        statecap.add(new Question("What is the capital of Minnesota?", new String[]{"Minneapolis", "Rochester", "Duluth", "St. Paul"}, 3));
        statecap.add(new Question("What is the capital of South Carolina?", new String[]{"Raleigh", "Charleston", "Myrtle Beach", "Columbia"}, 3));
        statecap.add(new Question("What is the capital of Alabama?", new String[]{"Birmingham", "Baton Rouge", "Huntsville", "Montgomery"}, 3));
        statecap.add(new Question("What is the capital of Louisiana?", new String[]{"New Orleans", "Lafayette", "Charlotte", "Baton Rouge"}, 3));
        statecap.add(new Question("What is the capital of Oregon?", new String[]{"Portland", "Seattle", "Bend", "Salem"}, 3)); //q24
        statecap.add(new Question("What is the capital of Kentucky?", new String[]{"Nashville", "Louisville", "Lexington", "Frankfort"}, 3)); //q25

        //cat 3: math
        ArrayList<Question> math = new ArrayList<>();
        //algebra
        math.add(new Question("Solve for x: 2x + 3 = 7", new String[]{"2", "3", "5", "1"}, 0));
        math.add(new Question("Solve for x: 3x - 4 = 11", new String[]{"5", "7", "3", "4"}, 0));
        math.add(new Question("Solve for x: x + 5 = 12", new String[]{"7", "6", "8", "5"}, 0));
        math.add(new Question("Solve for x: 4x = 20", new String[]{"5", "6", "4", "10"}, 0));
        math.add(new Question("Solve for x: (5x)/2 - 5 = 0", new String[]{"2", "1", "0", "5"}, 0));
        math.add(new Question("Solve for x: 6x + 9 = 27", new String[]{"3", "2", "4", "6"}, 0)); //q6

        //number theory
        math.add(new Question("Which of these numbers is prime?", new String[]{"21", "29", "35", "51"}, 1));
        math.add(new Question("Which number is divisible by 4?", new String[]{"18", "28", "22", "15"}, 1));
        math.add(new Question("Which number is a factor of 72?", new String[]{"10", "12", "14", "20"}, 1));
        math.add(new Question("Which of these numbers is a perfect square?", new String[]{"24", "49", "50", "99"}, 1));
        math.add(new Question("Which of these numbers is divisible by 3?", new String[]{"1247", "8160", "1250", "7102"}, 1));
        math.add(new Question("Which number is a perfect cube?", new String[]{"9", "27", "16", "66"}, 1)); //q12

        //unit circle
        math.add(new Question("What is sin(pi/2)?", new String[]{"0", "-1", "1", "1/2"}, 2));
        math.add(new Question("What is cos(pi/4)?", new String[]{"0", "1/2", "√2/2", "1"}, 2));
        math.add(new Question("What is sin(pi)?", new String[]{"1", "-1", "0", "1/2"}, 2));
        math.add(new Question("What is cos(pi/6)?", new String[]{"-1", "1/2", "√3/2", "1"}, 2));
        math.add(new Question("What is sin(7pi/6)?", new String[]{"1", "√3/2", "-1/2", "1/2"}, 2));
        math.add(new Question("What is sin(5pi/4)?", new String[]{"√2/2", "√3/2", "-√2/2", "1/2"}, 2)); //q18

        //derivatives
        math.add(new Question("What is the derivative of x^2?", new String[]{"x", "x^3", "1", "2x"}, 3));
        math.add(new Question("What is the derivative of sin(x)?", new String[]{"sin(x)", "-sin(x)", "-cos(x)", "cos(x)"}, 3));
        math.add(new Question("What is the derivative of ln(x)?", new String[]{"x", "1/ln(x)", "1", "1/x"}, 3));
        math.add(new Question("What is the derivative of e^x?", new String[]{"xe^x", "e^(x-1)", "xe^(x-1)", "e^x"}, 3));
        math.add(new Question("What is the derivative of ln(x^2 + 1)?", new String[]{"1/(x^2 + 1)", "2x", "ln(x^2)", "2x/(x^2 + 1)"}, 3));
        math.add(new Question("What is the derivative of x^2 + x?", new String[]{"2x", "2x - 1", "x^2 + 1", "2x + 1"}, 3));
        math.add(new Question("What is the derivative of cos(x)?", new String[]{"sin(x)", "-cos(x)", "cos(x)", "-sin(x)"}, 3)); //q25


        //cat 4: programming
        ArrayList<Question> cs = new ArrayList<>();
        //data structures and algorithms
        cs.add(new Question("What is DFS?", new String[]{"Dorian Finney-Smith", "Depth First Search", "Daily Fantasy Sports", "All of the above"}, 3));
        cs.add(new Question("Which type of linked list allows traversal in both directions?", new String[]{"Doubly Linked List", "Singly Linked List", "Circular Linked List", "Skip List"}, 0));
        cs.add(new Question("What method allows you to efficiently find the middle of a linked list?", new String[]{"Two Pointer", "Dynamic Programming", "Merge Sort", "Binary Search"}, 0));
        cs.add(new Question("Which of these implements first in first out?", new String[]{"Queue", "Linked List", "Trees", "Stack"}, 0));
        cs.add(new Question("Which traversal visits nodes level by level in a tree?", new String[]{"BFS", "DFS", "Inorder", "Postorder"}, 0));
        cs.add(new Question("Which traversal of a binary tree visits nodes left-root-right?", new String[]{"Inorder", "Preorder", "Postorder", "DFS"}, 0));
        cs.add(new Question("Which data structure stores elements in a key-value pair format?", new String[]{"Hash Map", "Queue", "Stack", "Heap"}, 0)); //q7

        cs.add(new Question("Which algorithm is divide-and-conquer?", new String[]{"Bubble Sort", "Merge Sort", "Linear Search", "None of the above"}, 1));
        cs.add(new Question("Which data structure allows insertion and deletion at both ends?", new String[]{"Queue", "Deque", "Stack", "HashMap"}, 1));
        cs.add(new Question("Which of these is NOT a linear data structure?", new String[]{"Array", "Binary Tree", "Linked List", "Stack"}, 1));
        cs.add(new Question("Which of these implements last in first out?", new String[]{"Queue", "Stack", "Linked List", "Hash Map"}, 1));
        cs.add(new Question("Which sorting algorithm repeatedly swaps adjacent elements if they are in the wrong order?", new String[]{"Selection Sort", "Bubble Sort", "Insertion Sort", "Merge Sort"}, 1));
        cs.add(new Question("Which operation on a stack removes the top element?", new String[]{"enqueue", "pop", "push", "peek"}, 1)); //q13


        //time complexity
        cs.add(new Question("What is the time complexity of traversing all elements in a singly linked list of n nodes?", new String[]{"O(1)", "O(log n)", "O(n)", "O(n^2)"}, 2));
        cs.add(new Question("What is the time complexity of accessing an element in an array by index?", new String[]{"O(n)", "O(log n)", "O(1)", "O(n log n)"}, 2));
        cs.add(new Question("What is the time complexity of binary search in a sorted array?", new String[]{"O(n)", "O(1)", "O(log n)", "O(n log n)"}, 2));
        cs.add(new Question("What is the worst-case time complexity of bubble sort?", new String[]{"O(n)", "O(log n)", "O(n^2)", "O(n log n)"}, 2));
        cs.add(new Question("What is the time complexity of merging two sorted arrays of sizes n and m?", new String[]{"O(n)", "O(m)", "O(n+m)", "O(n*m)"}, 2));
        cs.add(new Question("What is the time complexity of checking if an element exists in a hash table?", new String[]{"O(n)", "O(log n)", "O(1)", "O(n^2)"}, 2)); //q19

        //java
        cs.add(new Question("Which keyword is used to inherit a class in Java?", new String[]{"implements", "super", "this", "extends"}, 3));
        cs.add(new Question("Which of these is NOT a primitive data type in Java?", new String[]{"char", "int", "boolean", "String"}, 3));
        cs.add(new Question("Which of these converts a String to an integer in Java?", new String[]{"String.valueOf()", "Integer.toString()", "Double.parseDouble()", "Integer.parseInt()"}, 3));
        cs.add(new Question("Which keyword is used to create an instance of a class?", new String[]{"create", "instance", "object", "new"}, 3));
        cs.add(new Question("Which of these exceptions is thrown when dividing by zero?", new String[]{"IOException", "ArrayIndexOutOfBoundsException", "ClassNotFoundException", "ArithmeticException"}, 3));
        cs.add(new Question("Which operator is used for logical AND in Java?", new String[]{"&", "||", "|", "&&"}, 3)); //q25

        Collections.shuffle(ptable);
        Collections.shuffle(cs);
        Collections.shuffle(math);
        Collections.shuffle(statecap);

        ArrayList<Question> quiz = cs;
//        ArrayList<Question> quiz = ptable;
//        ArrayList<Question> quiz = math;
//        ArrayList<Question> quiz = statecap;

        int score = 0;
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
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
        System.out.println("Your score: " + score + "/" + 10);
    }
}