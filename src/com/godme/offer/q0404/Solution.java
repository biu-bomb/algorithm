package com.godme.offer.q0404;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<TreeNode, Integer> cache = new HashMap<>();
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return Math.abs( maxDepth(root.left, 0) - maxDepth(root.right, 0)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }


    public int maxDepth(TreeNode node, int depth){
        if(node == null) return 0;
        if(cache.containsKey(node)) return cache.get(node);
        int max = Math.max(maxDepth(node.left, depth+1), maxDepth(node.right, depth+1)) + 1;
        cache.put(node, max);
        return max;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
