package chessgame;
/**
 * The class represents a Knight chess piece in a chess game.
 * Knights have a unique "L-shaped" movement pattern on the chessboard:
 * - They move two squares in one direction (horizontal or vertical) and then one square perpendicular to that,
 *   or one square in one direction and then two squares perpendicular to that.
 */

public class Knights extends ChessPiece{
    /**
     * The value of the Knight chess piece.
     */
    private static final int KNIGHTS_VALUE = 3;
    /**
     * Constructs a Knight chess piece.
     *
     * @param owner The owner of the Knight (e.g., player number).
     * @param x     The x-coordinate of the Knight's initial position on the chessboard.
     * @param y     The y-coordinate of the Knight's initial position on the chessboard.
     */
    public Knights( int owner, int x, int y) {
        super(KNIGHTS_VALUE, owner, 'N', x, y);
    }
    /**
     * Determines whether the Knight can move to a specified position on the chessboard.
     * Knights can move in an "L-shape," which is defined as:
     * - Two squares in one direction and one square perpendicular to that, or
     * - One square in one direction and two squares perpendicular to that.
     *
     * @param x The x-coordinate of the target position.
     * @param y The y-coordinate of the target position.
     * @return {@code true} if the Knight can move to the specified position, {@code false} otherwise.
     */

    @Override
    public boolean canMove(int x, int y) {
        int deltaX = Math.abs(this.getX() - x);
        int deltaY = Math.abs(this.getY() - y);
        return (deltaY == 1 && deltaX == 2) || (deltaY == 2 && deltaX == 1) || (deltaY == 0 && deltaX == 0);
    }
}
