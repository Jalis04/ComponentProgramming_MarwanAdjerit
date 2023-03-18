package org.example;

import java.util.Random;

//I couldn't figure out if we had to provide a partly complete Sudoku or an empty array, so I chose the empty array.

public class SudokuBoard {
    public static final int BOARD_SIZE = 9;//size of the board is 9x9, 9 rows and 9 columns
    public static final int BOX_SIZE = 3;//Size of the 3x3 subgrid
    public static final int EMPTY_CELL = 0;//An empty cell is represented by a zero
    private int[][] board; //The board is represented by a 2D array of integers, must be private according to the UML

    public SudokuBoard(/*int[][] startingBoard*/) {
        board = new int[BOARD_SIZE][BOARD_SIZE];
        /*if (startingBoard.length != BOARD_SIZE || startingBoard[0].length != BOARD_SIZE) {
            throw new IllegalArgumentException("Invalid starting board size");
        }
        this.board = startingBoard;*/
    }//Constructor method initializes the board as empty

    //Recursive method to fill the board with valid digits,...
    // ...calls itself recursively but starts with a call to the upper-left/first cell (0,0)
    public void fillBoard() {
        fillBoardRec(0, 0);
    } //Must be public and return void according to the UML

    private boolean fillBoardRec(int row, int col) {
        // Base case: we have filled all cells in the board
        if (row == BOARD_SIZE) {
            return true;
        }

        // Calculate the next row and column
        //I use a ternary operator to check if we have filled all columns in the current row, if so, we move to the next row
        //the syntax is: condition ? expression1 : expression2;
        int nextRow = col == BOARD_SIZE - 1 ? row + 1 : row;
        int nextCol = (col + 1) % BOARD_SIZE; // using % we make sure to stay in the boundary of the current subgrid

        // If the current cell is already filled/not empty, skip to the next one
        if (board[row][col] != EMPTY_CELL) {
            return fillBoardRec(nextRow, nextCol);
        }

        // Try all possible values for the current cell
        //I looked this up during a tutorial, I struggled to make two consecutive boards different...
        //..after two fillBoard calls, but using Random and this way of checking if a value is already used, it worked
        Random random = new Random();
        boolean[] usedValues = new boolean[BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            int value = random.nextInt(BOARD_SIZE) + 1;
            if (usedValues[value - 1]) {
                continue;
            }
            usedValues[value - 1] = true;
            board[row][col] = value;
            if (isValid(row, col) && fillBoardRec(nextRow, nextCol)) {
                return true;
            }
        }

        // No valid value was found for the current cell, backtrack
        board[row][col] = EMPTY_CELL;
        return false;
    }
    //method to make sure any given number is not repeated in the same row, column or subgrid
    private boolean isValid(int row, int col) {
        // Check row
        for (int j = 0; j < BOARD_SIZE; j++) {
            if (j != col && board[row][j] == board[row][col]) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (i != row && board[i][col] == board[row][col]) {
                return false;
            }
        }

        // Check box
        int boxRow = (row / BOX_SIZE) * BOX_SIZE;
        int boxCol = (col / BOX_SIZE) * BOX_SIZE;
        for (int i = boxRow; i < boxRow + BOX_SIZE; i++) {
            for (int j = boxCol; j < boxCol + BOX_SIZE; j++) {
                if (i != row && j != col && board[i][j] == board[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }

    //useful for testing and comparing boards in their entirety
    //this method returns the entire board as a 2D array but filled with values if called after fillBoard()
    //I don't think it was necessary to implement according to the checklist, but I made it anyway
    public int[][] getBoard() {
        return board;
    }

    //useful for testing and comparing individual cells using coordinates
    //this method takes the coordinates(row and column) of a cell and returns its value
    public int getCellValue(int row, int col) {
        return board[row][col];
    }

    //method to display the board in the console for manual testing purposes and Quality of Life I suppose.
    public void displayBoard(){

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

