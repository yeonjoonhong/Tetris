import java.awt.*;
import javax.swing.*;

public class IBlock extends JPanel {
    private boolean[][] iBlocks = {{false, false, false, false},     //True = colored
            {true, true, true, true},     //False = not colored
            {false, false, false, false},
            {false, false, false, false}};
    private int blockSize;
    private int x;
    public IBlock (int x, int blockSize) {
        this.blockSize = blockSize;
        this.x = x;     //Initial x position
    }
    @Override
    public void paintComponent(Graphics g) {        //Drawing I block
        super.paintComponent(g);
        for (int row = 0; row < iBlocks.length; row++) {    //Every row
            for (int col = 0; col < iBlocks[0].length; col++) {     //Every column
                if(iBlocks[row][col]) {     //Only colors if instructed (true)
                    g.setColor(Color.pink);
                    g.fillRect(x + col*blockSize, row*blockSize, blockSize, blockSize);   //First two declarations represent position; colors appropriate blocks
                    g.setColor(Color.BLACK);
                    g.drawRect(x + col*blockSize, row*blockSize, blockSize, blockSize);     //Grid for block
                }
            }
        }
    }
}
