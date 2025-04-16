package chessgame;

/**
 * The class represents a Queen chess piece in a chess game.
 * <p>
 * The Queen is the most powerful chess piece, capable of moving any number of squares in a straight line
 * either vertically, horizontally, or diagonally. This flexibility makes the Queen extremely versatile in gameplay.
 */
public class Queen extends ChessPiece {
    /**
     * The value of the Queen chess piece.
     */
    public static final int DAME_VALUE = 9;

    /**
     * Constructs a Queen chess piece.
     *
     * @param owner The owner of the Queen (e.g., player number).
     * @param x     The x-coordinate of the Queen's initial position on the chessboard.
     * @param y     The y-coordinate of the Queen's initial position on the chessboard.
     */
    public Queen(int owner, int x, int y) {
        super(DAME_VALUE, owner, 'Q', x, y);
    }

    /**
     * Determines whether the Queen can move to a specified position on the chessboard.
     * <p>
     * The Queen can move any number of squares in a straight line:
     * - Vertically (when the x-coordinate remains unchanged).
     * - Horizontally (when the y-coordinate remains unchanged).
     * - Diagonally (when the absolute difference between the x- and y-coordinates of the current and target positions is equal).
     *
     * @param x The x-coordinate of the target position.
     * @param y The y-coordinate of the target position.
     * @return {@code true} if the Queen can move to the specified position, {@code false} otherwise.
     */

    @Override
    public boolean canMove(int x, int y) {
        int deltaX = Math.abs(this.getX() - x);
        int deltaY = Math.abs(this.getY() - y);
        return this.getX() == x || this.getY() == y || deltaY == deltaX;
    }
}
