import java.awt.*;
import javax.swing.*;

public class TBlock extends Block {
    private boolean[][] tBlocks = {{false, true, false},     //True = colored
                                   {true, true, true},     //False = not colored
                                   {false, false, false}};
    public TBlock (int x, int y, int blockSize) {
        super(x, y, blockSize);
    }

    @Override
    public void paintComponent(Graphics g) {        //Drawing S block
        super.paintComponent(g);
        for (int row = 0; row < tBlocks.length; row++) {    //Every row
            for (int col = 0; col < tBlocks[0].length; col++) {     //Every column
                if(tBlocks[row][col]) {     //Only colors if instructed (true)
                    g.setColor(Color.GREEN);
                    g.fillRect(getX() + col*getBlockSize(), getY() + row*getBlockSize(), getBlockSize(), getBlockSize());   //First two declarations represent position; colors appropriate blocks
                    g.setColor(Color.BLACK);
                    g.drawRect(getX() + col*getBlockSize(), getY() + row*getBlockSize(), getBlockSize(), getBlockSize());     //Grid for block
                }
            }
        }
    }

    public boolean[][] getBlocks() {
        return tBlocks;
    }
    public void setBlocks (boolean[][] frame) {
        tBlocks = frame;
    }
}

