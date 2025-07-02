public class Undo {


    private Global g;

    Undo() {
        g = new Global();
    }

    public void redo() {

        // vhecks if the stack is empty by peeking; -2 indicates an empty stack
        if (g.stack.peek() == -2) {
            return; // exit the method if there are no actions to undo
        }

        // Pop values from the stack in reverse order of their insertion
        int i = g.stack.pop();     // row index of the last change
        int j = g.stack.pop();     // column index of the last change
        int value = g.stack.pop(); // original value of the cell before the change in the solved grid

        // restore the previous value in the user's grid (emptyGrid)
        g.emptyGrid[i][j] = value;

        // if rechecking is enabled, enqueue the cell for validation and increment the error count
        if (g.recheck) {
            g.queue.enqueue(i);
            g.queue.enqueue(j);
            g.incorrect++;
        }
    }
}
