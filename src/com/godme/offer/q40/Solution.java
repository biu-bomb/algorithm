package com.godme.offer.q40;

import java.util.Arrays;
import java.util.Random;

class Solution {
    private final Random random = new Random();
    // 快排半截排序即可
    public int[] getLeastNumbers(int[] arr, int k) {
        // 边界检查
        if(arr.length < k){
            return new int[0];
        }
        if(arr.length == k){
            return arr;
        }
        // 左半收集
        leftCollect(arr, k-1, 0, arr.length-1);

        int[] result = new int[k];
        // 左半拷贝
        System.arraycopy(arr, 0, result, 0, k);
        return result;
    }

    public void leftCollect(int[] nums, int p, int left, int right){
        // 1. 如果都聚集左半，停止(无顺序要求)
        // 2. 如果区间是右半，停止(非目的区域)
        if(left >p || right <= p){
            return;
        }
        // 直接以边界为检测点
        int detector = nums[left];
        // 单次快排归纳
        int leftCursor = left, rightCursor = right;
        while (leftCursor < rightCursor){
            while (leftCursor < rightCursor && nums[rightCursor] >= detector) rightCursor--;
            if(leftCursor < rightCursor){
                swap(nums, leftCursor, rightCursor);
            }
            while (leftCursor < rightCursor && nums[leftCursor] < detector) leftCursor++;
            if(leftCursor < rightCursor){
                swap(nums, leftCursor, rightCursor);
            }
        }
        // 类快排，区间分段前面已操作
        leftCollect(nums, p, left, leftCursor);
        leftCollect(nums, p, leftCursor+1, right);
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{23,54,43,22,13,45,9,8,4,5,6,7,6,5,2,1};
        System.err.println(Arrays.toString(solution.getLeastNumbers(arr, 5)));
    }
}
