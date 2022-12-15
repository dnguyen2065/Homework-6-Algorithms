import java.util.ArrayList;
import java.util.List;

public class nQueens {

    public boolean isLegalPosition(int[] board, int n) {
        for (int i = 0; i < n; i++) {
            if (board[i] != 0) {
                for (int j = i + 1; j < n; j++) {
                    if (board[j] != 0) {

                        if (board[i] == board[j]) {
                            return false;
                        }
                        if (Math.abs(board[i] - board[j]) == Math.abs(i - j)) {
                            return false;
                        }
                    }
                }
            }

        }
        return true;
    }

    public int[] nextLegalPosition(int[] board, int n) {
        // next legal position from legal partial position
        int[] nextBoard = new int[n];
        int illegalPartPos = 0;
        int legalPartPos = 0;
        int accum = 0;
        for (int i = 0; i < n; i++) {
            if (board[i] != 0) {
                accum++;

            } else {
                nextBoard[i] = board[i];
            }
        }
        if (!isLegalPosition(board, n) && accum < n) {
            for (int i = 0; i < n; i++) {
                if (board[i] == 0) {
                    illegalPartPos = i - 1;
                    break;
                }
            }
            for (int i = 1; i <= n; i++) {
                board[illegalPartPos] = i;
                if (isLegalPosition(board, n)) {
                    return board;
                }
            }
        }
        if (isLegalPosition(board, n) && accum < n) {
            for (int i = 0; i < n; i++) {
                if (board[i] == 0) {
                    legalPartPos = i;
                    break;
                }
            }
            for (int i = 1; i <= n; i++) {
                board[legalPartPos] = i;
                if (isLegalPosition(board, n)) {
                    return board;
                }
            }
        }
        // last part
        if (accum == n) {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = board[i] + 1; j <= n; j++) {
                    board[i] = j;
                    if (isLegalPosition(board, n)) {
                        return board;
                    }
                }
                board[i] = 0;
            }
        }
        return board;
    }

    public List<List<Integer>> nqueens4100(int n, int currRow, int[] board, List<List<Integer>> result) {
        if (currRow == n) {
            List<Integer> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(board[i]);
            }
            result.add(solution);
            return result;
        }
        for (int i = 1; i <= n; i++) {
            board[currRow] = i;
            if (isLegalPosition(board, n)) {
                nqueens4100(n, currRow + 1, board, result);
            }
        }
        board[currRow] = 0;
        return result;
    }

}
