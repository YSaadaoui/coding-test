package com.example.codingtest.sansPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chess {

    public static List<String> generateRookMoves(char[][] board, int rookRow, int rookCol) {
        return Stream.of(
                        getMovesInDirection(board, rookRow, rookCol, -1, 0),
                        getMovesInDirection(board, rookRow, rookCol, 1, 0),
                        getMovesInDirection(board, rookRow, rookCol, 0, -1),
                        getMovesInDirection(board, rookRow, rookCol, 0, 1)
                )
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private static List<String> getMovesInDirection(char[][] board, int rookRow, int rookCol, int rowDelta, int colDelta) {
        List<String> moves = new ArrayList<>();
        int newRow = rookRow + rowDelta;
        int newCol = rookCol + colDelta;

        while (isValidMove(board, newRow, newCol)) {
            moves.add(moveNotation(rookRow, rookCol, newRow, newCol, board[newRow][newCol]));
            if (board[newRow][newCol] != ' ') {
                break;
            }
            newRow += rowDelta;
            newCol += colDelta;
        }

        return moves;
    }

    private static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    private static String moveNotation(int rookRow, int rookCol, int newRow, int newCol, char pieceAtDestination) {
        String from = "" + (char)('a' + rookCol) + (8 - rookRow);
        String to = "" + (char)('a' + newCol) + (8 - newRow);
        return (pieceAtDestination == ' ' ? "T" + from + "-" + to : "T" + from + "x" + to);
    }



    public static void main(String[] args) {
        char[][] board = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', 'R', 'R', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };

        int rookRow = 3;
        int rookCol = 3;

        List<String> moves = generateRookMoves(board, rookRow, rookCol);
        moves.forEach(System.out::println);
    }
}
