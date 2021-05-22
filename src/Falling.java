import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Falling extends JPanel implements ActionListener {
    private Timer timer = new Timer(1000, this);    //Runs every second
    private int x;
    private int y;
    private boolean[][] blocks = {{false, true, true},     //True = colored
            {true, true, false},     //False = not colored
            {false, false, false}};
    private int blockSize = 30;

    public Falling (int x, int y) {     //Initializes starting position of rectangle
        this.x = x;
        this.y = y;
    }

    public void paintComponent(Graphics g) {    //Painting Rectangle
        super.paintComponent(g);
        //g.setColor(Color.BLUE);
        for (int row = 0; row < blocks.length; row++) {    //Every row
            for (int col = 0; col < blocks[0].length; col++) {     //Every column
                if(blocks[row][col]) {     //Only colors if instructed (true)
                    g.setColor(Color.GREEN);
                    g.fillRect(x + col*blockSize, y + row*blockSize, blockSize, blockSize);   //First two declarations represent position; colors appropriate blocks
                    g.setColor(Color.BLACK);
                    g.drawRect(x + col*blockSize, y + row*blockSize, blockSize, blockSize);     //Grid for block
                }
            }
        }
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
