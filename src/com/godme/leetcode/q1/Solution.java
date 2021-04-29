package com.godme.leetcode.q1;

import java.util.HashMap;

class Solution {
    // 提速: 构建直接缓存，杜绝重复查询
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer>  recorder = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(recorder.containsKey(target - nums[i])){
                return new int[]{recorder.get(target - nums[i]), i};
            }
            recorder.put(nums[i], i);
        }
        return new int[0];
    }
}