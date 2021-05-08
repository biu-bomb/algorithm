package com.godme.leetcode.q415;

class Solution {
    public String addStrings(String num1, String num2) {
        int i1 = num1.length()-1, i2 = num2.length()-1;
        StringBuilder res = new StringBuilder();
        int bingo = 0, a, b, sum;
        while(i1 > -1 || i2 > -1 || bingo > 0){
            a = i1 > -1 ? num1.charAt(i1) - '0' : 0;
            b = i2 > -1 ? num2.charAt(i2) - '0' : 0;
            sum = bingo + a + b;
            res.append(sum % 10);
            bingo = sum / 10;
            i1 -= 1;
            i2 -= 1;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.err.println((int)'0');
        System.err.println((int)'9');
    }
}