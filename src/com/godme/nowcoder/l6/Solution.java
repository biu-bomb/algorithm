package com.godme.nowcoder.l6;

public class Solution {
    public int Fibonacci(int n) {
        if(n < 2){
            return n;
        }
        int a = 0, b = 1,t;
        do{
            t = a;
            a = b;
            b += t;
        }while (--n > 2);
        return b;
    }
}