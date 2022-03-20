import java.util.*;
/**
 * This class inherits all the attributes from BoardGame class,
 * and specifies features for Tic Tac Toe game
 */
public final class TicTacToe extends BoardGame{
    public static int oWinTime = 0;
    public static int xWinTime = 0;

    public TicTacToe() {
        super(1);
        size = Board.getSize();
        int r_size = 2*size+1;
        gameBoard = new char[r_size][r_size];
        positions = Player.positions;
    }

    public void startGame() {

        gameBoard = Board.initBoard(size, size);
        Board.printBoard(gameBoard);
        positions.clear();

        while(true) {
            System.out.print("Player O Enter your move(1-" + size*size + "): ");
            int posO = Player.getPos(size);
            Player.move(gameBoard, posO, 'o',size);
            String res = Player.checkWinner(1, gameBoard, size);
            if(res.length()>0) {
                System.out.println(res);
                if(!GameCenter.ifStartNew()){
                    GameCenter.printAllRes();
                    System.exit(0);
                } else GameCenter.start();
            }

            System.out.print("Player X Enter your move(1-" + size*size + "): ");
            int posX = Player.getPos(size);
            Player.move(gameBoard, posX, 'x', size);
            res = Player.checkWinner(1, gameBoard, size);
            if(res.length()>0) {
                System.out.println(res);
                if(!GameCenter.ifStartNew()) {
                    GameCenter.printAllRes();
                    System.exit(0);
                } else GameCenter.start();
            }
        }
    }

}
