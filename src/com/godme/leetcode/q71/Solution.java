package com.godme.leetcode.q71;

import java.util.Deque;
import java.util.LinkedList;

// 思路: /分割，..pop，空格或者.跳过，其他入队，拼接
// 时间: O(n)
// 空间: O(n)
class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Deque<String> deque = new LinkedList<>();
        for(String dir: dirs){
            if(dir.length() == 0 || ".".equals(dir)) continue;
            if("..".equals(dir)){
                if(!deque.isEmpty()){
                    deque.removeLast();
                }
            } else deque.addLast(dir);
        }
        if(deque.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder("/");
        while (!deque.isEmpty()){
            sb.append(deque.removeFirst()).append("/");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}