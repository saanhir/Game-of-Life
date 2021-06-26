import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FieldGUI
{
    JFrame frame;
    DisplayPanel mainPanel = new DisplayPanel();
    JButton button;


    public FieldGUI()
    {
        display();
    }

    public void display()
    {
        frame = new JFrame("Game of Life");
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setResizable(false);

        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBounds(0, 0, 500, 500);
        mainPanel.addMouseListener(mainPanel);

        button = new JButton("Start");
        button.setBounds(500, 0, 100, 20);
        button.addActionListener(new ActivationListener());

        frame.getContentPane().add(mainPanel);
        frame.getContentPane().add(button);

    }


    private class ActivationListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Thread t = new Thread(mainPanel);
            if(!mainPanel.active.get())
            {
                t.start();
                mainPanel.active.set(true);
                button.setText("Stop");
            }
            else
            {
                mainPanel.active.set(false);
                button.setText("Start");
            }
        }
    }


    public static void main(String[] args)
    {
        FieldGUI fg = new FieldGUI();
    }

}
