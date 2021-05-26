package com.godme.leetcode.q64;

// 思路: 从上到下，从左到右，两个方向谁的数小走那条路
// 时间: O(mn)
// 空间: O(mn)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 1; i < m; i++){
            grid[i][0] += grid[i-1][0];
        }
        for(int i = 1; i < n; i++){
            grid[0][i] += grid[0][i-1];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
}
