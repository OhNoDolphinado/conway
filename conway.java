// 1. initialize the game (takes inputs size, # of times run, and a way to fill cells (ie seed it))-- done
// 2. run the game every time in a while loop, which iterates through and checks each cell (count of live cells in 8 cells around it)
// make sure to write to a temp 2D array 
// 3. print every time it runs
// we need a printer function that converts the 2D array of 1s and 0s to something readable, perhaps with unicode squares (⬛ and ⬜)-- done

// CONWAY'S GAME OF LIFE RULES: 
// 1. Any live cell with two or three live neighbours survives.
// 2. Any dead cell with three live neighbours becomes a live cell.
// 3. All other live cells die in the next generation. Similarly, all other dead cells stay dead.

public class Conway{
    private int boardSize;
    private int timesRun;
    private int[][] board = new int[boardSize][boardSize];

    public Conway(int boardSize, int timesRun){
        this.boardSize = boardSize;
        this.timesRun = timesRun;
    }

    public void startBoard(){
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                board[row][col] = 0;
            }
        }
    }
    
    public void seed(int x, int y){
        board[x][y] = 1;
    }

    public void printBoard(){
        for(int row = 0; row < board.length; row++){
            String temp = "";
            for(int col = 0; col < board[0].length; col++){    
                if (board[row][col] == 1){ // alive
                    temp = temp + " ⬜";
                } else {
                    temp = temp + " ⬛"; // dead
                }
            }
            System.out.println(temp);
        }
    }

    public void play(int runs){

    }

}