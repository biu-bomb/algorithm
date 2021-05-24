package com.godme.leetcode.q378;

import java.util.PriorityQueue;

// 思路: 大顶堆
// 时间: O(n)
// 空间: O(k)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> integers = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int[] row: matrix){
            for(int v: row){
                integers.add(v);
                if(integers.size() > k){
                    integers.poll();
                }
            }
        }
        return integers.peek();
    }
}