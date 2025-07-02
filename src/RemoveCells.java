public class RemoveCells {


    private Global g;

    // initializes the Global instance
    RemoveCells() {
        g = new Global();
    }

    // method to remove cells from the Sudoku grid based on the difficulty level
    public void remove(int level) {

        // Set the number of cells to remove based on the difficulty level
        switch (level) {
            case 0 -> g.incorrect = 1;
            case 1 -> g.incorrect = 24;
            case 2 -> g.incorrect = 37;
            case 3 -> g.incorrect = 46;
            case 4 -> g.incorrect = 55;
            case 6 -> g.incorrect = 2;
        }

        // loop to remove the specified number of cells
        for (int i = 0; i < g.incorrect; i++) {
            int row, col;

            // Randomly select a cell until an empty cell is found
            do {
                row = (int) (Math.random() * 9);
                col = (int) (Math.random() * 9);
            } while (g.emptyGrid[row][col] == 1); // ensures the cell isnt already removed

            // mark the selected cell as empty by setting its value to -1
            g.emptyGrid[row][col] = -1;

            // Add the coordinates of the removed cell to the queue for tracking
            g.queue.enqueue(row); // enqueue the row index
            g.queue.enqueue(col);
        }
    }
}
