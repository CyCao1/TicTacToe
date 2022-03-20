import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class inherits all the attributes from BoardGame class,
 * and specifies features for Order And Chaos game
 */
public final class OrderAndChaos extends BoardGame{
    public static int oWinTime = 0;
    public static int xWinTime = 0;

    public OrderAndChaos() {
        super(2);
        size = 6;
        int r_size = 2*size+1;
        gameBoard = new char[r_size][r_size];
        positions = Player.positions;
    }

    public void startGame() {

        gameBoard = Board.initBoard(size, size);
        Board.printBoard(gameBoard);
        positions.clear();

        while(true) {
            System.out.print("Player Order Enter your checker(x/o): ");
            char checker = Checker.getChecker('x', 'o');
            System.out.print("Player Order Enter your move(1-" + size*size + "): ");
            int pos = Player.getPos(size);
            Player.move(gameBoard, pos, checker, size);
            String res = Player.checkWinner(2, gameBoard, size);
            if(res.length()>0) {
                System.out.println(res);
                if(!GameCenter.ifStartNew()){
                    GameCenter.printAllRes();
                    System.exit(0);
                } else GameCenter.start();
            }

            System.out.print("Player Chaos Enter your checker(x/o): ");
            checker = Checker.getChecker('x', 'o');
            System.out.print("Player Chaos Enter your move(1-" + size*size + "): ");
            pos = Player.getPos(size);
            Player.move(gameBoard, pos, checker, size);
            res = Player.checkWinner(2, gameBoard, size);
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
}
