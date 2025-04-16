package chessgame;

/**
 * Represents the King piece in a chess game.
 * The King is the most important piece in chess and has a unique movement rule.
 * It can move one square in any direction (horizontally, vertically, or diagonally).
 */
public class King extends ChessPiece {
    /**
     * The value assigned to the King piece.
     * Since the King cannot be captured without ending the game, its value is set to {@link Integer#MAX_VALUE}.
     */
    private static final int KING_VALUE = Integer.MAX_VALUE;

    /**
     * Constructs a King piece with the specified owner and position.
     *
     * @param owner The owner of the King piece (-1 for black, 1 for white).
     * @param x     The x-coordinate of the King's initial position on the chessboard.
     * @param y     The y-coordinate of the King's initial position on the chessboard.
     */
    public King(int owner, int x, int y) {
        super(KING_VALUE, owner, 'K', x, y);
    }

    /**
     * Determines whether the King can move to the specified position (x, y).
     * The King can move one square in any direction, but not beyond.
     *
     * @param x The x-coordinate of the target position.
     * @param y The y-coordinate of the target position.
     * @return {@code true} if the King can legally move to the specified position,{@code false} otherwise.
     */

    @Override
    public boolean canMove(int x, int y) {
        int deltaX = Math.abs(this.getX() - x);
        int deltaY = Math.abs(this.getY() - y);
        return deltaY <= 1 && deltaX <= 1;
    }
}
