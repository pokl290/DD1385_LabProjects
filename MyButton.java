// MyButton.java
import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    // Variables to store two states
    private String textState1;
    private String textState2;
    private Color colorState1;
    private Color colorState2;
    private boolean isState;

    // Constructor
    public MyButton(String text1, String text2, Color color1, Color color2) {
        this.textState1 = text1;
        this.textState2 = text2;
        this.colorState1 = color1;
        this.colorState2 = color2;
        this.isState = true; // Start with state 1

        // Set initial text and background color
        setText(textState1);
        setBackground(colorState1);

        // Make sure the background color is visible
        setOpaque(true);
        setBorderPainted(false);  // Disable the border painting
        setFocusPainted(false);   // Disable focus painting (removes the yellow outline)
        setContentAreaFilled(true); // Ensures the button is filled with color
    }

    // Method to toggle the button's state
    public void toggleState() {
        if (isState) {
            setText(textState2);
            setBackground(colorState2);
        } else {
            setText(textState1);
            setBackground(colorState1);
        }
        isState = !isState; // Toggle the state flag
    }
}