package com.godme.leetcode.q128;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        // 去重和hash，数组无法直接检测数
        HashSet<Integer> integers = new HashSet<>();
        for (int num: nums){
            integers.add(num);
        }
        int maxSequence = 0;
        int currentSequence, currentValue;
        for (int value: integers){
            // 从起始点开始检测
            if(!integers.contains(value - 1)){
                currentSequence = 0;
                currentValue = value;
                while(integers.contains(currentValue)){
                    currentSequence += 1;
                    currentValue += 1;
                }
                maxSequence = Math.max(maxSequence, currentSequence);
            }
        }
        return maxSequence;
    }
}