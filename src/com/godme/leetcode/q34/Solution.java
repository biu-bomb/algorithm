package com.godme.leetcode.q34;

import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = boundarySearch(nums, 0, nums.length-1, target, true);
        if(left == -1){
            return new int[]{-1,-1};
        }
        int right = boundarySearch(nums, left, nums.length - 1, target, false);
        return new int[]{left, right};
    }
    // 递归指定边界，提升二次查询效率
    public int boundarySearch(int[] nums, int left, int right, int target, boolean closeLeft){
        // 空数组情况
        if(right < 0){
            return -1;
        }
        // 二分边界直接比对
        boolean bingo = right - left < 2;
        if(nums[right] == target &&
                // 如果是查询右边界，直接返回
                // 如果是左边界二分比对，除非左边界不等
                (!closeLeft || (bingo && nums[left] != target))){
            return right;
        }
        if(nums[left] == target &&
                // 如果是查询左边界，直接返回
                // 或者是右边界二分比对
                (closeLeft || bingo)){
            return left;
        }
        if(bingo){
            return -1;
        }
        int mid = (left + right) / 2;
        if(target > nums[mid] || (!closeLeft && target >= nums[mid])){
            return boundarySearch(nums, mid, right, target, closeLeft);
        }
        return boundarySearch(nums, left, mid, target, closeLeft);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{2,2};
        System.err.println(Arrays.toString(s.searchRange(arr, 2)));
    }
}