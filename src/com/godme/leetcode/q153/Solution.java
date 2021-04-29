package com.godme.leetcode.q153;

class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length-1);
    }
    public int findMin(int[] nums, int low, int high){
        // 唯一数据: 相邻元素已经避免
        if(low == high){
            return nums[low];
        }
        // 相邻判断: 规避相邻元素下标判断
        if(high - low == 1){
            return Math.min(nums[high], nums[low]);
        }
        // 整体有序: 返回最左
        if(nums[high] > nums[low]){
            return nums[low];
        }
        int mid = (low + high) / 2;
        // 部分有序: 最小不在有序一侧
        if(nums[low] < nums[mid]){
            return findMin(nums, mid, high);
        } else {
            return findMin(nums, low, mid);
        }
    }
}
