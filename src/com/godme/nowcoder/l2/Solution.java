package com.godme.nowcoder.l2;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> integers = new ArrayList<>();
        if(input.length < k){
            return integers;
        }
        int[] min = new int[k];
        for (int i = 0; i < k; i++) {
            min[i] = Integer.MAX_VALUE;
        }
        int cursor, maxIndex = k-1;
        for(int data: input){
            if(data > min[maxIndex]) continue;
            min[maxIndex] = data;
            for (cursor = maxIndex; cursor > 1 && min[cursor]>= min[cursor-1]; cursor--){
                swap(min, cursor, cursor-1);
            }
        }
        Arrays.stream(min).forEach(integers::add);
        return integers;
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}