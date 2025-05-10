package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingPanel extends JPanel implements Observer {
    private Color penColor;
    private int prevX, prevY; 
    private boolean drawing; 

    public DrawingPanel() {
        penColor = Color.BLACK;
        ColorManager.getInstance().attach(this);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) { 
                    prevX = e.getX();
                    prevY = e.getY();
                    drawing = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    drawing = false;
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (drawing) {
                    Graphics2D g = (Graphics2D) getGraphics();
                    g.setColor(penColor);
                    g.setStroke(new BasicStroke(4)); 
                    g.drawLine(prevX, prevY, e.getX(), e.getY()); 

                    prevX = e.getX();
                    prevY = e.getY();
                }
            }
        });
    }

    @Override
    public void update(Color newColor) {
        this.penColor = newColor;
    }
}
