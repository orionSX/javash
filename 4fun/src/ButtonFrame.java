import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonFrame extends JFrame implements ActionListener {

    private JPanel panel;

    public ButtonFrame() {
        setTitle("Task for Today");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panel = new JPanel();
        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        JButton yellowButton1 = new JButton("Yellow");
        JButton blueButton1 = new JButton("Blue");
        JButton redButton1 = new JButton("Red");

        yellowButton1.addActionListener(new ColorAction(Color.YELLOW, panel));
        blueButton1.addActionListener(new ColorAction(Color.BLUE, panel));
        redButton1.addActionListener(new ColorAction(Color.RED, panel));

        buttonPanel.add(yellowButton1);
        buttonPanel.add(blueButton1);
        buttonPanel.add(redButton1);

        JButton yellowButton2 = new JButton("Yellow");
        JButton blueButton2 = new JButton("Blue");
        JButton redButton2 = new JButton("Red");

        yellowButton2.addActionListener(this);
        blueButton2.addActionListener(this);
        redButton2.addActionListener(this);

        buttonPanel.add(yellowButton2);
        buttonPanel.add(blueButton2);
        buttonPanel.add(redButton2);

        JButton yellowButton3 = new JButton("Yellow");
        JButton blueButton3 = new JButton("Blue");
        JButton redButton3 = new JButton("Red");

        yellowButton3.addActionListener(new ColorActionInner(Color.YELLOW));
        blueButton3.addActionListener(new ColorActionInner(Color.BLUE));
        redButton3.addActionListener(new ColorActionInner(Color.RED));

        buttonPanel.add(yellowButton3);
        buttonPanel.add(blueButton3);
        buttonPanel.add(redButton3);

        JButton yellowButton4 = new JButton("Yellow");
        JButton blueButton4 = new JButton("Blue");
        JButton redButton4 = new JButton("Red");

        yellowButton4.addActionListener(e -> panel.setBackground(Color.YELLOW));
        blueButton4.addActionListener(e -> panel.setBackground(Color.BLUE));
        redButton4.addActionListener(e -> panel.setBackground(Color.RED));

        buttonPanel.add(yellowButton4);
        buttonPanel.add(blueButton4);
        buttonPanel.add(redButton4);

        JButton xButton = new JButton("X");
        xButton.setFont(new Font("Arial", Font.BOLD, 24)); 
        xButton.setForeground(Color.WHITE);
        xButton.setBackground(Color.RED);
        xButton.setPreferredSize(new Dimension(60, 60));

        xButton.addActionListener(e -> {
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });

        buttonPanel.add(xButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Окно закрывается...");
            }
        });
    }


    private class ColorActionInner implements ActionListener {
        private  Color color;

        public ColorActionInner(Color color) {
            this.color = color;
        }

        public void actionPerformed(ActionEvent e) {
            panel.setBackground(color);
        }
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Yellow")) {
            panel.setBackground(Color.YELLOW);
        } else if (command.equals("Blue")) {
            panel.setBackground(Color.BLUE);
        } else if (command.equals("Red")) {
            panel.setBackground(Color.RED);
        }
    }
}
