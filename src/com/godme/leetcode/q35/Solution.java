package com.godme.leetcode.q35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    public int searchInsert(int[] nums, int target, int left, int right){
        if(nums[left] > target) return left;
        if(nums[right] < target) return right + 1;
        int mid = (left + right) / 2;
        if(nums[mid] == target) return mid;
        if(nums[mid] < target) return searchInsert(nums, target, mid+1, right);
        return searchInsert(nums, target, left, mid-1);
    }
}