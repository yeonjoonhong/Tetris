import java.awt.*;
import javax.swing.*;

public class LBlock extends JPanel {
    private boolean[][] lBlocks = {{false, false, true},     //True = colored
                                   {true, true, true},     //False = not colored
                                   {false, false, false}};
    private int blockSize;
    private int x;
    public LBlock (int x, int blockSize) {
        this.blockSize = blockSize;
        this.x = x;     //Initial x position
    }
    @Override
    public void paintComponent(Graphics g) {        //Drawing L block
        super.paintComponent(g);
        for (int row = 0; row < lBlocks.length; row++) {    //Every row
            for (int col = 0; col < lBlocks[0].length; col++) {     //Every column
                if(lBlocks[row][col]) {     //Only colors if instructed (true)
                    g.setColor(Color.GRAY);
                    g.fillRect(x + col*blockSize, row*blockSize, blockSize, blockSize);   //First two declarations represent position; colors appropriate blocks
                    g.setColor(Color.BLACK);
                    g.drawRect(x + col*blockSize, row*blockSize, blockSize, blockSize);     //Grid for block
                }
            }
        }
    }
}
