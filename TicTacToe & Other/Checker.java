import java.util.Scanner;
/**
 * This class contains all necessary methods and variables for a checker
 */
public class Checker {

    private char symbol;

    public Checker(){}

    public static char getChecker(char checker1, char checker2){
        Scanner scan = new Scanner(System.in);
        char checker = GameCenter.getChar();
        while(checker != checker1 && checker != checker2) {
            System.out.print("Please enter a valid letter: ");
            checker = scan.next().charAt(0);
        }
        return checker;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
