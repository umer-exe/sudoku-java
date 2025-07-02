public class Input {


    private Global g;


    Input() {
        g = new Global();
    }

    // method to process user input for modifying the Sudoku grid
    public void enter(int i, int j, int value) {

        // save the current value of the cell to the stack before making changes so that if user needs to undo the vaue can be fetched again
        g.stack.push(g.emptyGrid[i][j]);

        // update the user's grid with new val
        g.emptyGrid[i][j] = value;

        // push the column index of the modified cell to the stack
        g.stack.push(j);

        // push the row index of the modified cell to the stack
        g.stack.push(i);

        // if rechecking is enabled (e.g., during validation), enqueue the cell and increment the error count
        if (g.recheck) {
            g.queue.enqueue(i); // Enqueue the row index
            g.queue.enqueue(j); // Enqueue the column index
            g.incorrect++;      // Increment the incorrect count
        }
    }
}
