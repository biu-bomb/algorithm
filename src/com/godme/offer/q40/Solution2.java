package com.godme.offer.q40;

import java.util.PriorityQueue;

class Solution2 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) {
            return vec;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);
        for (int i = 0; i < arr.length; ++i) {
            if(i < k){
                queue.offer(arr[i]);
                continue;
            }
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
    }
}
