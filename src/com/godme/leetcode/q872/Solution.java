package com.godme.leetcode.q872;

import java.util.*;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) return root1 == root2;
        Deque<Integer> leaf = new LinkedList<>();
        collectLeaf(root1, leaf);
        return leafSimilar(leaf, root2) && leaf.isEmpty();
    }

    public void collectLeaf(TreeNode node, Deque<Integer> collector){
        if(node == null) return;
        if(node.left == null && node.right == null){
            collector.addLast(node.val);
            return;
        }
        collectLeaf(node.left, collector);
        collectLeaf(node.right, collector);
    }

    public boolean leafSimilar(Deque<Integer> leaf, TreeNode node){
        if(node == null) return true;
        if(node.left == null && node.right == null){
            if(!leaf.isEmpty() && leaf.getFirst() == node.val){
                leaf.removeFirst();
                return true;
            }
            return false;
        }
        return leafSimilar(leaf, node.left) && leafSimilar(leaf, node.right);
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

