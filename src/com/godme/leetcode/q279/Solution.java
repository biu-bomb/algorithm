package com.godme.leetcode.q279;


import java.util.Arrays;

/**
 * 主体关系: f(x) = min(f(i) + f(x - i))
 * 特殊数据: n ^ 2 = m, f(m) = 1
 * 顺序生成: 从小数开始生成，确保f(i)|i<x 必定存在
 * 标志数据: 默认最大值，统一min
 */

// 思路: 顺序生成
// 时间: O(n ^ 2)
// 空间: O(n)
class Solution {
    boolean[] square;
    int[] res;
    public int numSquares(int n) {
        int length = n + 1;
        square = new boolean[length];
        for(int i=0, t; (t = i * i) < length; i++){
            square[t] = true;
        }
        res = new int[length];
        Arrays.fill(res, 10000);
        res[0] = 0;res[1]=1;
        for(int i = 2; i < length; i++){
            if(square[i]){
                res[i] = 1;
            } else {
                for(int j = 0; j < i; j++){
                    res[i] = Math.min(res[i], res[j] + res[i - j]);
                }
            }
        }
        return res[n];
    }
}