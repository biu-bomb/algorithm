package com.godme.nowcoder.l7;

public class Solution {
    public int search (int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }

    public int search(int[] nums, int low, int high, int target){
        if(high < low){
            return -1;
        }
        if(nums[low] == target){
            return low;
        }
        if(high - low <= 1){
            return nums[high] == target ? high : -1;
        }
        int mid = (low + high) / 2;
        if(nums[mid] < target){
            return search(nums, mid+1, high, target);
        }
        return search(nums, low, mid, target);
    }
}