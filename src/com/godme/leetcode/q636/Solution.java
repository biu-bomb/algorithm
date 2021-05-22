package com.godme.leetcode.q636;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// 思路: 累计delta时间差: end包含当前时间，需要补偿
// 时间: O(n)
// 空间: O(n)
public class Solution {
    public int[] exclusiveTime(int n, List< String > logs) {
       int[] res = new int[n];
       Stack<Integer> stack = new Stack<>();
       String[] info = logs.get(0).split(":");
       int commandId = Integer.parseInt(info[0]);
       int lastTimeStamp = Integer.parseInt(info[2]), currentTimeStamp;
       stack.push(commandId);
       for(int i = 1; i < logs.size(); i++){
           info = logs.get(i).split(":");
           commandId = Integer.parseInt(info[0]);
           currentTimeStamp = Integer.parseInt(info[2]);
           if("start".equals(info[1])){
               if(!stack.isEmpty()){
                   res[stack.peek()] += currentTimeStamp - lastTimeStamp;
               }
               stack.push(commandId);
               lastTimeStamp = currentTimeStamp;
           } else {
               res[stack.pop()] += currentTimeStamp - lastTimeStamp + 1;
               lastTimeStamp = currentTimeStamp + 1;
           }
       }
       return res;
    }
}
