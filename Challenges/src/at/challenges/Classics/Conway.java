package at.challenges.Classics;

public class Conway {

    public static final String CYAN_BOLD = "\033[1;36m"; ;

    private int generations;
    private int size;

    public Conway(int size, int generations) {
        setSize(size);
        setGenerations(generations);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getGenerations() {
        return generations;
    }

    public void setGenerations(int generations) {
        this.generations = generations;
    }

    public void runSimulation() throws InterruptedException {
        var m = generateRandomMatrix();

        for (int i = 0; i < generations; i++) {
            System.out.println(CYAN_BOLD);
            System.out.println("\tGeneration " + (i + 1));
            Thread.sleep(1000);
            m = generateNextGeneration(m);
            printMatrix(m);
            Thread.sleep(1000);
            System.out.println();
        }
    }

    public boolean[][] generateRandomMatrix() {
        boolean[][] matrix = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                var rand = Math.random();
                if (rand > 0.5) {
                    matrix[i][j] = true;
                }
            }
        }
        return matrix;
    }

    private void printMatrix(boolean[][] matrix) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j]) {
                    System.out.print(" x ");
                } else {
                    System.out.print(" _ ");
                }
            }
            System.out.println();
        }
    }

    private boolean[][] generateNextGeneration(boolean[][] matrix) {
        int size = matrix[0].length;
        boolean[][] nextGeneration = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int neighbours = getScore(matrix, i, j);

                if (neighbours < 2 && neighbours > 3) {
                    nextGeneration[i][j] = false;
                } else if (neighbours == 2 || neighbours == 3) {
                    nextGeneration[i][j] = true;
                } else if (neighbours == 3) {
                    nextGeneration[i][j] = true;
                }
            }
        }
        return nextGeneration;
    }

    private int getScore(boolean[][] matrix, int row, int col) {
        int score = 0;
        int i,j;

        for (i = row - 1; i < (row + 2); i++) {
            for (j = col - 1; j < (col + 2); j++) {
                boolean isOut = i < 0 || i >= size || j < 0 || j >= size;
                if (!isOut && matrix[i][j]) {
                    score++;
                }
            }
        }
        if (matrix[row][col]) {
            score--;
        }
        return score;
    }
}
