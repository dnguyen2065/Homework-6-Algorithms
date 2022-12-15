import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // Q1-----------------------------
        nQueens nq = new nQueens();
        int[] board = { 1, 6, 8, 3, 7, 4, 2, 5 };

        int n = 8;
        System.out.println(nq.isLegalPosition(board, n));

        // Q2-----------------------------
        System.out.println(Arrays.toString(nq.nextLegalPosition(board, n)));
        // Q3-----------------------------

        for (int i = 4; i <= 14; i++) {
            int[] board2 = new int[i];
            List<List<Integer>> solutions = new ArrayList<>();
            List<Integer> first = nq.nqueens4100(i, 0, board2, solutions).get(0);
            System.out.println("First Solution in lexicographic order for the amount of queens " + i + ": " + first);
        }
        // Q4-----------------------------
        for (int i = 4; i <= 14; i++) {
            int[] board2 = new int[i];
            List<List<Integer>> solutions = new ArrayList<>();
            int sizeOfGivenSoln = nq.nqueens4100(i, 0, board2, solutions).size();
            System.out.println("There are " + sizeOfGivenSoln + " solutions for " + i + "queens.");
        }
    }
}
