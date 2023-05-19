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
    private int timesToRun;
    private int[][] board;

    public Conway(int boardSize, int timesToRun){
        this.boardSize = boardSize;
        this.timesToRun = timesToRun;
        board = new int[boardSize][boardSize];
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
                    temp = temp + "#";
                } else {
                    temp = temp + "O"; // dead
                }
            }
            System.out.println(temp);
        }
        System.out.println("---------------");
    }

    public int neighbourChecker(int row, int col){ // int and col of the selected cell
        int aliveSum = 0;
        for(int r = row - 1; r <= row + 1
        && row > 0
        && row < board.length - 1
        ; r++){
            for(int c = col - 1; c <= col + 1
            && col > 0
            && col < board[0].length - 1
            ; c++){
                aliveSum += board[r][c];
            }
        }
        return aliveSum;
        // TODO: edge cases (ie the sides of the board, top of the board, etc)
    }

    public void run(){
        for (int runs = timesToRun; runs > 0; runs--) { // counts down the times we run this
            int[][] tempBoard = new int[boardSize][boardSize]; // creates dummy board

            for(int row = 0; row < board.length; row++){ // iterate through 2D board
                for(int col = 0; col < board[0].length; col++){
                    // 1. Any live cell with two or three live neighbours survives.
                    if (board[row][col] == 1 && (neighbourChecker(row, col) == 2 || neighbourChecker(row, col) == 3)) { 
                        tempBoard[row][col] = 1;
                    } 
                    // 2. Any dead cell with three live neighbours becomes a live cell.
                    else if (board[row][col] == 0 && neighbourChecker(row, col) == 3){ 
                        tempBoard[row][col] = 1;
                    } 
                    // 3. All other live cells die in the next generation. Similarly, all other dead cells stay dead.
                    else { 
                        tempBoard[row][col] = 0;
                    }
                }
            }

            board = tempBoard; // sets the real board to the dummy board
            printBoard();
        }
    }
}