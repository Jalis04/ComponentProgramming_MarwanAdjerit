package org.example;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class SudokuBoardTest {
    //private SudokuBoard board;


    @Test
    @DisplayName("Fill board generates correct digits layout")
    public void testFillBoardGeneratesCorrectDigitsLayout() {
       /* board.fillBoard();
        int[][] actualBoard = board.getBoard();*/
        SudokuBoard board = new SudokuBoard();
        board.fillBoard();
        int[][] actualBoard = board.getBoard();


        // Check rows
        for (int row = 0; row < SudokuBoard.BOARD_SIZE; row++) {
            int[] expectedRow = {1, 2, 3, 4, 5, 6, 7, 8, 9};//only one of each in a row
            int[] actualRow = actualBoard[row].clone();
            Arrays.sort(actualRow);
            assertArrayEquals(expectedRow, actualRow, "Row " + (row + 1) + " is incorrect");
        }

        // Check columns
        for (int col = 0; col < SudokuBoard.BOARD_SIZE; col++) {
            int[] expectedCol = {1, 2, 3, 4, 5, 6, 7, 8, 9}; //only one of each in a col
            int[] actualCol = new int[SudokuBoard.BOARD_SIZE];
            for (int row = 0; row < SudokuBoard.BOARD_SIZE; row++) {
                actualCol[row] = actualBoard[row][col];
            }
            Arrays.sort(actualCol);
            assertArrayEquals(expectedCol, actualCol, "Column " + (col + 1) + " is incorrect");
        }

        // Check boxes
        for (int boxRow = 0; boxRow < SudokuBoard.BOARD_SIZE; boxRow += SudokuBoard.BOX_SIZE) {
            for (int boxCol = 0; boxCol < SudokuBoard.BOARD_SIZE; boxCol += SudokuBoard.BOX_SIZE) {
                int[] expectedBox = {1, 2, 3, 4, 5, 6, 7, 8, 9}; //only one of each in a subgrid
                int[] actualBox = new int[SudokuBoard.BOARD_SIZE];
                int index = 0;
                for (int row = boxRow; row < boxRow + SudokuBoard.BOX_SIZE; row++) {
                    for (int col = boxCol; col < boxCol + SudokuBoard.BOX_SIZE; col++) {
                        actualBox[index++] = actualBoard[row][col];
                    }
                }
                Arrays.sort(actualBox);
                assertArrayEquals(expectedBox, actualBox, "Box at (" + boxRow + ", " + boxCol + ") is incorrect");
            }
        }
    }

    @RepeatedTest(2)
    @DisplayName("Two subsequent calls of fillBoard generate different digits layout")
    public void testFillBoardGeneratesDifferentDigitsLayout() {
        SudokuBoard board1 = new SudokuBoard();
        board1.fillBoard();

        SudokuBoard board2 = new SudokuBoard();
        board2.fillBoard();

        assertNotEquals(board1, board2);


    }
}
