package com.godme.q13;

class Solution {
    // 左侧小数减去，其余加上
    public int romanToInt(String s) {
        int sum = 0, last = valueOf(s.charAt(0)), current;
        for(int i = 1;i < s.length(); i ++) {
            current = valueOf(s.charAt(i));
            sum += last < current ? -last : last;
            last = current;
        }
        return sum + last;
    }
    private int valueOf(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}