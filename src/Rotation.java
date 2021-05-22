import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static javax.swing.SwingUtilities.invokeLater;

public class Rotation extends JFrame implements KeyListener, ActionListener { //Rotation And Falling Logic

    private int x = 200;
    private int y = 0; //coordinates for top left point

    private int originalHeight = 60;
    private int originalWidth =30;
    private int height = 60;
    private int width = 30;

    private int stage = 1;

    private RotationLogic rotationLogic;

    private boolean atBottom = false;

    private Timer timer = new Timer(1000, this);    //Runs every second

    public Rotation() {
        rotationLogic = new RotationLogic();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }

    public static void main(String[] args){
        invokeLater(new Runnable() {
            public void run() {
                Rotation frame = new Rotation();
                frame.setTitle("Tetris");
                frame.setSize(500, 638);
                frame.setMinimumSize(new Dimension(500, 638));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.getContentPane().add(frame.rotationLogic);
                frame.pack();
                frame.setVisible(true);
                frame.setResizable(false);

            }
        });
    }

    public void rotate() {
        int temp = height;
        height = width;
        width = temp;

        if (stage == 1) {
            y += originalHeight / 2;
        } else if (stage == 2) {
        } else if (stage == 3) {
            x -= originalHeight / 2;
        } else if (stage == 4) {
            x += originalHeight / 2;
            y -= originalHeight / 2;
        }

        if (stage % 4 == 0) {
            stage = 1;
        } else {
            stage++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {    //Timer calls this method every second
        if (y < 540) {      //Rectangle stops falling when it reaches the bottom
            y += 30;        //Falling Logic
        }
        else if ((stage == 2 || stage == 4) && y < 540 + originalHeight/2) {    //If stage is 2 or 4, rectangle drops more due to size
            y += originalHeight / 2;
            atBottom = true;    //Block reached bottom --> no more rotation allowed
        }
        else {  //Blocks at stage 1 or 3
            atBottom = true;    //Block reached bottom --> no more rotation allowed
        }
        repaint();      //Refresh and Repaint
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_UP && !atBottom) {     //Added: stops rotating when block reaches bottom
            rotate();
            Rotation.this.repaint();
        }
    }

    private class RotationLogic extends JComponent {

        @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g);
            g.setColor(Color.GREEN);
            g.fillRect(x, y, width,height);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, width, height);
            timer.start();          //Timer begins
        }
    }
}