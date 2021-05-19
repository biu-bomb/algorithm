package com.godme.leetcode.q421;

import java.util.HashSet;
import java.util.Set;

// a ^ b = c => b = a ^ c
// 逐渐固定高位，检测合格数据中最大值
// 时间: nlog(C)
// 空间: n
class Solution {
    static final int HIGH_BIT = 30;
    public int findMaximumXOR(int[] nums) {
        int x = 0;
        Set<Integer> seen = new HashSet<>();
        for (int k = HIGH_BIT; k >= 0; --k) {
            seen.clear();
            for (int num : nums) {
                // 第k高位
                seen.add(num >> k);
            }
            // 旧的左移*2，第k位置1
            int xNext = x * 2 + 1;
            boolean found = false;
            for (int num : nums) {
                // 高位异或相等
                if (seen.contains(xNext ^ (num >> k))) {
                    found = true;
                    break;
                }
            }
            // 高位是否能为1
            x = xNext - (found ? 0 : 1);
        }
        return x;
    }
}