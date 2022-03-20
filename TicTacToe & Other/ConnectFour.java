import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class inherits all the attributes from BoardGame class,
 * and specifies features for Connect-4 game
 */
public final class ConnectFour extends BoardGame{
    public static int oWinTime = 0;
    public static int xWinTime = 0;

    public ConnectFour() {
        super(3);
        rowSize = 7;
        colSize = 6;
        size = 4;
        gameBoard = new char[2*rowSize+1][2*colSize+1];
        //gameBoard = new BoardCell[rowSize][colSize];
        positions = Player.positions;
    }

    public void startGame() {

        gameBoard = Board.initBoard(rowSize, colSize);
        Board.printBoard(gameBoard);
        positions.clear();

        System.out.print("Player 1 Enter your checker(y/r): ");
        char checker1 = Checker.getChecker('y', 'r');
        char checker2 = checker1=='r' ? 'y' : 'r';

        while(true) {
            System.out.print("Player 1 Enter your move(1-" + rowSize + "): ");
            int row = getPos();
            move(gameBoard, row, checker1);
            String res = checkWinner(gameBoard, checker1);
            if(res.length()>0) {
                System.out.println(res);
                if(!GameCenter.ifStartNew()){
                    GameCenter.printAllRes();
                    System.exit(0);
                } else GameCenter.start();
            }

            System.out.print("Player 2 Enter your move(1-" + rowSize + "): ");
            row = getPos();
            move(gameBoard, row, checker2);
            res = checkWinner(gameBoard, checker1);
            if(res.length()>0) {
                System.out.println(res);
                if(!GameCenter.ifStartNew()) {
                    GameCenter.printAllRes();
                    System.exit(0);
                } else {
                    GameCenter.start();
                }
            }
        }
    }

    public int getPos(){
        Scanner scan = new Scanner(System.in);
        int row = GameCenter.getNumeric();
        while(positions.contains(rowSize*(colSize-1)+row)) {
            System.out.print("This row is full, please enter a new number: ");
            row = scan.nextInt();
        }
        while(row>rowSize||row<1) {
            System.out.print("Please enter a valid number: ");
            row = scan.nextInt();
        }
        return row;
    }

    public void move(char[][] gameBoard, int row, char symbol){
        System.out.println("Added to row " + row);
        int col = 0;
        while(col<colSize && positions.contains(rowSize*col+row)) col++;
        positions.add(rowSize * col + row);
        gameBoard[2*colSize-2*col-1][row*2-1] = symbol;
        Board.printBoard(gameBoard);
    }

    public String checkWinner(char[][]gameBoard, char checker1){
        int r_rowSize = 2*rowSize+1;
        int r_colSize = 2*colSize+1;
        char checker2 = checker1=='r' ? 'y' : 'r';
        //check row
        for(int i = 0; i<r_colSize; i++){
            if(i%2==1) {
                for (int j = 7; j < r_rowSize; j++) {
                    if ((gameBoard[i][j]==gameBoard[i][j-2])&&(gameBoard[i][j-4]==gameBoard[i][j-2])
                        &&(gameBoard[i][j-4]==gameBoard[i][j-6]))
                        if(gameBoard[i][j]==checker1) { oWinTime++; return "Congratulation! Player 1 wins."; }
                        else if(gameBoard[i][j]==checker2) { xWinTime++; return "Congratulation! Player 2 wins."; }
                }
            }
        }
        //check column
        for(int i = 0; i<r_rowSize; i++) {
            if (i % 2 == 1) {
                for (int j = 7; j < r_colSize; j++) {
                    if ((gameBoard[j][i] == gameBoard[j - 2][i]) && (gameBoard[j - 2][i] == gameBoard[j - 4][i])
                            && (gameBoard[j - 4][i] == gameBoard[j - 6][i]))
                        if (gameBoard[j][i] == checker1) { oWinTime++; return "Congratulation! Player 1 wins."; }
                        else if(gameBoard[j][i] == checker2) { xWinTime++; return "Congratulation! Player 2 wins."; }
                }
            }
        }
        //check diagonal
        for(int i = 0; i<r_colSize; i++){
            if(i%2==1) {
                for (int j = 7; j < r_rowSize; j++) {
                    if (i>=6&&(gameBoard[i][j]==gameBoard[i-2][j-2])&&(gameBoard[i-2][j-2]==gameBoard[i-4][j-4])
                            &&(gameBoard[i-4][j-4]==gameBoard[i-6][j-6]))
                        if(gameBoard[i][j]==checker1) { oWinTime++; return "Congratulation! Player 1 wins."; }
                        else if(gameBoard[i][j]==checker2) { xWinTime++; return "Congratulation! Player 2 wins."; }
                    if (i<7&&(gameBoard[i][j]==gameBoard[i+2][j-2])&&(gameBoard[i+2][j-2]==gameBoard[i+4][j-4])
                            &&(gameBoard[i+4][j-4]==gameBoard[i+6][j-6]))
                        if(gameBoard[i][j]==checker1) { oWinTime++; return "Congratulation! Player 1 wins."; }
                        else if(gameBoard[i][j]==checker2) { xWinTime++; return "Congratulation! Player 2 wins."; }
                }
            }
        }

        // isFull
        if(positions.size() == rowSize*colSize)
            return "It's a draw.";
        return "";
    }

}
