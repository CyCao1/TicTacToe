import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    static ArrayList<Integer> playerXPositions = new ArrayList<Integer>();
    static ArrayList<Integer> playerOPositions = new ArrayList<Integer>();
    static char[][] gameBoard = Board.initBoard();
    static int oWinTime = 0;
    static int xWinTime = 0;

    public static void startGame() {
        Board.printBoard(gameBoard);
        while(true) {
            System.out.print("Player O Enter your move(1-9): ");
            int posO = getPos();
            move(gameBoard, posO, 'O');
            String res = checkWinner();
            if(res.length()>0) {
                System.out.println(res);
                if(!ifStartNew()){
                    System.out.println("Player X wins " + xWinTime + " time(s)");
                    System.out.println("Player O wins " + oWinTime + " time(s)");
                    break;
                } else {
                    restart();
                    continue;
                }
            }

            System.out.print("Player X Enter your move(1-9): ");
            int posX = getPos();
            move(gameBoard, posX, 'X');
            res = checkWinner();
            if(res.length()>0) {
                System.out.println(res);
                if(!ifStartNew()) {
                    System.out.println("Player X wins " + xWinTime + " time(s)");
                    System.out.println("Player O wins " + oWinTime + " time(s)");
                    break;
                } else {
                    restart();
                    continue;
                }
            }
        }
    }

    public static String checkWinner(){
        List<List> win = new ArrayList<List>();
        win.add(Arrays.asList(1,2,3));
        win.add(Arrays.asList(4,5,6));
        win.add(Arrays.asList(7,8,9));
        win.add(Arrays.asList(1,4,7));
        win.add(Arrays.asList(2,5,8));
        win.add(Arrays.asList(3,6,9));
        win.add(Arrays.asList(1,5,9));
        win.add(Arrays.asList(3,5,7));

        for(List l: win) {
            if (playerXPositions.containsAll(l)) {
                xWinTime++;
                return "Congratulation! Player X wins.";
            } else if(playerOPositions.containsAll(l)) {
                oWinTime++;
                return "Congratulation! Player O wins.";
            } else if(playerOPositions.size() + playerXPositions.size()==9)
                return "It's a draw.";
        }
        return "";
    }

    public static int getPos(){
        Scanner scan = new Scanner(System.in);
        int pos = scan.nextInt();
        while(playerOPositions.contains(pos)||playerXPositions.contains(pos)) {
            System.out.print("Please enter a new position: ");
            pos = scan.nextInt();
        }
        return pos;
    }

    public static void move(char[][] gameBoard, int pos, char player){
        System.out.println(pos);
        char symbol;
        if(player=='X') {
            symbol = 'X';
            playerXPositions.add(pos);
        } else {
            symbol = 'O';
            playerOPositions.add(pos);
        }
        gameBoard[(pos-1)/3*2+1][(pos-1)%3*3+1] = symbol;
        Board.printBoard(gameBoard);
    }

    public static boolean ifStartNew(){
        System.out.print("Do you want to start another one(y/n)? ");
        Scanner scan = new Scanner(System.in);
        char newGame = scan.next().charAt(0);
        while(newGame!='y' && newGame!='n'){
            System.out.print("Please enter a valid letter: ");
            newGame = scan.next().charAt(0);
        }
        if(newGame == 'y')
            return true;
        else
            return false;
    }

    public static void restart() {
        playerOPositions.clear();
        playerXPositions.clear();
        gameBoard = Board.initBoard();
        Board.printBoard(gameBoard);
    }
}
