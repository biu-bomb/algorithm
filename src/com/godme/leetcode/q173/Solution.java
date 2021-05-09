package com.godme.leetcode.q173;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class BSTIterator {

    Iterator<Integer> it;
    public BSTIterator(TreeNode root) {
        it = preOrder(root).iterator();
    }

    public int next() {
        return it.next();
    }

    public boolean hasNext() {
        return it.hasNext();
    }

    List<Integer> preOrder(TreeNode root){
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        res.addAll(preOrder(root.left));
        res.add(root.val);
        res.addAll(preOrder(root.right));
        return res;
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




