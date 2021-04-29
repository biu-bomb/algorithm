package com.godme.leetcode.q33;

public class Solution {
    // 二分在于锁定结果，和顺序无关
    public int search(int[] nums, int target) {
        int mid,low=0, high = nums.length-1;
        while(low < high){
            if(nums[low] == target){
                return low;
            }
            if(nums[high] == target){
                return high;
            }
            mid = (low + high) / 2;
            if(nums[mid] == target){
                return mid;
            }
            // left order
            if(nums[low] < nums[mid]){
                if(nums[mid] > target && target > nums[low]){
                    low += 1;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            // right order
            } else {
                if(nums[mid] < target && nums[high] > target){
                    high -= 1;
                    low = mid + 1;
                } else {
                    low += 1;
                    high = mid - 1;
                }
            }
        }
        return nums[low]==target?low:-1;
    }
}
