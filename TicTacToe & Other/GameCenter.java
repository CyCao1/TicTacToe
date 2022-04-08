import java.util.Scanner;
/**
 * This class is for encapsulating the process of games
 */
public class GameCenter {

    public static void start(){
        int selection = gameSelect();
        if(selection==1) new TicTacToe().startGame();
        else if(selection==2) new OrderAndChaos().startGame();
        else new ConnectFour().startGame();
    }

    public static int gameSelect() {
        System.out.println("Welcome! Which game do you want to play?");
        System.out.println("1: Tic-Tac-Toe\n" +
                "2: Order and Chaos\n" +
                "3: Connect Four");
        System.out.print("Please enter the No. of game you want to play: ");
        int selection = getNumeric();
        while(selection!=1 && selection!=2 && selection!=3){
            System.out.print("Please enter a valid number: ");
            selection = getNumeric();
        }
        return selection;
    }

    public static int getNumeric(){
        Scanner scan = new Scanner(System.in);
        boolean isNum = false;
        int num = 0;
        while(!isNum){
            try{
                num = scan.nextInt();
                isNum = true;
            }catch(Exception e){
                System.out.print("Please enter a number:");
                continue;
            }
        }
        return num;
    }

    public static char getChar(){
        Scanner scan = new Scanner(System.in);
        boolean isChar = false;
        char res = 'a';
        while(!isChar){
            try{
                res = scan.next().charAt(0);
                isChar = true;
            }catch(Exception e){
                System.out.print("Please enter a letter:");
                continue;
            }
        }
        return res;
    }

    public static boolean ifStartNew(){
        System.out.print("Do you want to start another one(y/n)? ");
        Scanner scan = new Scanner(System.in);
        char newGame = getChar();
        while(newGame!='y' && newGame!='n'){
            System.out.print("Please enter a valid letter: ");
            newGame = scan.next().charAt(0);
        }
        if(newGame == 'y')
            return true;
        else
            return false;
    }

    public static char getInputChecker(char checker1, char checker2){
        Scanner scan = new Scanner(System.in);
        char checker = GameCenter.getChar();
        while(checker != checker1 && checker != checker2) {
            System.out.print("Please enter a valid letter: ");
            checker = scan.next().charAt(0);
        }
        return checker;
    }

    public static void printAllRes(){
        if(ConnectFour.xWinTime!=0 || ConnectFour.oWinTime!=0) {
            System.out.println("Player 1 wins " + ConnectFour.oWinTime + " time(s)");
            System.out.println("Player 2 wins " + ConnectFour.xWinTime + " time(s)");
        }
        if(TicTacToe.xWinTime!=0 || TicTacToe.oWinTime!=0){
            System.out.println("Player O wins " + TicTacToe.oWinTime + " time(s)");
            System.out.println("Player X wins " + TicTacToe.xWinTime + " time(s)");
        }
        if(OrderAndChaos.xWinTime!=0 || OrderAndChaos.oWinTime!=0){
            System.out.println("Player Order wins " + OrderAndChaos.oWinTime + " time(s)");
            System.out.println("Player Chaos wins " + OrderAndChaos.xWinTime + " time(s)");
        }
    }
}
