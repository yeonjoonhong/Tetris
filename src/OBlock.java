import java.awt.*;
import javax.swing.*;

public class OBlock extends JPanel {
    private boolean[][] oBlocks = {{false, true, true, false},     //True = colored
                                   {false, true, true, false},     //False = not colored
                                   {false, false, false, false}};
    private int blockSize;
    private int x;
    public OBlock (int x, int blockSize) {
        this.blockSize = blockSize;
        this.x = x;     //Initial x position
    }
    @Override
    public void paintComponent(Graphics g) {        //Drawing O block
        super.paintComponent(g);
        for (int row = 0; row < oBlocks.length; row++) {    //Every row
            for (int col = 0; col < oBlocks[0].length; col++) {     //Every column
                if(oBlocks[row][col]) {     //Only colors if instructed (true)
                    g.setColor(Color.ORANGE);
                    g.fillRect(x + col*blockSize, row*blockSize, blockSize, blockSize);   //First two declarations represent position; colors appropriate blocks
                    g.setColor(Color.BLACK);
                    g.drawRect(x + col*blockSize, row*blockSize, blockSize, blockSize);     //Grid for block
                }
            }
        }
    }
}
