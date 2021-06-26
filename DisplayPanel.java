import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class DisplayPanel extends JPanel implements Runnable, MouseListener
{
    Field f = new Field();
    AtomicBoolean active = new AtomicBoolean(false);

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        for(int i = 0; i < f.getGrid().length; i++)
        {
            for (int j = 0; j < f.getGrid().length; j++)
                if (f.getGrid()[i][j] == 1)
                    g.fillRect(i * 10, j * 10, 10, 10);
        }
    }

    public void run()
    {
        try
        {
//            System.out.println("Start");
            while (active.get()) {
                    Thread.sleep(250);
                    f.action();
                    repaint();
                }
        }
        catch(InterruptedException e)
        {
            System.out.println("Interrupted");
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(!active.get())
        {
            int x = e.getX();
            int y = e.getY();
            if(f.getGrid()[x/10][y/10] == 0)
                f.getGrid()[x/10][y/10] = 1;
            else
                f.getGrid()[x/10][y/10] = 0;
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {  }

    @Override
    public void mouseReleased(MouseEvent e) {  }

    @Override
    public void mouseEntered(MouseEvent e) {  }

    @Override
    public void mouseExited(MouseEvent e) {  }

}
