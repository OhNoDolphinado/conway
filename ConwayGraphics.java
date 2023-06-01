import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


// TODO: get it to run and update on the screen
// TODO: play and pause -- only change seed when on paused?
// TODO: display play and pause on jpanel

public class ConwayGraphics extends JPanel implements MouseListener, KeyListener {

    int mousePositionOnClickX = -1;
    int mousePositionOnClickY = -1;
    boolean paused = true;
    int squareSize = 15; // this sets the size of the square (and what everything multiplies by)

    Conway c;

    ConwayGraphics(Conway c) {
        this.c = c;

        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        JFrame myFrame = new JFrame();

        myFrame.setSize((c.getBoard().length+1)*squareSize, (c.getBoard().length+2)*squareSize);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);
        myFrame.add(this);
        myFrame.setVisible(true);

    }

    public void printBoard(){
        for(int row = 0; row < c.getBoard().length; row++){
            String temp = "";
            for(int col = 0; col < c.getBoard()[0].length; col++){    
                if (c.getBoard()[row][col] == 1){ // alive
                    temp = temp + "#";
                } else {
                    temp = temp + "O"; // dead
                }
            }
            System.out.println(temp);
        }
        System.out.println("---------------");
    }

    public void paintComponent(Graphics gp) { // read the 2d array board and paint it
        gp.setColor(Color.white);
        gp.fillRect(0, 0, 1000, 1000);

        // printBoard();

        for (int row = 0; row < c.getBoard().length; row++) {
            for (int col = 0; col < c.getBoard()[0].length; col++) { // iterate through board values   

                gp.setColor(Color.white);
                if (c.getBoard()[row][col] == 1) { // determine color to paint board based on value (alive or dead)
                    gp.setColor(Color.magenta);
                }

                gp.fillRect(row * squareSize, col * squareSize, (row + 1) * squareSize, (col + 1) * squareSize);
                // System.out.println("START: " + row*squareSize + " " + col*squareSize);
                // System.out.println("END : " + (row+1)*squareSize + " " + (col+1)*squareSize);
                
                // paint the rectangle at the current position (10px by 10px squares)
            }
        }
    }

    public void mouseClicked(MouseEvent event) { // sets the cell to alive or dead on click
        System.out.println("MOUSE");

        mousePositionOnClickX = Math.floorDiv(event.getX(), squareSize); // get x and y from mouse and put it into mouseClick variables
        mousePositionOnClickY = Math.floorDiv(event.getY(), squareSize);
        System.out.println("X: " + mousePositionOnClickX + " Y: " + mousePositionOnClickY);

        if (c.getBoard()[mousePositionOnClickX][mousePositionOnClickY] == 0) { // change the cell by clicking on it
            c.getBoard()[mousePositionOnClickX][mousePositionOnClickY] = 1;
        } else {
            c.getBoard()[mousePositionOnClickX][mousePositionOnClickY] = 0;
        }

        repaint();
    }

    public void keyPressed(KeyEvent event) { // spacebar for play and pause
        System.out.println("KEYPRESSED");
        if (event.getKeyCode() == KeyEvent.VK_SPACE) {
            paused = !paused;
            System.out.println("The game is paused? " + paused);
        } 
        if (paused == false){
            repaint();
        }
    }

    public boolean isPaused() {
        return paused;
    }

    public void mouseReleased(MouseEvent event) { // nothing
    }

    public void mousePressed(MouseEvent event) { // nothing
    }

    public void mouseEntered(MouseEvent event) { // nothing
    }

    public void mouseExited(MouseEvent event) { // nothing
    }

    public void mouseMoved(MouseEvent event) { // nothing
    }

    public void keyReleased(KeyEvent event) { // nothing
    }

    public void keyTyped(KeyEvent event) { // nothing
    }

}
