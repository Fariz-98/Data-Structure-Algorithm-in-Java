package study.java.datastructure.algo.leetcode;

// 419
// Medium

import java.util.HashSet;
import java.util.Set;

public class BattleshipsInABoard {

    public static void main(String[] args) {
        char[][] board = {
                {'X','.','.','X'},
                {'.','.','.','X'},
                {'.','.','.','X'}
        };

        System.out.println(countBattleships(board));
    }

    public static int countBattleships(char[][] board) {
        int res = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X' && !visited[i][j]) {
                    res++;
                    DFS(i, j, visited, board);
                }
            }
        }

        return res;
    }

    public static void DFS(int i, int j, boolean[][] visited, char[][] board) {
        // Bound check
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length ||
                visited[i][j] || board[i][j] == '.') {
            return;
        }

        // Mark visited
        visited[i][j] = true;

        // Up
        DFS(i - 1, j, visited, board);

        // Down
        DFS(i + 1, j, visited, board);

        // Left
        DFS(i, j - 1, visited, board);

        // Right
        DFS(i, j + 1, visited, board);
    }

}
