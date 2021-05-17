package com.godme.offer.q55_2;


import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<TreeNode, Integer> cache = new HashMap<>();
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode node){
        if(node == null) return 0;
        if(cache.containsKey(node)) return cache.get(node);
        int maxDepth = 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
        cache.put(node, maxDepth);
        return maxDepth;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
