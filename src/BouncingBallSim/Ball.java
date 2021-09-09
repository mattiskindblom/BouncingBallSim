package BouncingBallSim;

import java.awt.Color;
        import java.awt.Graphics;
        import javax.swing.*;


public class Ball extends JPanel{
    int x=0;
    int y=0;
    int x_velocity=0;
    int y_velocity=5;
    double gravity= 9.82;
    Color rand=Color.blue;
    Boolean is_moving_down=true;
    public static void main(String [] args)
    {
        Ball b = new Ball();
        JFrame f=new JFrame();
        f.add(b);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(1366,768);
        f.setVisible(true);
        while(b.x<1366)
        {
            try
            {
                Thread.sleep(100);
            }
            catch(Exception ignored)
            {

            }
            b.move_it();
            f.repaint();
        }
    }
    void move_it()
    {
        int b=(int)(Math.random()*255);
        int g=(int)(Math.random()*255);
        int r=(int)(Math.random()*255);
        x+=x_velocity;
        if(is_moving_down)
        {
            if(y<690)
                y_velocity+=gravity;
            else 
            {
                FlowCollision(b, g, r);
            }
        }
        else
        {
            if(y_velocity>0)
            {
                y_velocity-=gravity;
            }
            else 
                is_moving_down=true;
        }
        y+=y_velocity;
    }

    private void FlowCollision(int b, int g, int r) {
        rand=new Color(r, b, g);
        y_velocity*=-0.85;
        is_moving_down=false;
    }

    public void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(rand);
        g.fillOval(x, y, 60, 60);
    }
}