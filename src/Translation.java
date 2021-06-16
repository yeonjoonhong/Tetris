import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static javax.swing.SwingUtilities.invokeLater;

public class Translation extends JFrame implements KeyListener {

    private int x = 200;
    private int y = 10; //coordinates for top left point

    private int originalHeight = 50;
    private int originalWidth =30;
    private int height = 50;
    private int width = 30;

    private int stage = 1;

    private TranslationLogic translationLogic;

    public Translation() {
        translationLogic = new TranslationLogic();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }

    public static void main(String[] args){
        invokeLater(new Runnable() {
            public void run() {
                Translation frame = new Translation();
                frame.setTitle("Tetris");
                frame.setSize(500, 500);
                frame.setMinimumSize(new Dimension(500, 500));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.getContentPane().add(frame.translationLogic);
                frame.pack();
                frame.setVisible(true);

            }
        });
    }

    public void translationLeft() {
        x -= width;

    }

    public void translationRight() {
        x += width;

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            translationLeft();
            Translation.this.repaint();
        }
        else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            translationRight();
            Translation.this.repaint();
        }

    }

    private class TranslationLogic extends JComponent {

        @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.drawRect(x, y, width, height);
            g.fillRect(x, y, width,height);

        }
    }
}