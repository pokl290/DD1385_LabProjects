import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

// MyFrame class that extends JFrame
public class MyFrame extends JFrame implements ActionListener {

    private int numberButton;
    private MyButton[] buttons; // Array to hold multiple buttons
    private ArrayList<String> stateOneText; // List for State 1 texts
    private ArrayList<String> stateTwoText; // List for State 2 texts

    // Constructor
    public MyFrame(int amountButton, ArrayList<String> stateOneText, ArrayList<String> stateTwoText) {
        this.numberButton = amountButton;
        this.stateOneText = stateOneText;
        this.stateTwoText = stateTwoText;

        // Set the title to the authors' names
        this.setTitle("Author: Allan & Kevin");

        // Set the default close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the background color to your favorite color
        this.getContentPane().setBackground(Color.CYAN);

        // Create a layout for the frame
        this.setLayout(new FlowLayout());
        this.setSize(400, 200);

        // Initialize and add MyButton components
        buttons = new MyButton[amountButton]; // Create buttons array

        // Loop through and initialize each button with corresponding state text
        for (int i = 0; i < amountButton; i++) {
            // Get the text from the lists
            String state1 = stateOneText.get(i);
            String state2 = stateTwoText.get(i);

            // Create a MyButton with the correct text for both states
            buttons[i] = new MyButton(state1, state2, Color.PINK, Color.BLUE);
            add(buttons[i]); // Add button to the frame
            buttons[i].addActionListener(this); // Connect ActionListener to buttons
        }

        setVisible(true); // Make the frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyButton clickedButton = (MyButton) e.getSource(); // Get the button that was clicked

        // Toggle all buttons except the clicked one
        for (MyButton button : buttons) {
            if (button != clickedButton) {
                button.toggleState(); // Toggle the state of the other buttons
            }
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Check if command line arguments are provided
        if (args.length < 2 || args.length % 2 != 1) {
            System.out.println("Usage: java MyFrame <number_of_buttons> <state1_text1> <state2_text1> ... <state1_textN> <state2_textN>");
            return;
        }


        // Extract number of buttons from the first argument
        int amountButton = Integer.parseInt(args[0]);

        // ArrayLists to hold button texts for the two states
        ArrayList<String> stateOneText = new ArrayList<>();
        ArrayList<String> stateTwoText = new ArrayList<>();

        // Fill the stateOneText and stateTwoText lists
        for (int i = 0; i < amountButton; i++) {
            // Each button has two arguments (state1 and state2)
            stateOneText.add(args[1 + 2 * i]); // State 1 text for button i
            stateTwoText.add(args[2 + 2 * i]); // State 2 text for button i
        }
        new MyFrame(amountButton, stateOneText, stateTwoText);
        // Create an instance of MyFrame
    }
    
}


