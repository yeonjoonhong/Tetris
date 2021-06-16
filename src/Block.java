import java.awt.*;
import javax.swing.*;

public class Block extends JComponent {
    private int blockSize;
    private int x;
    private int y;

    public Block (int x, int y, int blockSize) {
        this.blockSize = blockSize;
        this.x = x;     //Initial x position
        this.y = y;
    }

    @Override
    public void paintComponent(Graphics g) {        //Drawing S block
        super.paintComponent(g);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX (int num) {
        x = num;
    }
    public void setY (int num) {
        y = num;
    }
    public int getBlockSize() {
        return blockSize;
    }

    public boolean[][] getBlocks() {
        boolean[][] placeHolder = new boolean[0][0];
        return placeHolder;
    }
    public void setBlocks (boolean[][] array) {}
}
