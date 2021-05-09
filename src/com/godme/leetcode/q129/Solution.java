package com.godme.leetcode.q129;


class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int sum){
        if(root == null) return 0;
        sum += root.val;
        if(root.left == null && root.right == null) return sum;
        sum *= 10;
        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.err.println(solution.sumNumbers(treeNode));
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
