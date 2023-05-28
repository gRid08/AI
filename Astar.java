import java.util.*;

class AStarAlgorithm {

    static int g = 0;

    public static void print(int[][] puzzle) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (puzzle[i][j] == -1) {
                    System.out.print("_ ");
                } else {
                    System.out.print(puzzle[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void moveLeft(int[][] start, int row, int col) {
        int temp = start[row][col];
        start[row][col] = start[row][col - 1];
        start[row][col - 1] = temp;
    }

    public static void moveRight(int[][] start, int row, int col) {
        int temp = start[row][col];
        start[row][col] = start[row][col + 1];
        start[row][col + 1] = temp;
    }

    public static void moveUp(int[][] start, int row, int col) {
        int temp = start[row][col];
        start[row][col] = start[row - 1][col];
        start[row - 1][col] = temp;
    }

    public static void moveDown(int[][] start, int row, int col) {
        int temp = start[row][col];
        start[row][col] = start[row + 1][col];
        start[row + 1][col] = temp;
    }

    public static void copy(int[][] temp, int[][] real) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = real[i][j];
            }
        }
    }

    public static int heuristic(int[][] start, int[][] goal) {
        int h = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (start[i][j] != goal[i][j] && start[i][j] != -1) {
                    int targetRow = (start[i][j] - 1) / 3;
                    int targetCol = (start[i][j] - 1) % 3;
                    h += Math.abs(targetRow - i) + Math.abs(targetCol - j);
                }
            }
        }
        return h + g;
    }

    public static void moveTile(int[][] start, int[][] goal) {
        int emptyRow = 0, emptyCol = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (start[i][j] == -1) {
                    emptyRow = i;
                    emptyCol = j;
                    break;
                }
            }
        }

        int[][] t1 = new int[3][3];
        int[][] t2 = new int[3][3];
        int[][] t3 = new int[3][3];
        int[][] t4 = new int[3][3];
        int f1 = Integer.MAX_VALUE, f2 = Integer.MAX_VALUE,
                f3 = Integer.MAX_VALUE, f4 = Integer.MAX_VALUE;
        copy(t1, start);
        copy(t2, start);
        copy(t3, start);
        copy(t4, start);

        if (emptyCol - 1 >= 0) {
            moveLeft(t1, emptyRow, emptyCol);
            f1 = heuristic(t1, goal);
        }

        if (emptyCol + 1 < 3) {
            moveRight(t2, emptyRow, emptyCol);
            f2 = heuristic(t2, goal);
        }

        if (emptyRow + 1 < 3) {
            moveDown(t3, emptyRow, emptyCol);
            f3 = heuristic(t3, goal);
        }

        if (emptyRow - 1 >= 0) {
            moveUp(t4, emptyRow, emptyCol);
            f4 = heuristic(t4, goal);
        }

        // Find the state with the least heuristic value and make the move
        if (f1 <= f2 && f1 <= f3 && f1 <= f4) {
            moveLeft(start, emptyRow, emptyCol);
        } else if (f2 <= f1 && f2 <= f3 && f2 <= f4) {
            moveRight(start, emptyRow, emptyCol);
        } else if (f3 <= f1 && f3 <= f2 && f3 <= f4) {
            moveDown(start, emptyRow, emptyCol);
        } else {
            moveUp(start, emptyRow, emptyCol);
        }
    }

    public static void solveEight(int[][] start, int[][] goal) {
        g++;
        moveTile(start, goal);
        print(start);

        int f = heuristic(start, goal);
        if (f == g) {
            System.out.println("Reached the goal state! Steps: " + g);
            return;
        }
        solveEight(start, goal);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[][] start = new int[3][3];
        int[][] goal = new int[3][3];

        System.out.println("Enter Initial Configuration: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                start[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter Final Configuration: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                goal[i][j] = sc.nextInt();
            }
        }

        System.out.println("Initial Configuration:");
        print(start);
        solveEight(start, goal);
    }
}
