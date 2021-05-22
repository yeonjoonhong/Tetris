import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Tester extends JFrame {
    public Tester() {
        //this.add(new JBlock(100,30));
        //this.add(new TBlock(0, 30));
        //this.add(new ZBlock(200, 30));
        //this.add(new IBlock(150, 30));
        //this.add(new LBlock(100,30));
        //this.add(new OBlock(50, 30));
        this.add(new SBlock(80,30));
    }
    public static void main(String args[]) {
        Falling fall = new Falling(100,0);
        Tester test = new Tester();
        test.add(fall);
        test.setSize(318,638);
        test.setVisible(true);
        test.setDefaultCloseOperation(EXIT_ON_CLOSE);
        test.setResizable(false);
        test.setLocationRelativeTo(null);
    }
}