package com.godme.leetcode.q671;


class Solution {

    int res = -1;
    int detector;
    public int findSecondMinimumValue(TreeNode root) {
        if(root != null){
            detector = root.val;
            dfs(root);
        }
        return res;
    }

    public void dfs(TreeNode node){
        if(node == null) return;
        if(node.val > detector){
            res = res == -1 ? node.val : Math.min(res, node.val);
        }
        dfs(node.left);
        dfs(node.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(2, new TreeNode(2), new TreeNode(5, new TreeNode(5), new TreeNode(7)));
        System.err.println(solution.findSecondMinimumValue(treeNode));
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
