package chessgame;

/**
 * Represents an abstract chess piece in a chess game.
 * This class serves as the base for all specific chess piece types (e.g., Pawn, Knight, Bishop).
 * Each piece has a value, an owner, a symbol, and a position on the chessboard.
 */
public abstract class ChessPiece {

    /**
     * The value of the piece, representing its relative strength or importance in the game.
     * A higher value indicates a stronger piece.
     */
    private final int value;
    /**
     * The owner of the piece, indicating which player the piece belongs to.
     * The value is:
     * - `-1` for the black player
     * - `1` for the white player
     */
    private final int owner;
    /**
     * The symbol of the piece, representing its type (e.g., pawn, knight, bishop).
     * this is a single character that visually identifies the piece.
     * Each class defines the specific symbol for its corresponding piece type.
     */
    private final char symbol;
    /**
     * The x-coordinate of the piece's current position on the chessboard.
     * Represents the column index (0-based).
     * The y-coordinate of the piece's current position on the chessboard.
     * Represents the row index (0-based).
     */
    private int x, y;

    /**
     * Checks whether the piece can move to the specified position (x, y) on the chessboard.
     * This method must be implemented by each specific chess piece type, as the movement
     * rules vary for different types of pieces.
     *
     * @param x The x-coordinate of the target position.
     * @param y The y-coordinate of the target position.
     * @return {@code true} if the piece can move to the specified position, {@code false} otherwise.
     */
    abstract boolean canMove(int x, int y);

    /**
     * Constructs a chess piece with the specified value, owner, symbol, and position.
     *
     * @param value  The value of the piece, representing its relative strength or importance.
     * @param owner  The owner of the piece (-1 for black, 1 for white).
     * @param symbol The symbol of the piece, representing its type (e.g., 'P' for Pawn).
     * @param x      The x-coordinate of the piece's initial position.
     * @param y      The y-coordinate of the piece's initial position.
     */
    public ChessPiece(int value, int owner, char symbol, int x, int y) {
        this.value = value;
        this.owner = owner;
        this.symbol = symbol;
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the value of the piece.
     *
     * @return The value of the piece.
     */

    public int getValue() {
        return value;
    }

    /**
     * Returns the owner of the piece.
     *
     * @return The owner of the piece (-1 for black, 1 for white).
     */

    public int getOwner() {
        return owner;
    }

    /**
     * Returns the x-coordinate of the piece's current position on the chessboard.
     *
     * @return The x-coordinate of the piece's position.
     */

    public int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of the piece's current position on the chessboard.
     *
     * @return The y-coordinate of the piece's position.
     */

    public int getY() {
        return y;
    }

    /**
     * Returns the symbol of the piece, representing its type.
     *
     * @return The symbol of the piece (e.g., 'P' for Pawn).
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Sets the piece's position on the chessboard.
     *
     * @param x The new x-coordinate of the piece's position.
     * @param y The new y-coordinate of the piece's position.
     */

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


































//   .-.               .            .    .
//  (_) )-.           /            /    /
//     /   \   .-.   /-.    .-.   /    /
//    /     )./.-'_ /   ) ./.-'_ /    /
// .-/  `--' (__.'.'`--'`-(__.'_/_.-_/_.-
//(_/     `-._)





