package com.godme.leetcode.q114;


class Solution {
    public void flatten(TreeNode root) {
        TreeNode last;
        while (root != null){
            if(root.left != null){
                last = root.left;
                while (last.right != null){
                    last = last.right;
                }
                last.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
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
