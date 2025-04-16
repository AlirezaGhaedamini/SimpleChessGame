package chessgame;

/**
 * The class represents a Rook chess piece in a chess game.
 * <p>
 * The Rook is a powerful piece that can move any number of squares in a straight line,
 * either vertically or horizontally. It cannot move diagonally.
 */

public class Rooks extends ChessPiece {
    /**
     * The value of the Rook chess piece.
     */
    private static final int ROOKS_VALUE = 5;

    /**
     * Constructs a Rook chess piece.
     *
     * @param owner The owner of the Rook (e.g., player number).
     * @param x     The x-coordinate of the Rook's initial position on the chessboard.
     * @param y     The y-coordinate of the Rook's initial position on the chessboard.
     */
    public Rooks(int owner, int x, int y) {
        super(ROOKS_VALUE, owner, 'R', x, y);
    }

    /**
     * Determines whether the Rook can move to a specified position on the chessboard.
     * The Rook can move any number of squares:
     * - Vertically (when the x-coordinate remains the same).
     * - Horizontally (when the y-coordinate remains the same).
     *
     * @param x The x-coordinate of the target position.
     * @param y The y-coordinate of the target position.
     * @return {@code true} if the Rook can move to the specified position, {@code false} otherwise.
     */

    @Override
    public boolean canMove(int x, int y) {

        return this.getX() == x || this.getY() == y;
    }
}
