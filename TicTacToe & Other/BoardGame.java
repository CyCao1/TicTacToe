import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is the parent class for board games like TTT and OAC.
 */
public abstract class BoardGame {
    private Scanner scan;
    protected int size;
    protected int rowSize;
    protected int colSize;
    protected int oWinTime;
    protected int xWinTime;
    protected ArrayList<Integer> positions;
    protected Board gameBoard;
    public BoardGame() {}
    public BoardGame(int selection) {
        scan = new Scanner(System.in);
        size = 0;
        oWinTime = 0;
        xWinTime = 0;
    }
    public abstract void startGame();
}
