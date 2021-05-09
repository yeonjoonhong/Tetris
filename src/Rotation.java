import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static javax.swing.SwingUtilities.invokeLater;

public class Rotation extends JFrame implements KeyListener{

    private int x = 200;
    private int y = 10; //coordinates for top left point

    private int originalHeight = 50;
    private int originalWidth =30;
    private int height = 50;
    private int width = 30;

    private int stage = 1;

    private RotationLogic rotationLogic;

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
                frame.setSize(500, 500);
                frame.setMinimumSize(new Dimension(500, 500));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.getContentPane().add(frame.rotationLogic);
                frame.pack();
                frame.setVisible(true);

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
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            rotate();
            Rotation.this.repaint();
        }
    }

    private class RotationLogic extends JComponent {

        @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.drawRect(x, y, width, height);
            g.fillRect(x, y, width,height);

        }
    }
}