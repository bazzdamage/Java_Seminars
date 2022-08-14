public class Sem03_KnightProblem {
    public static void main(String[] args) {
        int n = 5;
        solveKnight(n);
    }
    static void solveKnight(int n) {
        int[][] sol = new int[n][n];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                sol[x][y] = -1;
            }
        }
        int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1 };
        int x = n/2;
        int y = n/2;
        sol[x][y] = 0;

        if (!KnightTourSolver(n,x, y, 1, sol, xMove, yMove))
            System.out.println("Solution does not exist");
        else printSolution(sol);
    }
    static boolean KnightTourSolver(int n, int x, int y, int moveCounter, int[][] sol, int[] xMove, int[] yMove) {
        int k, nextX, nextY;
        if (moveCounter == n * n) return true;

        for (k = 0; k < 8; k++) {
            nextX = x + xMove[k];
            nextY = y + yMove[k];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && sol[nextX][nextY] == -1) {
                sol[nextX][nextY] = moveCounter;
                if (KnightTourSolver(n, nextX, nextY, moveCounter + 1, sol, xMove, yMove)) return true;
                else sol[nextX][nextY] = -1; // backtracking
            }
        }
        return false;
    }
    static void printSolution(int[][] sol) {
        int n = sol.length;
        for (int[] ints : sol) {
            for (int y = 0; y < n; y++)
                System.out.print(String.format("%03d", ints[y]) + " ");
            System.out.println();
        }
    }
}
