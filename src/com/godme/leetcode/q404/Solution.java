package com.godme.leetcode.q404;


class Solution {
    int res;
    public int sumOfLeftLeaves(TreeNode root) {
        res = 0;
        searchNode(root);
        return res;
    }

    public void searchNode(TreeNode root){
        if(root == null) return;
        if(root.left != null){
            if(root.left.left == null && root.left.right == null){
                res += root.left.val;
            }
        }
        searchNode(root.left);
        searchNode(root.right);
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
