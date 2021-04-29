package com.godme.leetcode.q1011;

class Solution {
    // 承载边界: max(weights) <= size <= sum(weights)
    // 可以通过二分进行查找，此处为了模板，暂且不做(新模板再做二分)
    public int shipWithinDays(int[] weights, int D) {
        int minSize = 0;
        int maxSize = 0;
        for (int weight : weights) {
            minSize = Math.max(weight, minSize);
            maxSize += weight;
        }
        int midSize;
        while(minSize < maxSize){
            if(carryOut(weights, 0, minSize, D)){
                return minSize;
            }
            midSize = (minSize + maxSize) / 2;
            if(carryOut(weights, 0, minSize, D)){
                maxSize = midSize;
            } else {
                minSize = midSize + 1;
            }
        }
        return minSize;
    }
    public boolean carryOut(int[] weights, int cursor, int size, int D){
        if(cursor == weights.length ||D == 0){
            return true;
        }
        for (int residue = size; cursor < weights.length && residue >= weights[cursor]; cursor++) {
            residue -= weights[cursor];
        }
        return carryOut(weights, cursor, size, D - 1);
    }
}