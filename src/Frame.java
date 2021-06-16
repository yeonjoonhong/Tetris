import java.awt.*;
import javax.swing.*;

public class Frame extends JComponent {
    public static final int BLOCK_SIZE = 30;
    private boolean[][] board = new boolean[20][10];

    public Frame() {
        IBlock random = new IBlock(30, 30, 30);
        add(random);
    }

    @Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (!board[row][col]) {
                    g.setColor(Color.WHITE);
                    g.fillRect(col*BLOCK_SIZE,row*BLOCK_SIZE,BLOCK_SIZE,BLOCK_SIZE);
                    g.setColor(Color.DARK_GRAY);
                    g.drawRect(col*BLOCK_SIZE,row*BLOCK_SIZE,BLOCK_SIZE,BLOCK_SIZE);
                }
            }
        }
    }
}