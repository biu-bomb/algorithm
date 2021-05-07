package com.godme.leetcode.q102;


import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        values(res, Collections.singletonList(root));
        return res;
    }

    public List<List<Integer>> values(List<List<Integer>> res, List<TreeNode> nodes){
        if(nodes.isEmpty()){
            return res;
        }
        List<TreeNode> next = new ArrayList<>();
        List<Integer> currentRes = new ArrayList<>();
        for(TreeNode node: nodes){
            currentRes.add(node.val);
            if(node.left  != null){
                next.add(node.left);
            }
            if(node.right != null){
                next.add(node.right);
            }
        }
        res.add(currentRes);
        return values(res, next);
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

