package com.godme.leetcode.q783;


class Solution {
    public int minDiffInBST(TreeNode root) {
        TreeNode curr, prev = null;
        int res = Integer.MAX_VALUE;
        while(root != null){
            if(root.left != null){
                curr = root.left;
                while (curr.right != null && curr.right != root){
                    curr = curr.right;
                }
                if(curr.right == null){
                    curr.right = root;
                    root = root.left;
                    continue;
                }
            }
            if(prev != null){
                res = Math.min(res, root.val - prev.val);
            }
            prev = root;
            root = root.right;
        }
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
