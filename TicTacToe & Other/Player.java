import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class contains all necessary game moves a player performs for board games
 */
public class Player {

    public static ArrayList<Integer> positions = new ArrayList<>();

    public static int getPos(int size){
        Scanner scan = new Scanner(System.in);
        int pos = GameCenter.getNumeric();
        while(positions.contains(pos)) {
            System.out.print("Please enter a new position: ");
            pos = scan.nextInt();
        }
        while(pos>size*size||pos<1) {
            System.out.print("Please enter a valid number: ");
            pos = scan.nextInt();
        }
        return pos;
    }

    public static void move(char[][] gameBoard, int pos, char symbol, int size){
        System.out.println(pos);
        positions.add(pos);
        gameBoard[(pos-1)/size*2+1][(pos-1)%size*2+1] = symbol;

        Board.printBoard(gameBoard);
    }

    public static String checkWinner(int selection, char[][]gameBoard, int size){
        int r_size = 2*size+1;
        //check row
        for(int i = 0; i<r_size; i++){
            int countO = 0, countX = 0;
            if(i%2==1) {
                for (int j = 0; j < r_size; j++) {
                    if (gameBoard[i][j] == 'o') countO++;
                    if (gameBoard[i][j] == 'x') countX++;
                }
                String res = printRes(selection, countO, countX, size);
                if(res.length()>0) return res;
            }
        }
        //check column
        for(int i = 0; i<r_size; i++){
            int countO = 0, countX = 0;
            if(i%2==1) {
                for (int j = 0; j < r_size; j++) {
                    if (gameBoard[j][i] == 'o') countO++;
                    if (gameBoard[j][i] == 'x') countX++;
                }
                String res = printRes(selection, countO, countX, size);
                if(res.length()>0) return res;
            }
        }

        //check diagonal
        int countO = 0, countX = 0;
        for(int i = 1; i<r_size; i+=2) {
            if (gameBoard[i][i] == 'o') countO++;
            if (gameBoard[i][i] == 'x') countX++;
        }
        String res = printRes(selection, countO, countX, size);
        if(res.length()>0) return res;

        countO = 0; countX = 0;
        for(int i = 1; i<r_size; i+=2) {
            if (gameBoard[i][r_size-i-1] == 'o') countO++;
            if (gameBoard[i][r_size-i-1] == 'x') countX++;
        }
        res = printRes(selection, countO, countX, size);
        if(res.length()>0) return res;

        // isFull
        if(positions.size() == size*size)
            if(selection==2){
                OrderAndChaos.xWinTime++;
                return "Congratulation! Player Chaos wins.";
            } else return "It's a draw.";
        return "";
    }

    public static String printRes(int selection, int countO, int countX, int size){
        if(selection==2) {
            if (countO == size - 1 || countX == size - 1) {
                OrderAndChaos.oWinTime++;
                return "Congratulation! Player Order wins.";
            }
        } else {
            if (countO == size) {
                TicTacToe.oWinTime++;
                return "Congratulation! Player O wins.";
            } else if (countX == size) {
                TicTacToe.xWinTime++;
                return "Congratulation! Player X wins.";
            }
        }
        return "";
    }

}
