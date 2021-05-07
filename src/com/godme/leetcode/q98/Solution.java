package com.godme.leetcode.q98;


class Solution {
    // 1. 单层： left < root < right
    // 2. 深层: left.left < left < left.right < root < right.left < right < right.right
    // 3. 抽象: min < val < max
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.isValidBST(new TreeNode(2147483647)));
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
