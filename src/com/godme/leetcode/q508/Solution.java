package com.godme.leetcode.q508;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {

    int maxCount = 0;
    Map<Integer, Integer> sumCount = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        sumTree(root);
        List<Integer> maxSum = new LinkedList<>();
        sumCount.forEach((s, c)->{
            if(c == maxCount) maxSum.add(s);
        });
        int[] res = new int[maxSum.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = maxSum.get(i);
        }
        return res;
    }

    public int sumTree(TreeNode node){
        if(node == null) return 0;
        int res = node.val + sumTree(node.left) + sumTree(node.right);
        int count = sumCount.getOrDefault(res, 0) + 1;
        maxCount = Math.max(maxCount, count);
        sumCount.put(res, count);
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
