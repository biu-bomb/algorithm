package com.godme.leetcode.q189;

class Solution {
    public void rotate(int[] nums, int k) {
        // 旋转存在周期，去除周期影响
        k = k  % nums.length;
        if(k == 0){
            return;
        }
        int[] temp = new int[k];
        System.arraycopy(nums, nums.length-k, temp, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length-k);
        System.arraycopy(temp, 0, nums, 0, k);
    }
}