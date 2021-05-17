package com.godme.offer.q55;


class Solution {

    int max = 0;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 0);
        return max;
    }

    public void dfs(TreeNode root, int depth){
        if(root != null){
            dfs(root.left, depth+1);
            dfs(root.right, depth+1);
        } else {
            max = Math.max(max, depth);
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

