// MyFrame.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// MyFrame class that extends JFrame
public class MyFrame extends JFrame implements ActionListener {

    private MyButton[] buttons; // Array to hold multiple buttons

    // Constructor
    public MyFrame() {
        // Set the title to the authors' names
        super("Author: Kevin Lam & Allan Inma");

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the background color to your favorite color
        getContentPane().setBackground(Color.CYAN);

        // Create a layout for the frame
        setLayout(new FlowLayout());
        setSize(400,200);

        // Add multiple MyButton components
        buttons = new MyButton[2]; // Create two buttons
        buttons[0] = new MyButton("State 1", "State 2", Color.GREEN, Color.RED);
        buttons[1] = new MyButton("ON", "OFF", Color.BLUE, Color.ORANGE);

        // Add the buttons to the frame and set up action listeners
        for (MyButton button : buttons) {
            add(button); // Add button to the frame
            button.addActionListener(this); // Connect ActionListener to buttons
        }

        // Pack the frame to fit the buttons

        setVisible(true); // Make the frame visible
    }

    // Implement actionPerformed to toggle button state
    @Override
    public void actionPerformed(ActionEvent e) {
        MyButton button = (MyButton) e.getSource(); // Get the button that was clicked
        button.toggleState(); // Toggle the state of the button
    }

    // Main method to run the program
    public static void main(String[] args) {
        new MyFrame(); // Create an instance of MyFrame
    }
}