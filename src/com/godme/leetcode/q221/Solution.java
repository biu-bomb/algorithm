package com.godme.leetcode.q221;

/**
 * 题目核心: 如何对已经计算出的结果进行复用，直接计算双边需要循环
 * 将边长存储在右下角：
 *      1. 右下角，为1才有意义，并天然+1
 *      2. 左侧限制扩展长度
 *      3. 上面限制扩展长度
 *      4. 对角限制扩展长度
 * 因为是正方形，扩展长度必然是三者最小值，并且自身+1能够在此基础上直接扩展
 *
 * 为什么是右下角：
 *      1. 作为迭代计算最新层级
 *      2. 对角作为初始，向新一级迭代
 *
 * 因此，并不限定是右下角，四个角都可以，关键在于从哪个角开始生成
 */

// 思路: 根据扩展限制，迭代生成结果
// 时间: O(mn)
// 空间: O(mn)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // 必须为1
                if (matrix[i][j] == '1') {
                    // 顶边，最小扩展长度为0
                    // 并且数据查询越界，无法直接查询，单独处理
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // 三边限制+自身扩展1
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}