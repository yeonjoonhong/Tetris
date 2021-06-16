import java.awt.*;
import javax.swing.*;

import static javax.swing.SwingUtilities.invokeLater;

public class Board extends JFrame {
    public static final int ROW = 20;
    public static final int COL = 10;
    public static final int BLOCK_SIZE = 30;

    private boolean[][] board;
    private Picture picture;

    public Board() {
        picture = new Picture();
        board = new boolean[ROW][COL];
    }

    public static void main (String[] args) {
        Board frame = new Board();

        frame.setSize(BLOCK_SIZE*COL + 14,BLOCK_SIZE*ROW + 37);    //Size of the frame
        frame.getContentPane().add(frame.getPicture());
        frame.setResizable(false);      //Can't resize
        frame.setLocationRelativeTo(null);  //Makes the game pop up on the center
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Game will close when I close the tab
        frame.setVisible(true);     //Makes the frame visible
    }

    public Block random (int blockSize) {       //Generates Random Block
        int ran = (int)(Math.random()*7);
        int randomX = (int)(Math.random()*7)*30;
        Block random;

        if (ran == 0) {
            random = new IBlock(randomX, 0, blockSize);
        }
        else if (ran == 1) {
            random = new JBlock(randomX, 0, blockSize);
        }
        else if (ran == 2) {
            random = new LBlock(randomX, 0, blockSize);
        }
        else if (ran == 3) {
            random = new OBlock(randomX, 0, blockSize);
        }
        else if (ran == 4) {
            random = new SBlock(randomX, 0, blockSize);
        }
        else if (ran == 5) {
            random = new TBlock(randomX, 0, blockSize);
        }
        else {
            random = new ZBlock(randomX, 0, blockSize);
        }
        return random;
    }

    public Picture getPicture() {
        return picture;
    }

    private class Picture extends JPanel {      //This is the empty board (JPanel)
        @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g);
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    if (!board[row][col]) {
                        g.setColor(Color.BLACK);
                        g.fillRect(col*BLOCK_SIZE,row*BLOCK_SIZE,BLOCK_SIZE,BLOCK_SIZE);
                        g.setColor(Color.DARK_GRAY);
                        g.drawRect(col*BLOCK_SIZE,row*BLOCK_SIZE,BLOCK_SIZE,BLOCK_SIZE);
                    }
                }
            }
        }
    }
}
