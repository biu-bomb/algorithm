package com.godme.leetcode.q215;

import java.util.PriorityQueue;

// 思路: 小顶堆
// 时间: O(n)
// 空间: O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        for(int num: nums){
            integers.add(num);
            if(integers.size() > k){
                integers.poll();
            }
        }
        return integers.peek();
    }
}
