package chessgame;

/**
 * The class represents a Pawn chess piece in a chess game.
 * Pawns are the most basic chess pieces, with unique movement rules:
 * - They typically move forward one square, but never backward.
 */

public class Pawns extends ChessPiece {
    /**
     * The value of the Pawn chess piece.
     */
    private static final int BAUER_VALUE = 1;

    /**
     * Constructs a Pawn chess piece.
     *
     * @param owner The owner of the Pawn (e.g., player number).
     * @param x     The x-coordinate of the Pawn's initial position on the chessboard.
     * @param y     The y-coordinate of the Pawn's initial position on the chessboard.
     */
    public Pawns(int owner, int x, int y) {
        super(BAUER_VALUE, owner, 'P', x, y);
    }

    /**
     * Determines whether the Pawn can move to a specified position on the chessboard.
     * Pawns have specific movement rules:
     * - A Pawn can move one square forward (incrementing its y-coordinate by 1) as long as its x-coordinate remains unchanged.
     * - In this simplified implementation, a Pawn can also "stay in place" if the target position is the same as the current position.
     *
     * @param x The x-coordinate of the target position.
     * @param y The y-coordinate of the target position.
     * @return {@code true} if the Pawn can move to the specified position, {@code false} otherwise.
     */
    @Override
    public boolean canMove(int x, int y) {
        int deltaY = y - this.getY();
        int deltaX = Math.abs(x - this.getX());
        
        // Moving forward (direction depends on owner)
        if (deltaX == 0) {
            // First move can be 2 squares
            if ((this.getOwner() == 1 && this.getY() == 1) || (this.getOwner() == -1 && this.getY() == 6)) {
                return (this.getOwner() == 1 && deltaY == 2) || (this.getOwner() == -1 && deltaY == -2);
            }
            // Normal move is 1 square
            return (this.getOwner() == 1 && deltaY == 1) || (this.getOwner() == -1 && deltaY == -1);
        }
        
        // Diagonal capture (direction depends on owner)
        return deltaX == 1 && ((this.getOwner() == 1 && deltaY == 1) || (this.getOwner() == -1 && deltaY == -1));
    }
}
