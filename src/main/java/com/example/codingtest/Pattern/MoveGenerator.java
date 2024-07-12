package com.example.codingtest.Pattern;

import java.util.List;

public class MoveGenerator {

    private MoveStrategy strategy;

    public MoveGenerator(MoveStrategy strategy) {
        this.strategy = strategy;
    }

    public List<String> generateMoves(char[][] board, int rookRow, int rookCol) {
         return strategy.generateRookMoves(board,rookRow,rookCol);
    }
}
