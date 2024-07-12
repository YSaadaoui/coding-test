package com.example.codingtest.Pattern;

import java.util.List;

public class MoveGeneratorTest {
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


        MoveStrategyImpl rookStrategy = new MoveStrategyImpl();
        MoveGenerator generator = new MoveGenerator(rookStrategy);


        List<String> moves = generator.generateMoves(board, 3, 3);


        for (String move : moves) {
            System.out.println(move);
        }
    }
}
