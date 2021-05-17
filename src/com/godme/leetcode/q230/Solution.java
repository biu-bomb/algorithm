package com.godme.leetcode.q230;



public class Solution {
    int order = 0, k, last= Integer.MIN_VALUE;
    int target;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return target;
    }

    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if(root.val > last){
            order += 1;
        }
        if(order == k){
            target = root.val;
            return;
        }
        if(order < k){
            dfs(root.right);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        System.err.println(solution.kthSmallest(treeNode, 1));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

