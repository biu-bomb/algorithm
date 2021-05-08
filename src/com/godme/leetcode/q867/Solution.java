package com.godme.leetcode.q867;

class Solution {
    public int[][] transpose(int[][] matrix) {
        int Y = matrix.length, X = matrix[0].length;
        int[][] res = new int[X][Y];
        for(int x = 0; x < X; x ++){
            for(int y = 0; y < Y; y++){
                res[x][y] = matrix[y][x];
            }
        }
        return res;
    }
}