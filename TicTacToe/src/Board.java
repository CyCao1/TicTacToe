public class Board {
    public static char[][] initBoard(){
        char[][] gameBoard = new char[][]{{'+', '-', '-', '+', '-', '-', '+', '-', '-', '+'},
                {'|', ' ', ' ', '|', ' ', ' ', '|', ' ', ' ', '|'},
                {'+', '-', '-', '+', '-', '-', '+', '-', '-', '+'},
                {'|', ' ', ' ', '|', ' ', ' ', '|', ' ', ' ', '|'},
                {'+', '-', '-', '+', '-', '-', '+', '-', '-', '+'},
                {'|', ' ', ' ', '|', ' ', ' ', '|', ' ', ' ', '|'},
                {'+', '-', '-', '+', '-', '-', '+', '-', '-', '+'},};
        return gameBoard;
    }
    public static void printBoard(char[][] gameBoard){
        for(char[] row: gameBoard) {
            for (char c : row)
                System.out.print(c);
            System.out.println();
        }
    }
}