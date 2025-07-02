import java.util.Scanner;

public class ConsoleUI {

    ConsoleUI() {

        Scanner s = new Scanner(System.in);
        Global g = new Global();
        Print p = new Print();
        Input in = new Input();
        Undo u = new Undo();
        Validate v = new Validate();
        RemoveCells r = new RemoveCells();
        boolean found  = false;

        p.title3();
        System.out.print(
                "\t\t\t\t\t\t\t\tWelcome to Sudoku!" +
                        "\n\n\t\t\t\t\t\t\t\t1.   Beginner" +
                        "\n\t\t\t\t\t\t\t\t2.   Easy" +
                        "\n\t\t\t\t\t\t\t\t3.   Medium" +
                        "\n\t\t\t\t\t\t\t\t4.   Hard" +
                        "\n\t\t\t\t\t\t\t\t5.   Exit" +
                        "\n\n\t\t\t\t\t\t\t\t->   "
        );
        int choice = s.nextInt();

        switch (choice) {
            case 0 -> r.remove(0);
            case 1 -> r.remove(1);
            case 2 -> r.remove(2);
            case 3 -> r.remove(3);
            case 4 -> r.remove(4);
            case 5 -> {return;}
            case 6 -> r.remove(6);
        }
        System.out.println("\n\n\n");

        while (true) {

            System.out.println();
            p.format1();

            while (true) {
                try {
                    System.out.print("\n\nEnter Row, Column, Answer (eg. 1,2,3). To exit enter '0', and to undo enter 'u':  ");
                    String answer = s.next();
                    String[] ijv = answer.split(",");

                    if (ijv[0].equals("u")) {
                        u.redo();

                    } else if (ijv[0].equals("p")) {
                        for (int i = 0; i < 9; i++) {
                            for (int j = 0; j < 9; j++) {
                                System.out.print(g.grid[i][j] + " ");
                            }
                            System.out.println();
                        }
                        System.out.println();

                        for (int i = 0; i < 9; i++) {
                            for (int j = 0; j < 9; j++) {
                                System.out.print(g.emptyGrid[i][j] + " ");
                            }
                            System.out.println();
                        }
                        continue;

                    } else if (ijv[0].equals("q")) {
                        g.queue.print();
                        continue;

                    } else if (Integer.parseInt(ijv[0]) == 0) {
                        return;

                    } else if (g.emptyGrid[Integer.parseInt(ijv[0]) - 1][Integer.parseInt(ijv[1]) - 1] == 0) {
                        System.out.println("\nCannot change an anchor.");
                        continue;

                    } else if (Integer.parseInt(ijv[0]) > 9 || Integer.parseInt(ijv[0]) < 1 || Integer.parseInt(ijv[1]) > 9 || Integer.parseInt(ijv[1]) < 1){
                        System.out.println("\nThere are only 9 rows and 9 columns.");
                        continue;

                    } else if (Integer.parseInt(ijv[2]) > 9 || Integer.parseInt(ijv[2]) < 1){
                        System.out.println("\nEnter number between 1-9.");
                        continue;

                    } else {
                        in.enter(Integer.parseInt(ijv[0]) - 1, Integer.parseInt(ijv[1]) - 1, Integer.parseInt(ijv[2]));
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Enter a suitable answer");
                }
            }


            for (int i = 0; i < 9; i++) {
                int j;

                for (j = 0; j < 9; j++) {
                    if (Global.emptyGrid[i][j] == -1) {
                        found = true;
                        break;
                    }
                    found = false;
                }

                if (j != 9) {
                    break;
                }
            }

            if (found) {
                continue;
            }

            if (!found) {
                if (v.check() == 0) {
                    System.out.println("\n\n");
                    p.format2();
                    System.out.print("\t\t\t\t\t\t\t\t\t   You Win");
                    return;
                }

                g.recheck = true;
                System.out.println("\nThere are " + g.incorrect + " mistake, recheck.");
            }
        }
    }
}
