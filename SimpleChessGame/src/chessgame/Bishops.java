package chessgame;

/**
 * The class represents a Bishop chess piece in a chess game.
 * Bishops move diagonally on the chessboard, and this class ensures that the movement adheres to
 * the diagonal movement rules of a Bishop in chess.
 */

public class Bishops extends ChessPiece {
    /**
     * The value of the Bishop chess piece.
     */
    private static final int BISHOPS_VALUE = 3;

    /**
     * Constructs a Bishop chess piece.
     *
     * @param owner The owner of the Bishop (e.g., player number).
     * @param x     The x-coordinate of the Bishop's initial position on the chessboard.
     * @param y     The y-coordinate of the Bishop's initial position on the chessboard.
     */
    public Bishops(int owner, int x, int y) {
        super(BISHOPS_VALUE, owner, 'B', x, y);
    }

    /**
     * Determines whether the Bishop can move to a specified position on the chessboard.
     * Bishops can only move diagonally, meaning the absolute difference between
     * the x-coordinates and y-coordinates of the current and target positions must be equal.
     *
     * @param x The x-coordinate of the target position.
     * @param y The y-coordinate of the target position.
     * @return {@code true} if the Bishop can move to the specified position, {@code false} otherwise.
     */

    @Override
    public boolean canMove(int x, int y) {
        int deltaX = Math.abs(this.getX() - x);
        int deltaY = Math.abs(this.getY() - y);
        return deltaX == deltaY;
    }
}
