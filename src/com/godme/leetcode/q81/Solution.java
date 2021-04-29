package com.godme.leetcode.q81;

class Solution {
    public boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }

    public boolean search(int[] nums, int left, int right, int target){
        // 去重
        while (left < right && nums[left] == nums[left+1]){
            left += 1;
        }
        while (left < right && nums[right] == nums[right - 1]){
            right -= 1;
        }
        // 1. 端点比较
        // 2. 遍历比较
        boolean bingo = nums[left] == target || nums[right] == target;
        if(bingo || right - left  < 2){
            return bingo;
        }
        // order
        if(nums[left] < nums[right] && (nums[left] > target || target > nums[right])){
            return false;
        }
        // non-order
        int mid = (left + right) / 2;
        return nums[mid] == target || search(nums, left, mid-1, target) || search(nums, mid+1, right, target);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,3,5};
        int target = 2;
        System.err.println(solution.search(arr, target));
    }
}