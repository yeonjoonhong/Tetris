import java.awt.*;
import javax.swing.*;

public class TBlock extends JPanel {
    private boolean[][] tBlocks = {{false, true, false},    //True = block is colored
                                   {true, true, true},      //False = block is not colored
                                   {false, false, false}};
    private int blockSize;
    private int x;
    public TBlock (int x, int blockSize) {
        this.blockSize = blockSize;     //Size of one block
        this.x = x;     //Initial x position
    }
    @Override
    public void paintComponent(Graphics g) {    //Drawing the T block
        super.paintComponent(g);
        for (int row = 0; row < tBlocks.length; row++) {    //Every row
            for (int col = 0; col < tBlocks[0].length; col++) {     //Every column
                if(tBlocks[row][col]) {     //Only draws if it is instructed (true)
                    g.setColor(Color.RED);      //Color
                    g.fillRect(x + col*blockSize, row*blockSize, blockSize, blockSize);     //Fills in the block
                    g.setColor(Color.BLACK);
                    g.drawRect(x + col*blockSize, row*blockSize, blockSize, blockSize);     //Grid for block
                }
            }
        }
    }
}
