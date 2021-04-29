package com.godme.leetcode.q179;

import java.util.ArrayList;

class Solution {
    // 首位的比对情况一定是按照降序进行的, 47, 5
    // 核心问题在于首位相同情况下的两位以上的数的尾数的绑定，41,4,45
    // 45 -> 4 -> 41: 首位带来数据增益5,后续41带来数据损失
    // 可见，在整体首数排序的情况下，在不同的数据阶段有二级的排序逻辑
    // 不过对比方式都和暴力一个鸟样: 数据拼接以后谁大谁在前面
    // 不用任何技巧，不用证明，题目要求就是这样
    public int combineMax(int x, int y){
        long sx = 10, sy = 10;
        // x需要补充的0
        while (sx <= x) {
            sx *= 10;
        }
        // y 需要补充的0
        while (sy <= y) {
            sy *= 10;
        }
        // 拼接的数直接作差
        return (int) ( (sx * y + x) - (sy * x + y ));
    }
    public String largestNumber(int[] nums) {
        if(nums.length < 1){
            return "";
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (int num: nums) {
            integers.add(num);
        }
        integers.sort(this::combineMax);
        if (integers.get(0) == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        integers.stream().map(e->""+e).forEach(sb::append);
        return sb.toString();
    }
}