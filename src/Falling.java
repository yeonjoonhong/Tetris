import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Falling extends JPanel implements ActionListener {
    private Timer timer = new Timer(1000, this);    //Runs every second
    private int x;
    private int y;

    public Falling (int x, int y) {     //Initializes starting position of rectangle
        this.x = x;
        this.y = y;
    }

    public void paintComponent(Graphics g) {    //Painting Rectangle
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(x,y,30,30);      //Original Rectangle at position (x,y)
        timer.start();          //Timer begins
    }

    public void actionPerformed(ActionEvent e) {    //Timer calls this method every second
        if (y < 570) {      //Rectangle stops falling when it reaches the bottom
            y += 30;        //Falling Logic
        }
        repaint();      //Refresh and Repaint
    }

    public static void main(String[] args) {
        Falling fall = new Falling(100,0);
        JFrame frame = new JFrame();
        frame.add(fall);        //Adds falling logic to JFrame
        frame.setSize(313, 638);
        frame.setTitle("Tetris Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
