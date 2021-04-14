import java.awt.*;
import javax.swing.*;

public class Block extends JApplet{
    Block(){
        JFrame frame = new JFrame() {
            @Override public void paint(Graphics g) {
                g.drawRect(100, 100, 50, 100);
            }
        };

        frame.setSize(300, 400);
        frame.setTitle("Tetris Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Block m = new Block();

    }


}
