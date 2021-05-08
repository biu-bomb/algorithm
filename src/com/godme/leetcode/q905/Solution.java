package com.godme.leetcode.q905;

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length - 1;
        while(left < right){
            while(left < right && (A[left]&1) == 0)  left ++;
            while(left < right && (A[right]&1) == 1) right --;
            if(left < right) swap(A, left, right);
        }
        return A;
    }

    public void swap(int[] N, int a, int b){
        int t = N[a];
        N[a] = N[b];
        N[b] = t;
    }
}