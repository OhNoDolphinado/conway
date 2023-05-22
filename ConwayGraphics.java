import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ConwayGraphics extends JPanel implements MouseListener{

    int mouseClickY = -1;
    int mouseClickX = -1;

    int squareSize = 10; // this sets the size of the square (and what everything multiplies by)

    int[][] board;

    ConwayGraphics(int[][] board){
        this.board = board;
        JFrame myFrame = new JFrame();      
        myFrame.setSize(board.length*squareSize, board.length*squareSize); // sets window size to approx. board size
        myFrame.add(this);
        myFrame.setVisible(true);
      
        // addMouseListener (this);
    }

    public void paintComponent (Graphics gp){ // where do we call this??
        // read the 2d array board and paint it
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) { // iterate through board values
                if (board[row][col] == 1){ // determine color to paint board based on value (alive or dead)
                    gp.setColor(Color.white);
                } else {
                    gp.setColor(Color.black);
                }
                gp.fillRect(col*squareSize, row*squareSize, (row+1)*squareSize, (col+1)*squareSize); 
                // paint the rectangle at the current position (10px by 10px squares)
            }
        }
    }

    public void mouseClicked (MouseEvent event) { // set cell to alive or dead
        // get x and y from mouse and put it into mouseClick variables
        mouseClickX = event.getX()*squareSize;
        mouseClickY = event.getY()*squareSize;
        repaint();
    }
  
    public void mouseReleased (MouseEvent event) { // nothing
    }
    public void mousePressed (MouseEvent event) { // nothing
    }
    public void mouseEntered (MouseEvent event) { // nothing
    }
    public void mouseExited (MouseEvent event) { // nothing
    }
    public void mouseMoved(MouseEvent event) { // nothing
    }
}
