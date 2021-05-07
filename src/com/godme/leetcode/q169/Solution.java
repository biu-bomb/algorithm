package com.godme.leetcode.q169;

class Solution {
    public int majorityElement(int[] nums) {
        int res = -1;
        int detector = 0;
        for(int num: nums){
           if(detector == 0){
               res = num;
           }
           detector += res == num ? 1: -1;
        }
        return res;
    }
}