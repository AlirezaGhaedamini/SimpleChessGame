package chessgame;

public class Main {
    public static void main(String[] args) {

        ChessBoard board = new ChessBoard();

        System.out.println("Initial Chessboard:");
        board.printBoard();
        System.out.println();


        System.out.println("Simulating a chess game:");


        if (board.movePiece(1, 1, 1, 3)) {
            System.out.println("Player 1 (White) moves Pawn from (1, 1) to (1, 3)");
        } else {
            System.out.println("Invalid move by Player 1 (White): Pawn from (1, 1) to (1, 3)");
        }
        board.printBoard();
        System.out.println();


        if (board.movePiece(1, 6, 1, 4)) {
            System.out.println("Player -1 (Black) moves Pawn from (1, 6) to (1, 4)");
        } else {
            System.out.println("Invalid move by Player -1 (Black): Pawn from (1, 6) to (1, 4)");
        }
        board.printBoard();
        System.out.println();


        if (board.movePiece(1, 0, 2, 2)) {
            System.out.println("Player 1 (White) moves Knight from (1, 0) to (2, 2)");
        } else {
            System.out.println("Invalid move by Player 1 (White): Knight from (1, 0) to (2, 2)");
        }
        board.printBoard();
        System.out.println();


        if (board.movePiece(1, 7, 2, 5)) {
            System.out.println("Player -1 (Black) moves Knight from (1, 7) to (2, 5)");
        } else {
            System.out.println("Invalid move by Player -1 (Black): Knight from (1, 7) to (2, 5)");
        }
        board.printBoard();
        System.out.println();


        if (board.movePiece(4, 0, 4, 4)) {
            System.out.println("Player 1 (White) moves Queen from (4, 0) to (4, 4)");
        } else {
            System.out.println("Invalid move by Player 1 (White): Queen from (4, 0) to (4, 4)");
        }
        board.printBoard();
        System.out.println();


        if (board.movePiece(2, 7, 4, 5)) {
            System.out.println("Player -1 (Black) moves Bishop from (2, 7) to (4, 5)");
        } else {
            System.out.println("Invalid move by Player -1 (Black): Bishop from (2, 7) to (4, 5)");
        }
        board.printBoard();
        System.out.println();


        System.out.println("Final Chessboard:");
        board.printBoard();
    }
}































































//   .-.               .            .    .
//  (_) )-.           /            /    /
//     /   \   .-.   /-.    .-.   /    /
//    /     )./.-'_ /   ) ./.-'_ /    /
// .-/  `--' (__.'.'`--'`-(__.'_/_.-_/_.-
//(_/     `-._)

