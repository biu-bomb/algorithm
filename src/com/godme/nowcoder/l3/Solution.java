package com.godme.nowcoder.l3;

import java.util.Arrays;

public class Solution {

    public int[] twoSum (int[] numbers, int target) {
        for (int left = 0; left < numbers.length - 1; left++){
            for (int right = left+1; right < numbers.length; right++) {
                if(numbers[left] + numbers[right] == target){
                    return new int[]{left + 1, right+1};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
