import java.util.Scanner;

/**
 * This class is the board class for board games like TTT and OAC.
 */
public class Board {

    public Board() {}

    public static char[][] initBoard(int rowSize, int colSize){
        int r_rowSize = 2*rowSize+1;
        int r_colSize = 2*colSize+1;
        char[][] gameBoard = new char[r_colSize][r_rowSize];
        for (int i = 0; i < r_colSize; i++) {
            String s;
            if(i%2==0)
                s = "+-".repeat(rowSize) + "+";
            else
                s = ("| ").repeat(rowSize) + "|";
            gameBoard[i] = s.toCharArray();
        }
        return gameBoard;
    }
    public static void printBoard(char[][] gameBoard){
        for(char[] row: gameBoard) {
            for (char c : row)
                System.out.print(c);
            System.out.println();
        }
    }

    public static int getSize(){
        System.out.print("Please enter the size of the board(>=3): ");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        while(size<3){
            System.out.print("Please enter a valid number: ");
            size = scan.nextInt();
        }
        return size;
    }
}