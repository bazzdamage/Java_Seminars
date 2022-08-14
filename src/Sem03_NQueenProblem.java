import java.util.ArrayList;
import java.util.List;

public class Sem03_NQueenProblem {
    static int queens = 1;
    static int[][] board = new int[queens][queens];
    static List<List<String>> sol = new ArrayList<>();
    public static List<List<String>> main(String[] args) {

        solveNQueen(board, 0);
        return sol;

    }
    static boolean solveNQueen(int[][] board, int col){

        if(col >= queens) return true;

        for (int i = 0; i < queens; i++) {
            if(isSafe(board, i, col)) {
                board[i][col] = 1;
                if(solveNQueen(board,col + 1)) sol.add(leetCodeSolution(board));
                board[i][col] = 0;
            }
        }
        return false;
    }
    static boolean isSafe(int[][] board, int row, int col){
        int i, j;
        for (i = 0; i < col; i++)
            if (board[row][i] == 1) return false;
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;
        for (i = row, j = col; j >= 0 && i < queens; i++, j--)
            if (board[i][j] == 1) return false;
        return true;
    }

    static ArrayList<String> leetCodeSolution(int[][] board){
        StringBuilder sb = new StringBuilder();
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < queens; i++) {
            for (int j = 0; j < queens; j++) {
                if (board[i][j] == 1) sb.append('Q');
                else sb.append('.');
            }
            temp.add(sb.toString());
            sb.setLength(0);
        }
        return temp;
    }
}
