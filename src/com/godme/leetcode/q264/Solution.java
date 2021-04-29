package com.godme.leetcode.q264;

class Solution {
    // 未知长度或者超长数据，迭代生成
    // 确定短长度，生成后查询
    public int nthUglyNumber(int n) {
        int[] results = new int[n+1];
        results[1] = 1;
        int p2 = 1, p3 =1, p5 = 1;
        int r2, r3, r5, ri;
        for (int i = 2; i <=n ; i++){
            r2 = results[p2] * 2;
            r3 = results[p3] * 3;
            r5 = results[p5] * 5;
            ri = Math.min(r2, Math.min(r3, r5));
            if(ri == r2){
                p2 += 1;
            }
            if(ri == r3){
                p3 += 1;
            }
            if(ri == r5){
                p5 += 1;
            }
            results[i] = ri;
        }
        return results[n];
    }

    public static void main(String[] args) {
        System.err.println(new Solution().nthUglyNumber(10));
    }
}