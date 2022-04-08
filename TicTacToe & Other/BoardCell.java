/**
 * This class represents a cell of the board
 */
public class BoardCell {

    private char checker;
    public BoardCell(char checker) {
        this.checker = checker;
    }

    public BoardCell() {
        this.checker = ' ';
    }

    public char getChecker() {
        return checker;
    }

    public void setChecker(char checker) {
        this.checker = checker;
    }

}
