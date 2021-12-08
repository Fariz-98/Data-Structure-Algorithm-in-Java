package study.java.datastructure.algo.leetcode.leetcode50;

// 200
// Medium

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0',}
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int island = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    island++;
                    BFS(grid, i, j);
                }
            }
        }

        return island;
    }

    public static void BFS(char[][] grid, int i, int j) {
        // Recursive implementation
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        // Set island to 0
        grid[i][j] = '0';

        // Up
        BFS(grid, i - 1, j);
        // Down
        BFS(grid, i + 1, j);
        // Left
        BFS(grid, i, j - 1);
        // Right
        BFS(grid, i, j + 1);
    }

}

























