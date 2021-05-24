package com.godme.leetcode.q973;

import java.util.PriorityQueue;

// 思路: 大顶堆
// 时间: O(n)
// 空间: O(k)
class Solution {
    int[][] points;
    public int[][] kClosest(int[][] points, int k) {
        this.points = points;
        int[][] res = new int[k][2];
        PriorityQueue<Integer> integers = new PriorityQueue<>((a, b) -> (int) (distanceSquare(b) - distanceSquare(a)));
        for(int i = 0; i < points.length; i++){
            integers.add(i);
            if(integers.size() > k){
                integers.poll();
            }
        }
        for(int i = 0; i < k; i++){
            res[i] = points[integers.poll()];
        }
        return res;
    }

    double distanceSquare(int index){
        int[] point = points[index];
        return Math.pow(point[0], 2) + Math.pow(point[1], 2);
    }
}
