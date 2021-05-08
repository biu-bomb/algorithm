package com.godme.leetcode.q852;

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int index = 0;
        while(arr[index] < arr[index+1]) index++;
        return index;
    }
}