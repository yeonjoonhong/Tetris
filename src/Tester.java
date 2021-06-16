import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Tester extends JFrame {
    public Tester () {
        Board board = new Board();
        Rotation frame = new Rotation(board.random(30));    // board.random(Block b) is a method that generates a random Block object
        this.add(frame);
    }
    public static void main(String args[]) {
        Tester frame = new Tester();
        frame.setTitle("Tetris");
        frame.setSize(314, 637);
        frame.setMinimumSize(new Dimension(314, 637));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
}