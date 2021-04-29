package com.godme.leetcode.q912;

import java.util.Arrays;

class Solution {

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }
    public void sort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int leftCursor = left, rightCursor = right;
        // 基准值，最后一个需要补位
        int pivot = nums[left];
        // 始终条件检查
        while(leftCursor < rightCursor){
            // 右侧小数
            while(leftCursor < rightCursor && nums[rightCursor] >= pivot){
                rightCursor--;
            }
            // 替换左侧
            if(leftCursor < rightCursor){
                nums[leftCursor] = nums[rightCursor];
            }
            // 左侧大数
            while (leftCursor < rightCursor && nums[leftCursor] < pivot){
                leftCursor++;
            }
            // 替换右侧
            if(leftCursor < rightCursor){
                nums[rightCursor] = nums[leftCursor];
            }
        }
        // 补位
        nums[leftCursor] = pivot;
        // 递归
        sort(nums, left, leftCursor-1);
        sort(nums, leftCursor+1, right);
    }

    public static void main(String[] args) {
        System.err.println(Arrays.toString(
                new Solution().sortArray(
                        new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1})));
    }
}