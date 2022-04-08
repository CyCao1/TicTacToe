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
        gameBoard = new Board(rowSize, colSize);
        positions = Player.positions;
    }

    public void startGame() {

        gameBoard.printBoard();
        positions.clear();

        System.out.print("Player 1 Enter your checker(y/r): ");
        char checker1 = GameCenter.getInputChecker('y', 'r');
        char checker2 = checker1=='r' ? 'y' : 'r';

        while(true) {
            System.out.print("Player 1 Enter your move(1-" + colSize + "): ");
            int col = getPos();
            move(gameBoard, col, checker1);
            String res = checkWinner(gameBoard, checker1);
            if(res.length()>0) {
                System.out.println(res);
                if(!GameCenter.ifStartNew()){
                    GameCenter.printAllRes();
                    System.exit(0);
                } else GameCenter.start();
            }

            System.out.print("Player 2 Enter your move(1-" + rowSize + "): ");
            col = getPos();
            move(gameBoard, col, checker2);
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
        int col = GameCenter.getNumeric();
        while(positions.contains(col)) {
            System.out.print("This column is full, please enter a new number: ");
            col = scan.nextInt();
        }
        while(col>colSize||col<1) {
            System.out.print("Please enter a valid number: ");
            col = scan.nextInt();
        }
        return col;
    }

    public void move(Board gameBoard, int col, char symbol){
        System.out.println("Added to col " + col);
        int row = rowSize-1;
        while(row>=0 && positions.contains(colSize*row+col)) row--;
        positions.add(colSize * row + col);
        gameBoard.getCell(row, col-1).setChecker(symbol);
        gameBoard.printBoard();
    }

    public String checkWinner(Board gameBoard, char checker1){
        char checker2 = checker1=='r' ? 'y' : 'r';
        //check row
        for(int i = 0; i < rowSize; i++) {
            for (int j = 3; j < colSize; j++) {
                if ((gameBoard.getCell(i, j).getChecker() == gameBoard.getCell(i, j - 1).getChecker())
                        && (gameBoard.getCell(i, j - 1).getChecker() == gameBoard.getCell(i, j - 2).getChecker())
                        && (gameBoard.getCell(i, j - 2).getChecker() == gameBoard.getCell(i, j - 3).getChecker()))
                    if (gameBoard.getCell(i, j).getChecker() == checker1) {
                        oWinTime++;
                        return "Congratulation! Player 1 wins.";
                    } else if (gameBoard.getCell(i, j).getChecker() == checker2) {
                        xWinTime++;
                        return "Congratulation! Player 2 wins.";
                    }
            }
        }
        //check column
        for(int i = 0; i < colSize; i++) {
            for (int j = 3; j < rowSize; j++)
                if ((gameBoard.getCell(j, i).getChecker() == gameBoard.getCell(j - 1, i).getChecker())
                        && (gameBoard.getCell(j - 1, i).getChecker() == gameBoard.getCell(j - 2, i).getChecker())
                        && (gameBoard.getCell(j - 2, i).getChecker() == gameBoard.getCell(j - 3, i).getChecker())) {
                    if (gameBoard.getCell(j, i).getChecker() == checker1) {
                        oWinTime++;
                        return "Congratulation! Player 1 wins.";
                    } else if (gameBoard.getCell(j, i).getChecker() == checker2) {
                        xWinTime++;
                        return "Congratulation! Player 2 wins.";
                    }
                }
        }
        //check diagonal
        for(int i = 0; i<rowSize; i++) {
            for (int j = 3; j < colSize; j++) {
                if (i >= 3 && (gameBoard.getCell(i, j).getChecker() == gameBoard.getCell(i-1, j-1).getChecker())
                        && (gameBoard.getCell(i-1, j-1).getChecker() == gameBoard.getCell(i-2, j-2).getChecker())
                        && (gameBoard.getCell(i-2, j-2).getChecker() == gameBoard.getCell(i-3, j-3).getChecker())) {
                    if (gameBoard.getCell(i, j).getChecker() == checker1) {
                        oWinTime++;
                        return "Congratulation! Player 1 wins.";
                    } else if (gameBoard.getCell(i, j).getChecker() == checker2) {
                        xWinTime++;
                        return "Congratulation! Player 2 wins.";
                    }
                }
                if (i < 3 && (gameBoard.getCell(i, j).getChecker() == gameBoard.getCell(i+1, j-1).getChecker())
                            && (gameBoard.getCell(i+1, j-1).getChecker() == gameBoard.getCell(i+2, j-2).getChecker())
                            && (gameBoard.getCell(i+2, j-2).getChecker() == gameBoard.getCell(i+3, j-3).getChecker())) {
                    if (gameBoard.getCell(i, j).getChecker() == checker1) {
                        oWinTime++;
                        return "Congratulation! Player 1 wins.";
                    } else if (gameBoard.getCell(i, j).getChecker() == checker2) {
                        xWinTime++;
                        return "Congratulation! Player 2 wins.";
                    }
                }
            }
        }

        // isFull
        if(positions.size() == rowSize*colSize)
            return "It's a draw.";
        return "";
    }

}
