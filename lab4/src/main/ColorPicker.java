
package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import main.colors.*;

public class ColorPicker extends JPanel {
    public ColorPicker() {
        setLayout(new FlowLayout());

        JButton whiteButton= new JButton("Белый");
        JButton blackButton = new JButton("Черный");
        JButton redButton = new JButton("Красный");
        JButton blueButton = new JButton("Синий");
        JButton greenButton = new JButton("Зеленый");

        whiteButton.addActionListener(e->changeColor(e,new WhiteColorStrategy()));
        blackButton.addActionListener(e -> changeColor(e, new BlackColorStrategy()));
        redButton.addActionListener(e -> changeColor(e, new RedColorStrategy()));
        blueButton.addActionListener(e -> changeColor(e, new BlueColorStrategy()));
        greenButton.addActionListener(e -> changeColor(e, new GreenColorStrategy()));

        add(whiteButton);
        add(blackButton);
        add(redButton);
        add(blueButton);
        add(greenButton);
    }

    private void changeColor(ActionEvent e, ColorStrategy strategy) {
        ColorManager.getInstance().setColor(strategy.getColor());
    }
}
