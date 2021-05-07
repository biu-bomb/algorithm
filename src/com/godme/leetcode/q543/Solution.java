package com.godme.leetcode.q543;


import java.util.HashMap;

// 遍历的时候就可以直接更新数据，无需嵌套判断
class Solution {
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
       res = 0;
       maxDepth(root);
       return res;
    }

    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        res = Math.max(res, leftDepth+rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
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
