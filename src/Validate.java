public class Validate {

    // reference to the Global class for accessing shared variables and structures
    private Global g;

    // initializes the Global instance
    Validate() {
        g = new Global();
    }

    // method to validate the user's inputs
    public int check() {

        // get the size of the queue (number of elements to check)
        int l = g.queue.size;

        // loop through the elements in the queue, two at a time (row and column indices)
        for (int k = 0; k < l; k = k + 2) {

            // dequeue the row and column indices of a cell
            int i = g.queue.dequeue();
            int j = g.queue.dequeue();

            // compare the values
            if (g.grid[i][j] != g.emptyGrid[i][j]) {
                // if the values do not match, re-enqueue the cell for future validation
                g.queue.enqueue(i); // Re-enqueue row index
                g.queue.enqueue(j);

            } else {
                // ff the values match, decrement the incorrect count
                g.incorrect--;
            }
        }

        // return the number of incorrect entries remaining
        return g.incorrect;
    }
}
