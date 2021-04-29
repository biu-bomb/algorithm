package com.godme.leetcode.q31;

import java.util.Arrays;

class Solution {
    // 下一个更大的数
    //  1. 存在一个数据，后续的数据中存在至少一个比它大的数(利用数值比较的传递性可以直接检测(a[i] < a[i+1])
    //  2. 将检测点更换为大于该值且距离最近的数
    //  3. 后续数据直接反序(根据1的结果，后续数据应该都是降序的，切替换的数值小于等于基准值，顺序不变)
    public void nextPermutation(int[] nums) {
        if(nums.length < 2){
            return;
        }
        for (int i = nums.length - 2; i > -1; i--) {
            // 突变点
            if(nums[i] < nums[i+1]){
                // 交换
                swap(nums, i, findMinMax(nums, i, nums[i]));
                // 反序
                reverse(nums, i+1);
                return;
            }
        }
        // 无突变点全部反序
        reverse(nums, 0);
    }

    public int findMinMax(int[] nums, int p, int stander){
        int minMax = Integer.MAX_VALUE;
        int minMaxIndex = 0;
        for (int i = nums.length - 1; i > p; i--) {
            if(nums[i] > stander && nums[i] < minMax){
                minMax = nums[i];
                minMaxIndex = i;
            }
        }
        return minMaxIndex;
    }
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void reverse(int[] nums, int left){
        int right = nums.length - 1;
        while(left < right){
            swap(nums, left, right);
            left ++;
            right --;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,2,3};
        solution.nextPermutation(arr);
        System.err.println(Arrays.toString(arr));
    }
}
