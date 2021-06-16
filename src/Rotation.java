import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class Rotation extends JPanel implements KeyListener, ActionListener {   //Manipulate Block

    private int x;
    private int y;

    private int blockSize;

    private Block block;
    private boolean[][] blockArray;

    private boolean atBottom = false;

    private Timer timer = new Timer(1000, this);    //Runs every second

    public Rotation (Block newBlock) {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        block = newBlock;
        blockSize = block.getBlockSize();
        blockArray = block.getBlocks();
        x = block.getX();
        y = block.getY();
    }

    public void rotate() {      //Rotation Logic
        int numRows = blockArray.length;

        boolean[][] changeBlock = new boolean[numRows][numRows];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numRows; col++) {
                changeBlock[col][numRows - 1 - row] = blockArray[row][col];     //Formula for rotating a 2D array clockwise
            }
        }
        blockArray = changeBlock;

        block.setBlocks(blockArray);   //Applies changed template to the block
    }

    @Override
    public void actionPerformed(ActionEvent e) {    //Timer calls this method every second: Falling Logic
        y += blockSize;     //Block falls 30 spaces every second
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
        if (keyEvent.getKeyCode() == KeyEvent.VK_UP && !atBottom && !(block instanceof OBlock)) {     //Up Arrow = Rotate block
            rotate();
            Rotation.this.repaint();
        }

        //Translation Logic
        else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {       //Left Arrow = Move left
            x -= blockSize;
            Rotation.this.repaint();
        }
        else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {      //Right Arrow = Move right
            x += blockSize;
            Rotation.this.repaint();
        }
        else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN && !atBottom) {      //Down Arrow = Move down
            y += blockSize;
            Rotation.this.repaint();
        }
    }

    @Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);

        block.setX(x);
        block.setY(y);
        block.paintComponent(g);
        timer.start();          //Timer begins
    }
}