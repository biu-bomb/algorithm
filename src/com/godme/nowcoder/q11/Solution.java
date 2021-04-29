package com.godme.nowcoder.q11;

import java.util.Arrays;

public class Solution {
    // dp矩阵构造: 迭代 + 缓存
    //  1. 结果缓存，直接前向查找
    //  2. 先里后外，确保优先执行依赖逻辑
    //  3. 执果索因，逆向思维，基于单分支发散
    public int minPathSum (int[][] matrix) {
        int Y = matrix.length - 1;
        int X = matrix[0].length - 1;
        int ms;
        for(int y = Y; y > -1; y--){
            for (int x = X; x > -1; x--) {
                // 双边无界，找小值
                if(y < Y && x < X){
                    ms = Math.min(matrix[y+1][x], matrix[y][x+1]);
                // 下边界，右边单项
                }else if(x < X){
                    ms = matrix[y][x+1];
                // 右边界，下边单项
                } else if(y < Y){
                    ms = matrix[y+1][x];
                // 顶点，双边界，取自身
                }else{
                    ms = 0;
                }
                // 当前节点值+下一节点到顶点的和
                matrix[y][x] += ms;
            }
        }
        return matrix[0][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                new int[]{1,3,5,9},
                {8,1,3,4},{5,0,6,1},{8,8,4,0}
        };
        printArray(matrix);
        System.err.println(solution.minPathSum(matrix));
    }

    static void printArray(int[][] array){
        for(int[] a: array){
            System.err.println(Arrays.toString(a));
        }
        System.err.println("----------------");
    }
}