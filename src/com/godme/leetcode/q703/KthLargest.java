package com.godme.leetcode.q703;

import java.util.PriorityQueue;
class KthLargest {
    PriorityQueue<Integer> minRootHeap;
    int maxSize;
    public KthLargest(int k, int[] nums) {
        maxSize = k;
        minRootHeap = new PriorityQueue<>();
        for(int num: nums){
            add(num);
        }
    }

    public int add(int val) {
        minRootHeap.offer(val);
        // 优先队列还是会扩容的，需要缩小一下
        if(minRootHeap.size() > maxSize){
            minRootHeap.poll();
        }
        return minRootHeap.peek();
    }
}
