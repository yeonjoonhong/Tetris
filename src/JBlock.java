import java.awt.*;
import javax.swing.*;

public class JBlock extends JPanel {
    private boolean[][] jBlocks = {{true, false, false},        //True = blocks that are colored
                                   {true, true, true},          //False = blocks that are NOT colored
                                   {false, false, false}};
    private int blockSize;
    private int x;
    public JBlock (int x, int blockSize) {
        this.blockSize = blockSize;
        this.x = x;     //Initial x position
    }
    @Override
    public void paintComponent(Graphics g) {        //Drawing the J block
        super.paintComponent(g);
        for (int row = 0; row < jBlocks.length; row++) {    //Every Row
            for (int col = 0; col < jBlocks[0].length; col++) {     //Every Column
                if(jBlocks[row][col]) {     //Colors only when the value is true
                    g.setColor(Color.BLUE);     //Color
                    g.fillRect(x + col*blockSize, row*blockSize, blockSize, blockSize);     //Draws and fills in rectangle
                    g.setColor(Color.BLACK);
                    g.drawRect(x + col*blockSize, row*blockSize, blockSize, blockSize);     //Grid for the blocks
                }
            }
        }
    }
}
