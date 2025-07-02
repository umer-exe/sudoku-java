import java.util.HashSet;
import java.util.Set;

public class Generate {

    // represents the 9x9 Sudoku grid
    private int[][] grid;

    // initialize the grid
    Generate() {
        grid = new int[9][9];
    }

    public int[][] createPuzzle() {
        int i = 0; // counter for the number of initial random numbers added

        // places random numbers in the first and last cells of the grid
        grid[0][0] = (int) (Math.random() * 9); // top-left corner
        grid[8][8] = (int) (Math.random() * 9); //

        // add 5 more random numbers to the grid at random positions
        while (i < 5) {
            int row = (int) (Math.random() * 9); // Random row (0-8)
            int col = (int) (Math.random() * 9); // Random column (0-8)
            int num = (int) (Math.random() * 9); // Random number (1-9)

            // check if the number can be placed at the position
            if (check(row, col, num)) {
                grid[row][col] = num; //
                i++; //
            }
        }

        // recurisve call to fill the rest of the grid
        generatePuzzle();
        return grid; // returns the completed puzzle
    }

    //recursive method that filles the puzzle
    private boolean generatePuzzle() {
        int[] emptyCell = emptyCell(); // finds the next emppty cell

        // this is the base case, if no empty cells remain then the puzzle is complete
        if (emptyCell == null) {
            return true;
        }

        int i = emptyCell[0]; // row index of the empty cell
        int j = emptyCell[1]; // col index of the empty cell

        // try placing numbers 1 through 9 in the empty cell
        for (int num = 1; num < 10; num++) {
            if (check(i, j, num)) { // checks if the number is valid
                grid[i][j] = num; // places if valid

                // recursively attempts to fill the rest of the grid
                if (forwardCheck() && generatePuzzle()) {
                    return true;
                }

                // if invalid/false then it backtracks by resetting the cell
                grid[i][j] = 0;
            }
        }

        // return false if no valid placement is found for this cell
        return false;
    }

    // checking method to ensure all empty cells have valid options
    private boolean forwardCheck() {
        // iterates through all cells in the grid
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (grid[i][j] == 0) { // If the cell is empty
                    Set<Integer> domain = new HashSet<>(); // set to store possible values

                    // populate the set with numbers 1 through 9
                    for (int k = 1; k < 10; k++) {
                        domain.add(k);
                    }

                    // remove numbers already in the same row or column
                    for (int k = 0; k < 9; k++) {
                        domain.remove(grid[i][k]); // row
                        domain.remove(grid[k][j]); // column
                    }

                    // remove numbers already in the same 3x3 subgrid
                    int startRow = (i / 3) * 3; // Top-left row index of the subgrid
                    int startCol = (j / 3) * 3; // Top-left column index of the subgrid
                    for (int l = 0; l < 3; l++) {
                        for (int m = 0; m < 3; m++) {
                            domain.remove(grid[startRow + l][startCol + m]);
                        }
                    }

                    // If no valid values remain, forward checking fails
                    if (domain.isEmpty()) {
                        return false;
                    }
                }
            }
        }

        // Forward checking passes if all empty cells have valid options
        return true;
    }

    // checks if a number can be placed in a specific position
    private boolean check(int row, int col, int num)
    {
        // check if the number is already in the same row or column
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == num || grid[i][col] == num) {
                return false; // return false if the number exists
            }
        }

        // Check if the number is already in the same 3x3 subgrid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[startRow + i][startCol + j] == num) {
                    return false; // Return false if the number exists
                }
            }
        }

        // Return true if the number can be placed
        return true;
    }

    // find the next empty cell in the grid
    private int[] emptyCell() {
        // iterate through all cells in the grid
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) { // Check if the cell is empty
                    return new int[]{row, col}; // Return the coordinates of the empty cell
                }
            }
        }

        // Return null if no empty cells remain
        return null;
    }
}
