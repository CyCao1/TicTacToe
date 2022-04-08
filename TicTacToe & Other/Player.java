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

    public static void move(Board gameBoard, int pos, char symbol, int size){
        System.out.println(pos);
        positions.add(pos);
        gameBoard.getCell((pos-1)/size, (pos-1)%size).setChecker(symbol);
        gameBoard.printBoard();
    }

    public static String checkWinner(int selection, Board gameBoard, int size){
        //check row
        for(int i = 0; i < size; i++) {
            int countO = 0, countX = 0;
            for (int j = 0; j < size; j++) {
                if (gameBoard.getCell(i, j).getChecker() == 'o') countO++;
                if (gameBoard.getCell(i, j).getChecker() == 'x') countX++;
            }
            String res = printRes(selection, countO, countX, size);
            if (res.length() > 0) return res;
        }
        //check column
        for(int i = 0; i<size; i++) {
            int countO = 0, countX = 0;
            for (int j = 0; j < size; j++) {
                if (gameBoard.getCell(j, i).getChecker() == 'o') countO++;
                if (gameBoard.getCell(j, i).getChecker() == 'x') countX++;
            }
            String res = printRes(selection, countO, countX, size);
            if (res.length() > 0) return res;
        }


        //check diagonal
        int countO = 0, countX = 0;
        for(int i = 1; i<size; i++) {
            if (gameBoard.getCell(i, i).getChecker() == 'o') countO++;
            if (gameBoard.getCell(i, i).getChecker() == 'x') countX++;
        }
        String res = printRes(selection, countO, countX, size);
        if(res.length()>0) return res;

        countO = 0; countX = 0;
        for(int i = 1; i<size; i++) {
            if (gameBoard.getCell(i, size-i-1).getChecker() == 'o') countO++;
            if (gameBoard.getCell(i, size-i-1).getChecker() == 'x') countX++;
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
