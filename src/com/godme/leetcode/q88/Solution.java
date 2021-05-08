package com.godme.leetcode.q88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n < 1) return;
        if(m < 1) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        m -= 1; n -= 1;
        for(int tail = m + n + 1; tail > -1; tail --){
            if(m> -1 && n > -1){
                if(nums1[m] > nums2[n]){
                    nums1[tail] = nums1[m--];
                } else {
                    nums1[tail] = nums2[n--];
                }
            } else if(m > -1){
                nums1[tail] = nums1[m--];
            } else {
                nums1[tail] = nums2[n--];
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{1,2,3,0,0,0};
        int[] b = new int[]{2,5,6};
        solution.merge(a, 3, b, 3);
    }
}