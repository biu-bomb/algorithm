package com.godme.leetcode.q199;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {

    TreeNode last = null;
    public List<Integer> rightSideView(TreeNode root) {

        return null;
    }

    public void recordLast(TreeNode root){

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

