package com.godme.leetcode.q513;


class Solution {

    int maxDepth = 0, maxLeft = 0, value;
    public int findBottomLeftValue(TreeNode root) {
        detect(root, 0, 0);
        return value;
    }

    public void detect(TreeNode root, int depth, int left){
        if(root == null) return;
        if((depth > maxDepth) || (depth == maxDepth && left < maxLeft)){
            value = root.val;
            maxDepth = depth;
            maxLeft = left;
        }
        detect(root.left, depth+1, left-1);
        detect(root.right, depth+1, left+1);
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

