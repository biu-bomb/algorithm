package com.godme.leetcode.q704;

class Solution {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int left, int right){
        if(right - left < 2) return nums[left] == target ? left : nums[right] == target ? right : -1;
        if(nums[left] == target) return left;
        int mid = (left + right) / 2;
        if(nums[mid] == target) return mid;
        return nums[mid] < target ? search(nums, target, mid, right) : search(nums, target, left, mid);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-1,0,3,5,9,12};
        System.err.println(solution.search(nums, 2));
    }
}
