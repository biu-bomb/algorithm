package com.godme.leetcode.q338;

/**
 * 技巧剖析:  x & (x - 1)，借助高位的退化，能够取消掉二进制中最后的1
 * 整数幂:   如果 x = 2^n，整体只有唯一高位，消除以后只剩下0，因此通过判断计算值是否为0，可以计算是否2的整数幂
 * 根本作用:  消除x二进制表示中的最低位1
 */
// 思路: 最低位1 + 其余高位结果
// 时间: O(n)
// 空间: O(1) 结果必要，非额外辅助空间
class Solution {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for(int i = 1; i< bits.length; i++){
            // 高位结果 + 最低位1
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }
}
