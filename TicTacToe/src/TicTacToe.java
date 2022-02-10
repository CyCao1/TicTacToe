import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    static ArrayList<Integer> playerXPositions = new ArrayList<Integer>();
    static ArrayList<Integer> playerOPositions = new ArrayList<Integer>();
    static int oWinTime = 0;
    static int xWinTime = 0;
    public static void printBoard(char[][] gameBoard){
        for(char[] row: gameBoard) {
            for (char c : row)
                System.out.print(c);
            System.out.println();
        }
    }

    public static void move(char[][] gameBoard, int pos, char player){
        char symbol;
        if(player=='X')
            symbol = 'X';
        else
            symbol = 'O';
        gameBoard[(pos-1)/3*2+1][(pos-1)%3*3+1] = symbol;
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
            } else if(playerOPositions.size()+playerXPositions.size()==9)
                return "It's a draw.";
        }
        return "";
    }

    public static char[][] initBoard(){
        char[][] gameBoard = {{'+', '-', '-', '+', '-', '-', '+', '-', '-', '+'},
                {'|', ' ', ' ', '|', ' ', ' ', '|', ' ', ' ', '|'},
                {'+', '-', '-', '+', '-', '-', '+', '-', '-', '+'},
                {'|', ' ', ' ', '|', ' ', ' ', '|', ' ', ' ', '|'},
                {'+', '-', '-', '+', '-', '-', '+', '-', '-', '+'},
                {'|', ' ', ' ', '|', ' ', ' ', '|', ' ', ' ', '|'},
                {'+', '-', '-', '+', '-', '-', '+', '-', '-', '+'},};
        return gameBoard;
    }

    public static void main(String[] args){
        char[][] gameBoard = initBoard();
        System.out.println("Welcome to Tic-Tac-Toe!");
        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Player O Enter your move(1-9): ");
            int posO = scan.nextInt();
            while(playerOPositions.contains(posO)||playerXPositions.contains(posO)) {
                System.out.print("Please enter a new position: ");
                posO = scan.nextInt();
            }
            System.out.println(posO);
            playerOPositions.add(posO);
            move(gameBoard, posO, 'O');
            printBoard(gameBoard);
            String res = checkWinner();
            char newGame;
            if(res.length()>0) {
                System.out.println(res);
                System.out.println("Do you want to start another one(y/n)?");
                newGame = scan.next().charAt(0);
                if(newGame == 'y'){
                    playerOPositions.clear();
                    playerXPositions.clear();
                    gameBoard = initBoard();
                } else {
                    System.out.println("Player X wins " + xWinTime + " time(s)");
                    System.out.println("Player O wins " + oWinTime + " time(s)");
                    break;
                }
            }

            System.out.print("Player X Enter your move(1-9): ");
            int posX = scan.nextInt();
            while(playerOPositions.contains(posX)||playerXPositions.contains(posX)) {
                System.out.print("Please enter a new position: ");
                posX = scan.nextInt();
            }
            System.out.println(posX);
            playerXPositions.add(posX);
            move(gameBoard, posX, 'X');
            printBoard(gameBoard);
            res = checkWinner();
            if(res.length()>0) {
                System.out.println(res);
                System.out.println("Do you want to start another one(y/n)?");
                newGame = scan.next().charAt(0);
                if(newGame=='y'){
                    playerOPositions.clear();
                    playerXPositions.clear();
                    gameBoard = initBoard();
                } else {
                    System.out.println("Player X wins " + xWinTime + " time(s)");
                    System.out.println("Player O wins " + oWinTime + " time(s)");
                    break;
                }
            }
        }
    }
}
