package com.godme.leetcode.q87;

import java.util.HashMap;
import java.util.Map;

//  0. 判断条件除了长度、字符频率以及相等等边界条件，核心在于: 在确定好切分边界以后，字符绝对不会跨界
//  1. 前面的直接递归，主要在于结果没有复用，导致重复计算量爆炸
//  2. 缓存设计
//      2.1 因为存在交换的可能，因此字符序绝对不能作为缓存标记，无法进行缓存
//      2.2 缓存必须是以区间形式进行，它必须能够表示两个字符关联区间以及缓存计算记过
//          2.2.1 简单缓存都是使用数组进行记录
//          2.2.2 数组内只单纯的记录唯一结果，关联信息都隐藏在路由索引中
//              2.2.2.1 长度不等必然不是，直接将长度作为索引之一，排除无效计算
//              2.2.2.2 字符区间在加入索引即可，因为关联两个字符区间，需要两个索引(最大长度确定，可以拆分子长度，索引关系进一步紧密，排除无用计算)
//  3. 变量设计: 不同分支重复计算，需要构造全局缓存，需要将局部的信息映射到全局，使用全局信息进行计算、缓存、交互
class Solution {
    String s1;
    String s2;
    // 0: unknown
    // 1: true
    // 2: false
    int recorder[][][];
    public boolean isScramble(String s1, String s2) {
        int length = s1.length();
        if(s2.length() != length){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        this.s1 = s1;
        this.s2 = s2;
        // 这里length长度不仅作为索引，还是作为变量，索引取值length-1,因此需要放大
        this.recorder = new int[length][length][length+1];
        return isScramble(0, 0, length);
    }

    public boolean isScramble(int index1, int index2, int length){
        // 有缓存
        if(recorder[index1][index2][length] != 0){
            return recorder[index1][index2][length] == 1;
        }
        String a = s1.substring(index1, index1 + length);
        String b = s2.substring(index2, index2 + length);
        // 相等
        if(a.equals(b)){
            recorder[index1][index2][length] = 1;
            return true;
        }
        // 词频检测
        if(!sameFreq(a, b)){
            recorder[index1][index2][length] = - 1;
            return false;
        }
        // 子串拆分: 对于一个字符总是拆成两半，只需要确定一边长度
        for(int subLength=1; subLength< length; subLength++){
            // 左左右右
            if(isScramble(index1, index2, subLength) && isScramble(index1+subLength, index2+subLength, length - subLength)){
                recorder[index1][index2][length] = 1;
                return true;
            }
            // 左右左右
            if(isScramble(index1, index2+ length - subLength, subLength) && (isScramble(index1 + subLength, index2, length - subLength))){
                recorder[index1][index2][length] = 1;
                return true;
            }
        }
        recorder[index1][index2][length] = -1;
        return false;
    }

    public boolean sameFreq(String s1, String s2){
        Map<Character, Integer> freq = new HashMap<>();
        char ch;
        for (int i = 0; i < s1.length(); i++) {
            ch = s1.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0)+1);
        }
        for (int i = 0; i < s2.length(); i++) {
            ch = s2.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) - 1);
        }
        return freq.values().stream().noneMatch(i -> i != 0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "great";
        String b = "rgeat";
        System.err.println(solution.isScramble(a, b));
    }
}
