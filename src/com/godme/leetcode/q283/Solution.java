package com.godme.leetcode.q283;


class Solution {
    // 滚动0: 将全部的0移动到末尾，但是0之间无所谓顺序，优先替换最前面的可减少移动次数
    public void moveZeroes(int[] nums) {
        int firstNotZero = 0, firstZero = 0;
        while(firstNotZero < nums.length){
            // 1. 非零: 无零的时候，firstZero不是zero，但是和firstNotZero保持同步滑动，等值复制无影响
            // 2. 有零: 有零的时候，firstZero之间存在间隔，其间必然是0，firstZero正是zero，替换头零
            if(nums[firstNotZero] != 0) {
                swap(nums, firstZero, firstNotZero);
                firstZero += 1;
            }
            firstNotZero += 1;
        }
    }
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

