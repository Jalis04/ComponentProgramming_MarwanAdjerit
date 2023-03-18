package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Sudoku");

        /*int[][] startingBoard = {
                {0, 2, 0, 0, 0, 0, 0, 5, 0},
                {0, 0, 7, 4, 8, 0, 0, 0, 6},
                {0, 0, 0, 0, 0, 5, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 0},
                {0, 0, 0, 0, 0, 0, 6, 0, 8},
                {0, 0, 0, 0, 9, 0, 0, 0, 0},
                {0, 0, 0, 7, 0, 9, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 0, 0, 0, 0, 0, 4}
        };*/

        SudokuBoard s1 = new SudokuBoard(/*startingBoard*/);
        SudokuBoard s2 = new SudokuBoard(/*startingBoard*/);

        s1.fillBoard();
        s2.fillBoard();

        System.out.println("First Board");
        s1.displayBoard();
        System.out.println("second Board");
        s2.displayBoard();
    }
}