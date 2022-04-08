import java.util.Scanner;

/**
 * This class is the board class for board games like TTT and OAC.
 */
public class Board {
    private int size;
    private int rowSize;
    private int colSize;
    private BoardCell[][] gameBoard;

    public Board() {
        size = getInputSize();
        rowSize = colSize = size;
        gameBoard = new BoardCell[size][size];
        initBoard();
    }

    public Board(int size) {
        this.size = size;
        rowSize = colSize = size;
        gameBoard = new BoardCell[rowSize][colSize];
        initBoard();
    }

    public Board(int rowSize, int colSize) {
        this.rowSize = rowSize;
        this.colSize = colSize;
        gameBoard = new BoardCell[rowSize][colSize];
        initBoard();
    }

    public void initBoard(){
        for (int i = 0; i < rowSize; i++) {
           for(int j = 0; j < colSize; j++)
               gameBoard[i][j] = new BoardCell();
        }
    }

    public void printBoard(){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i<rowSize; i++){
            s.append("+-".repeat(colSize) + "+\n");
            for(int j = 0; j<colSize; j++) {
                s.append("|");
                s.append(gameBoard[i][j].getChecker());
            }
            s.append("|\n");
        }
        s.append("+-".repeat(colSize)+"+");
        System.out.println(s);
    }

    public int getInputSize(){
        System.out.print("Please enter the size of the board(>=3): ");
        int size = GameCenter.getNumeric();
        while(size<3){
            System.out.print("Please enter a valid number: ");
            size = GameCenter.getNumeric();
        }
        return size;
    }

    public BoardCell getCell(int row, int col){
        return gameBoard[row][col];
    }

    public int getSize() {
        return size;
    }
}