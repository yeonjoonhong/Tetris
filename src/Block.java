import java.awt.*;
import javax.swing.*;

public class Block extends JApplet{
    private int x = 100;
    private int y = 100;

    Block(){
        JFrame frame = new JFrame() {
            @Override public void paint(Graphics g) {
                g.drawRect(x, y, 30, 30);
            }
        };

        frame.setSize(300, 400);
        frame.setTitle("Tetris Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Block m = new Block();

    }


}
