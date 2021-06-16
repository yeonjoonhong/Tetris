import java.awt.*;
import javax.swing.*;

public class OBlock extends Block {
    private boolean[][] oBlocks = {{false, true, true, false},     //True = colored
                                   {false, true, true, false},     //False = not colored
                                   {false, false, false, false}};
    public OBlock (int x, int y, int blockSize) {
        super(x, y, blockSize);
    }

    @Override
    public void paintComponent(Graphics g) {        //Drawing S block
        super.paintComponent(g);
        for (int row = 0; row < oBlocks.length; row++) {    //Every row
            for (int col = 0; col < oBlocks[0].length; col++) {     //Every column
                if(oBlocks[row][col]) {     //Only colors if instructed (true)
                    g.setColor(Color.GREEN);
                    g.fillRect(getX() + col*getBlockSize(), getY() + row*getBlockSize(), getBlockSize(), getBlockSize());   //First two declarations represent position; colors appropriate blocks
                    g.setColor(Color.BLACK);
                    g.drawRect(getX() + col*getBlockSize(), getY() + row*getBlockSize(), getBlockSize(), getBlockSize());     //Grid for block
                }
            }
        }
    }

    public boolean[][] getBlocks() {
        return oBlocks;
    }
    public void setBlocks (boolean[][] frame) {
        oBlocks = frame;
    }
}

