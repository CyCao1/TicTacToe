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
        gameBoard = new Board();
        size = gameBoard.getSize();
        positions = Player.positions;
    }

    public void startGame() {

        gameBoard.printBoard();
        positions.clear();

        while(true) {
            System.out.print("Player O Enter your move(1-" + size*size + "): ");
            int posO = Player.getPos(size);
            Player.move(gameBoard, posO, 'o', size);
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
