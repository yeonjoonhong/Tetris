import java.awt.*;
import javax.swing.*;

public class Board {
    private int block = 30;
    private int boardWidth = 10;
    private int boardHeight = 20;

    public Board() {
        JFrame frame = new JFrame("Tetris Game") {   //Name of the Frame
            @Override public void paint (Graphics g) {    //Grid Lines
                super.paint(g);
                for (int i = 0; i<= boardHeight + 1; i++) {     //Horizontal Lines
                    g.drawLine(0,block*i,boardWidth*block + 5,block*i);
                    g.setColor(new Color(51,51,51));    //Color of lines
                }
                for (int j = 0; j<= boardWidth; j++) {      //Vertical Lines
                    g.drawLine(block*j + 5,0,block*j + 5,boardHeight*block + 30);
                    g.setColor(new Color(51,51,51));
                }
            }
        };

        //Empty Board
        frame.setSize(313,638);    //Size of the frame
        frame.getContentPane().setBackground(Color.BLACK);   //Color of background
        frame.setResizable(false);      //Can't resize
        frame.setLocationRelativeTo(null);  //Makes the game pop up on the center
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Game will close when I close the tab
        frame.setVisible(true);     //Makes the frame visible
    }

    public static void main (String[] args) {   //Main method
        Board b = new Board();
    }
}
