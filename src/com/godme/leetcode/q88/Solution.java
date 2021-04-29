package com.godme.leetcode.q88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n < 1) return;
        if(m < 1) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        // 1. 正向情况涉及数据迁移，且nums1剩余空间没有利用
        // 2. 逆向比对，每次都是单次比对的插入排序
        for (int cursorA = m-1, cursorB = n-1, last = m+n-1; last > -1; last--) {
            if(cursorA > -1 && cursorB > -1){
                if(nums1[cursorA] > nums2[cursorB]){
                    nums1[last] = nums1[cursorA--];
                } else {
                    nums1[last] = nums2[cursorB--];
                }
            } else if(cursorA > -1){
                nums1[last] = nums1[cursorA--];
            } else if(cursorB > -1){
                nums1[last] = nums2[cursorB--];
            }
        }
    }
}