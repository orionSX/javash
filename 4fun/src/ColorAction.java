import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorAction implements ActionListener {
    private  Color color;
    private  JPanel panel;

    public ColorAction(Color color, JPanel panel) {
        this.color = color;
        this.panel = panel;
    }

    public void actionPerformed(ActionEvent e) {
        panel.setBackground(color);
    }
}
