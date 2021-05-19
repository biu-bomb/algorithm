package com.godme.leetcode.q307;

class NumArray {

    int[] nums;
    int[] sums;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.sums = new int[nums.length];
        calcSum();
    }

    public void update(int index, int val) {
        int old = nums[index];
        int delta = val - old;
        for(int i=index; i< sums.length; i++){
            sums[i] += delta;
        }
    }

    public int sumRange(int left, int right) {
        return sums[right] - (left==0?0:sums[left-1]);
    }

    public void calcSum(){
        if(sums.length != 0){
            sums[0] = nums[0];
            for(int i=1; i<sums.length; i++){
                sums[i] = sums[i-1] + nums[i];
            }
        }
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.err.println(numArray.sumRange(1, 2));
    }
}

