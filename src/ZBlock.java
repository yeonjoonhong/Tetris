import java.awt.*;
import javax.swing.*;

public class ZBlock extends JPanel {
    private boolean[][] zBlocks = {{true, true, false},     //True = colored
                                   {false, true, true},     //False = not colored
                                   {false, false, false}};
    private int blockSize;
    private int x;
    public ZBlock (int x, int blockSize) {
        this.blockSize = blockSize;
        this.x = x;     //Initial x position
    }
    @Override
    public void paintComponent(Graphics g) {        //Drawing Z block
        super.paintComponent(g);
        for (int row = 0; row < zBlocks.length; row++) {    //Every row
            for (int col = 0; col < zBlocks[0].length; col++) {     //Every column
                if(zBlocks[row][col]) {     //Only colors if instructed (true)
                    g.setColor(Color.YELLOW);
                    g.fillRect(x + col*blockSize, row*blockSize, blockSize, blockSize);   //First two declarations represent position; colors appropriate blocks
                    g.setColor(Color.BLACK);
                    g.drawRect(x + col*blockSize, row*blockSize, blockSize, blockSize);     //Grid for block
                }
            }
        }
    }
}
