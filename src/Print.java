public class Print {

    private static int count = 1;
    private Global g;

    Print() {
        g = new Global();
    }

    public void title1() {
        System.out.println(
                "\n" +
                        "\t\t                                                                           \n" +
                        "\t\t ad88888ba                         88               88                     \n" +
                        "\t\td8\"     \"8b                        88               88                     \n" +
                        "\t\tY8,                                88               88                     \n" +
                        "\t\t`Y8aaaaa,    88       88   ,adPPYb,88   ,adPPYba,   88   ,d8  88       88  \n" +
                        "\t\t  `\"\"\"\"\"8b,  88       88  a8\"    `Y88  a8\"     \"8a  88 ,a8\"   88       88  \n" +
                        "\t\t        `8b  88       88  8b       88  8b       d8  8888[     88       88  \n" +
                        "\t\tY8a     a8P  \"8a,   ,a88  \"8a,   ,d88  \"8a,   ,a8\"  88`\"Yba,  \"8a,   ,a88  \n" +
                        "\t\t \"Y88888P\"    `\"YbbdP'Y8   `\"8bbdP\"Y8   `\"YbbdP\"'   88   `Y8a  `\"YbbdP'Y8  \n" +
                        "\t\t                                                                           \n" +
                        "\t\t                                                                           \n"
        );
    }


    public void title2() {
        System.out.println(
                "\n" +
                        "\t\t\t\t\t    ______           _       _           \n" +
                        "\t\t\t\t\t   / _____)         | |     | |          \n" +
                        "\t\t\t\t\t  ( (____  _   _  __| | ___ | |  _ _   _ \n" +
                        "\t\t\t\t\t   \\____ \\| | | |/ _  |/ _ \\| |_/ ) | | |\n" +
                        "\t\t\t\t\t   _____) ) |_| ( (_| | |_| |  _ (| |_| |\n" +
                        "\t\t\t\t\t  (______/|____/ \\____|\\___/|_| \\_)____/ \n" +
                        "\t\t\t\t\t                                         \n"
        );
    }


    public void title3() {
        System.out.println(
                "\n" +
                        "\t ░▒▓███████▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓███████▓▒░ ░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ \n" +
                        "\t░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ \n" +
                        "\t░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ \n" +
                        "\t ░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓███████▓▒░░▒▓█▓▒░░▒▓█▓▒░ \n" +
                        "\t       ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ \n" +
                        "\t       ░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ \n" +
                        "\t░▒▓███████▓▒░ ░▒▓██████▓▒░░▒▓███████▓▒░ ░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░  \n" +
                        "\t                                                                                \n" +
                        "\t                                                                                \n"
        );
    }


    public void format1() {

        count = 1;

        System.out.println("\t\t\t\t\t\t\t    1 2 3   4 5 6   7 8 9");
        System.out.println("\t\t\t\t\t\t\t  ╔═══════════════════════╗");

        for (int i = 0; i < 9; i++) {

            System.out.print("\t\t\t\t\t\t\t" + count + " ║ ");

            for (int j = 0; j < 9; j++) {

                if (g.emptyGrid[i][j] == 0) {
                    System.out.print(g.grid[i][j] + " ");
                } else if (g.emptyGrid[i][j] == -1){
                    System.out.print("  ");
                } else {
                    System.out.print(g.emptyGrid[i][j] + " ");
                }

                if ((j + 1) % 3 == 0 && j < 8) {
                    System.out.print("║ ");
                }
            }

            System.out.println("║ " + count);
            count++;

            if ((i + 1) % 3 == 0 && i < 8) {
                System.out.println("\t\t\t\t\t\t\t  ║═══════════════════════║");
            }
        }

        System.out.println("\t\t\t\t\t\t\t  ╚═══════════════════════╝");
        System.out.println("\t\t\t\t\t\t\t    1 2 3   4 5 6   7 8 9");
    }


    public void format2() {

        count = 1;

        System.out.println("\t\t\t\t\t\t\t  ╔═══════════════════════╗");

        for (int i = 0; i < 9; i++) {

            System.out.print("\t\t\t\t\t\t\t  ║ ");

            for (int j = 0; j < 9; j++) {

                System.out.print(g.grid[i][j] + " ");

                if ((j + 1) % 3 == 0 && j < 8) {
                    System.out.print("║ ");
                }
            }

            System.out.println("║");
            count++;

            if ((i + 1) % 3 == 0 && i < 8) {
                System.out.println("\t\t\t\t\t\t\t  ║═══════════════════════║");
            }
        }

        System.out.println("\t\t\t\t\t\t\t  ╚═══════════════════════╝");
    }
}
