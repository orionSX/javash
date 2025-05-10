
package main;

import javax.swing.*;
import java.awt.*;

public class DrawingFrame extends JFrame {
    public DrawingFrame() {
        setTitle("Рисовалка");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        DrawingPanel drawingPanel = new DrawingPanel();
        ColorPicker colorPicker = new ColorPicker();

        add(colorPicker, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
