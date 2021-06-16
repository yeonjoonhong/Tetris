import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Falling extends JPanel implements ActionListener {
    private Timer timer = new Timer(1000, this);    //Runs every second
    private int x;
    private int y = 0;
    private boolean[][] blocks = {{false, true, true},     //True = colored
            {true, true, false},     //False = not colored
            {false, false, false}};
    private int blockSize = 30;
    private JBlock jblock;

    public Falling (int x) {     //Initializes starting position of rectangle
        this.x = x;
    }

    public void paintComponent(Graphics g) {    //Painting Rectangle
        super.paintComponent(g);
        //g.setColor(Color.BLUE);
        jblock = new JBlock(x, y, blockSize);
        jblock.paintComponent(g);
        //g.fillRect(x,y,30,30);      //Original Rectangle at position (x,y)
        timer.start();          //Timer begins
    }

    public void actionPerformed(ActionEvent e) {    //Timer calls this method every second
        if (y < 540) {      //Rectangle stops falling when it reaches the bottom
            y += 30;        //Falling Logic
        }
        repaint();      //Refresh and Repaint
    }

    public static void main(String[] args) {
        Falling fall = new Falling(100);
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
