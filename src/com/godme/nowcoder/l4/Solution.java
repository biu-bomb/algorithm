package com.godme.nowcoder.l4;

import java.util.*;

public class Solution {
    // 最长的不重复数据(字符)，关键在于出现重复字符时候对于已经遍历数据的取舍问题
    // 当不重复的时候直接累加，重复时刻需要将窗口收缩到截至的点
    // 同时，需要hash进行数据的重复判断
    public int maxLength (int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        int ans=0;
        for(int i=0;i<arr.length;i++){
            // 如果包含，需要截取数据序列长度
            if(list.contains(arr[i])){
                int j=list.indexOf(arr[i]);
                while (j-->=0){
                    list.removeFirst();
                }
            }
            // 始终添加并判断长度
            list.add(arr[i]);
            ans=Math.max(ans,list.size());
        }
        return ans;
    }
}