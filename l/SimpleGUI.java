
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI {
    public static void main(String[] args) {
        // Create a new window (JFrame)
        JFrame frame = new JFrame("Simple GUI");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Create a button
        JButton button = new JButton("Click Me");

        // Add an action listener to handle button click
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Hello, World!");
            }
        });

        // Add the button to the window
        frame.add(button);

        // Make the window visible
        frame.setVisible(true);
    }
}
