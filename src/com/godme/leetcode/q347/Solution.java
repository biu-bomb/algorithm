package com.godme.leetcode.q347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


// 思路: 计数+最小堆
// 时间: O(n)
// 空间: O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 1) return nums;
        Map<Integer, Integer> counter = new HashMap<>();
        for(int num: nums){
            counter.put(num, counter.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> integers = new PriorityQueue<>(Comparator.comparing(counter::get));
        for(int num: counter.keySet()){
            integers.add(num);
            if(integers.size() > k){
                integers.poll();
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = integers.poll();
        }
        return  res;
    }
}
