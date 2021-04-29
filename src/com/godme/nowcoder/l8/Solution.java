package com.godme.nowcoder.l8;

public class Solution {
    // 1. 二维dp可以使用二维数组记录状态
    // 2. dp变量
    //      2.1 遍历左侧位置和右侧位置，自动锁定长度，关系离散(适用全场景)
    //      2.2 遍历单边位置和回文长度，变量关系稳定，关系降维(需长度限定)
    // 3. 状态依赖: 外层结果依赖内层结果，应该先生成内层结果
    public int getLongestPalindrome(String s, int n) {
        if(n < 2){
            return n;
        }
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        // 内层字符检测以中心为基准，使用动态的边界逼近无法保证层级顺序，必须使用长度限制才能保证内层的优先
        // 实践真知: 1. 长度由小到大，才能完成由内而外 2. 动态边界无法保证中心点优先计算
        for (int length = 0; length < n; length++) {
            for (int startIndex = 0, endIndex; startIndex < n - length; startIndex++) {
                endIndex = startIndex + length;
                if(dp[startIndex][endIndex] =
                        // 字符串一定要相等
                        s.charAt(startIndex) == s.charAt(endIndex) &&
                        // 1. 单字符相等 2. 相邻对立字符相等 3. 边界回文结果为内部回文结果
                        (length < 2 || dp[startIndex+1][endIndex - 1])){
                    // 更新边界
                    max = Math.max(max, length + 1);
                }
            }
        }
        return max;
    }
}
