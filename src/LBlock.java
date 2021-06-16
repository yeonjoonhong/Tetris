import java.awt.*;
import javax.swing.*;

public class LBlock extends Block {
    private boolean[][] lBlocks = {{false, false, true},     //True = colored
                                   {true, true, true},     //False = not colored
                                   {false, false, false}};
    public LBlock (int x, int y, int blockSize) {
        super(x, y, blockSize);
    }

    @Override
    public void paintComponent(Graphics g) {        //Drawing S block
        super.paintComponent(g);
        for (int row = 0; row < lBlocks.length; row++) {    //Every row
            for (int col = 0; col < lBlocks[0].length; col++) {     //Every column
                if(lBlocks[row][col]) {     //Only colors if instructed (true)
                    g.setColor(Color.GREEN);
                    g.fillRect(getX() + col*getBlockSize(), getY() + row*getBlockSize(), getBlockSize(), getBlockSize());   //First two declarations represent position; colors appropriate blocks
                    g.setColor(Color.BLACK);
                    g.drawRect(getX() + col*getBlockSize(), getY() + row*getBlockSize(), getBlockSize(), getBlockSize());     //Grid for block
                }
            }
        }
    }

    public boolean[][] getBlocks() {
        return lBlocks;
    }
    public void setBlocks (boolean[][] frame) {
        lBlocks = frame;
    }
}

