import java.awt.*;
import javax.swing.*;

public class SBlock extends JPanel {
    private boolean[][] sBlocks = {{false, true, true},     //True = colored
                                   {true, true, false},     //False = not colored
                                   {false, false, false}};
    private int blockSize;
    private int x;
    public SBlock (int x, int blockSize) {
        this.blockSize = blockSize;
        this.x = x;     //Initial x position
    }
    @Override
    public void paintComponent(Graphics g) {        //Drawing S block
        super.paintComponent(g);
        for (int row = 0; row < sBlocks.length; row++) {    //Every row
            for (int col = 0; col < sBlocks[0].length; col++) {     //Every column
                if(sBlocks[row][col]) {     //Only colors if instructed (true)
                    g.setColor(Color.GREEN);
                    g.fillRect(x + col*blockSize, row*blockSize, blockSize, blockSize);   //First two declarations represent position; colors appropriate blocks
                    g.setColor(Color.BLACK);
                    g.drawRect(x + col*blockSize, row*blockSize, blockSize, blockSize);     //Grid for block
                }
            }
        }
    }
}
