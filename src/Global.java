public class Global {

    public static int[][] grid;
    public static int[][] emptyGrid;
    public static Stack stack;
    public static Queue queue;
    public static int incorrect;
    public static boolean recheck;

    Global() {
        grid = new int[9][9];
        emptyGrid = new int[9][9];
        stack = new Stack(0);
        queue = new Queue(0);
        incorrect = 0;
        recheck = false;
        grid = new Generate().createPuzzle();
    }
}
