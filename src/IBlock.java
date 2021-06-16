import java.awt.*;
import javax.swing.*;

public class IBlock extends Block {
    private boolean[][] iBlocks = {{false, false, false, false},     //True = colored
                                   {true, true, true, true},     //False = not colored
                                   {false, false, false, false},
                                   {false, false, false, false}};
    public IBlock (int x, int y, int blockSize) {
        super(x, y, blockSize);
    }

    @Override
    public void paintComponent(Graphics g) {        //Drawing S block
        super.paintComponent(g);
        for (int row = 0; row < iBlocks.length; row++) {    //Every row
            for (int col = 0; col < iBlocks[0].length; col++) {     //Every column
                if(iBlocks[row][col]) {     //Only colors if instructed (true)
                    g.setColor(Color.GREEN);
                    g.fillRect(getX() + col*getBlockSize(), getY() + row*getBlockSize(), getBlockSize(), getBlockSize());   //First two declarations represent position; colors appropriate blocks
                    g.setColor(Color.BLACK);
                    g.drawRect(getX() + col*getBlockSize(), getY() + row*getBlockSize(), getBlockSize(), getBlockSize());     //Grid for block
                }
            }
        }
    }

    public boolean[][] getBlocks() {
        return iBlocks;
    }
    public void setBlocks (boolean[][] frame) {
        iBlocks = frame;
    }

    public String toString() {
        return "Hello";
    }
}

