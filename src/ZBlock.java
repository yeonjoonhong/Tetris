import java.awt.*;
import javax.swing.*;

public class ZBlock extends Block {
    private boolean[][] zBlocks = {{true, true, false},     //True = colored
                                   {false, true, true},     //False = not colored
                                   {false, false, false}};
    public ZBlock (int x, int y, int blockSize) {
        super(x, y, blockSize);
    }

    @Override
    public void paintComponent(Graphics g) {        //Drawing S block
        super.paintComponent(g);
        for (int row = 0; row < zBlocks.length; row++) {    //Every row
            for (int col = 0; col < zBlocks[0].length; col++) {     //Every column
                if(zBlocks[row][col]) {     //Only colors if instructed (true)
                    g.setColor(Color.GREEN);
                    g.fillRect(getX() + col*getBlockSize(), getY() + row*getBlockSize(), getBlockSize(), getBlockSize());   //First two declarations represent position; colors appropriate blocks
                    g.setColor(Color.BLACK);
                    g.drawRect(getX() + col*getBlockSize(), getY() + row*getBlockSize(), getBlockSize(), getBlockSize());     //Grid for block
                }
            }
        }
    }

    public boolean[][] getBlocks() {
        return zBlocks;
    }
    public void setBlocks (boolean[][] frame) {
        zBlocks = frame;
    }
}

