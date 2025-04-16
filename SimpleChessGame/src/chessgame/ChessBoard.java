package chessgame;

import java.util.ArrayList;
import java.util.List;

/**
 * The class represents the chessboard for a chess game.
 * It manages the positions of all chess pieces, initializes the board with standard piece placement,
 * and provides methods for interacting with and displaying the board.
 * <p>
 * This class includes functionality to:
 * - Initialize the board with the default starting positions for all pieces.
 * - Retrieve all pieces currently in play.
 * - Print the current state of the board.
 * - Move pieces according to chess rules, including validating movements and capturing opponent pieces.
 */

public class ChessBoard {
    /**
     * A 2D array representing the chessboard.
     * Each cell contains a ChessPiece or null if the cell is empty.
     */
    private final ChessPiece[][] chessBoard;

    /**
     * Constructs a new ChessBoard and initializes it with the default piece placement.
     */

    public ChessBoard() {
        this.chessBoard = new ChessPiece[8][8];
        initializeBoard();
    }

    /**
     * Initializes the chessboard with the default starting positions for all pieces.
     * Player 1's pieces are placed on rows 0 and 1, and Player -1's pieces are placed on rows 6 and 7.
     * Pawns are placed on rows 1 and 6, while the back rank pieces are placed in the standard order.
     */
    public void initializeBoard() {
        chessBoard[0][0] = new Rooks(1, 0, 0);
        chessBoard[1][0] = new Knights(1, 1, 0);
        chessBoard[2][0] = new Bishops(1, 2, 0);
        chessBoard[3][0] = new King(1, 3, 0);
        chessBoard[4][0] = new Queen(1, 4, 0);
        chessBoard[5][0] = new Bishops(1, 6, 0);
        chessBoard[6][0] = new Knights(1, 7, 0);
        chessBoard[7][0] = new Rooks(1, 8, 0);
        for (int i = 0; i < 8; i++) {
            chessBoard[i][1] = new Pawns(1, i, 1);

        }
        chessBoard[0][7] = new Rooks(-1, 0, 7);
        chessBoard[1][7] = new Knights(-1, 1, 7);
        chessBoard[2][7] = new Bishops(-1, 2, 7);
        chessBoard[3][7] = new King(-1, 3, 7);
        chessBoard[4][7] = new Queen(-1, 4, 7);
        chessBoard[5][7] = new Bishops(-1, 6, 7);
        chessBoard[6][7] = new Knights(-1, 7, 7);
        chessBoard[7][7] = new Rooks(-1, 8, 7);
        for (int i = 0; i < 8; i++) {
            chessBoard[i][6] = new Pawns(-1, i, 6);
        }

    }

    /**
     * Retrieves all pieces currently in play on the chessboard.
     *
     * @return A  List of  ChessPiece objects representing all pieces currently in play.
     */

    public List<ChessPiece> piecesInPlay() {
        List<ChessPiece> pieces = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoard[i][j] != null) {
                    pieces.add(chessBoard[i][j]);
                }
            }
        }
        return pieces;
    }
    /**
     * Prints the current state of the chessboard to the console recursively.
     * Empty cells are represented by a dot (".").
     * Occupied cells display the symbol of the chess piece located in that position.
     */
    public void printBoard() {
        printRowRecursive(0);
    }

    /**
     * Recursively prints a row of the chessboard.
     *
     * @param row The current row index to print.
     */
    private void printRowRecursive(int row) {
        if (row >= 8) {
            return;
        }
        printCellRecursive(row, 0);
        System.out.println();
        printRowRecursive(row + 1);
    }

    /**
     * Recursively prints the cells in a row.
     *
     * @param row The row index of the current cell.
     * @param column The column index of the current cell.
     */
    private void printCellRecursive(int row, int column) {
        if (column >= 8) {
            return;
        }

        System.out.print((chessBoard[column][row] != null ? chessBoard[column][row].getSymbol() : ".") + " ");
        printCellRecursive(row, column + 1);
    }

    /**
     * Checks if the path between two positions is clear of pieces.
     * This is used to validate moves for pieces that cannot jump over other pieces.
     *
     * @param startX The x-coordinate of the starting position
     * @param startY The y-coordinate of the starting position
     * @param targetX The x-coordinate of the target position
     * @param targetY The y-coordinate of the target position
     * @return true if the path is clear, false otherwise
     */
    private boolean isPathClear(int startX, int startY, int targetX, int targetY) {
        // Knights can jump over pieces, so we don't need to check their path
        if (chessBoard[startX][startY] instanceof Knights) {
            return true;
        }

        int deltaX = Integer.compare(targetX, startX);
        int deltaY = Integer.compare(targetY, startY);
        int currentX = startX + deltaX;
        int currentY = startY + deltaY;

        while (currentX != targetX || currentY != targetY) {
            if (chessBoard[currentX][currentY] != null) {
                return false;
            }
            currentX += deltaX;
            currentY += deltaY;
        }

        return true;
    }

    /**
     * Moves a piece from one position to another on the chessboard.
     * <p>
     * This method validates the move according to the rules of chess, including:
     * - Ensuring the start position contains a piece.
     * - Ensuring the move is within the bounds of the chessboard.
     * - Validating the piece's movement rules using {@code canMove}.
     * - Checking for potential captures of opponent pieces.
     * </p>
     *
     * @param startX  The x-coordinate of the starting position.
     * @param startY  The y-coordinate of the starting position.
     * @param targetX The x-coordinate of the target position.
     * @param targetY The y-coordinate of the target position.
     * @return  true if the piece was successfully moved,  false otherwise.
     */

    public boolean movePiece(int startX, int startY, int targetX, int targetY) {
        if (startX < 0 || startY < 0 || startY >= 8 || startX >= 8 || chessBoard[startX][startY] == null) {
            return false;
        }
        ChessPiece piece = chessBoard[startX][startY];
        if (targetX < 0 || targetY < 0 || targetX >= 8 || targetY >= 8) {
            return false;
        }
        if (!chessBoard[startX][startY].canMove(targetX, targetY)) {
            return false;
        }
        if (!isPathClear(startX, startY, targetX, targetY)) {
            return false;
        }
        if (chessBoard[targetX][targetY] != null) {
            if (chessBoard[targetX][targetY].getOwner() == piece.getOwner()) {
                return false;
            } else {
                System.out.println("Piece captured: " + chessBoard[targetX][targetY].getSymbol());
            }
        }

        chessBoard[targetX][targetY] = piece;
        chessBoard[startX][startY] = null;
        piece.setPosition(targetX, targetY);
        return true;
    }

}
