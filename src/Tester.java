import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Tester {
    public static void main(String args[]) {
        JFrame frame = new JFrame();
        Falling fall = new Falling(30,30);
        frame.add(fall);
        frame.setVisible(true);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Board board = new Board();
    }
}