import java.awt.*;
import javax.swing.*;

public class SBlock extends Block {
    private boolean[][] sBlocks = {{false, true, true},     //True = colored
                                   {true, true, false},     //False = not colored
                                   {false, false, false}};
    public SBlock (int x, int y, int blockSize) {
        super(x, y, blockSize);
    }

    @Override
    public void paintComponent(Graphics g) {        //Drawing S block
        super.paintComponent(g);
        for (int row = 0; row < sBlocks.length; row++) {    //Every row
            for (int col = 0; col < sBlocks[0].length; col++) {     //Every column
                if(sBlocks[row][col]) {     //Only colors if instructed (true)
                    g.setColor(Color.GREEN);
                    g.fillRect(getX() + col*getBlockSize(), getY() + row*getBlockSize(), getBlockSize(), getBlockSize());   //First two declarations represent position; colors appropriate blocks
                    g.setColor(Color.BLACK);
                    g.drawRect(getX() + col*getBlockSize(), getY() + row*getBlockSize(), getBlockSize(), getBlockSize());     //Grid for block
                }
            }
        }
    }

    public boolean[][] getBlocks() {
        return sBlocks;
    }
    public void setBlocks (boolean[][] frame) {
        sBlocks = frame;
    }
}
