package com.godme.leetcode.q105;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> inorderIndexMap;


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for(int index = 0; index < inorder.length; index++){
            inorderIndexMap.put(inorder[index], index);
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight){
        if(preorderLeft > preorderRight) return null;
        int rootValue = preorder[preorderLeft];
        int inorderRootIndex = inorderIndexMap.get(rootValue);
        int leftMemberCount = inorderRootIndex - inorderLeft;
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(preorder, inorder, preorderLeft+1, preorderLeft+leftMemberCount, inorderLeft, inorderRootIndex+1);
        root.right = buildTree(preorder, inorder, preorderLeft+leftMemberCount+1, preorderRight, inorderRootIndex+1, inorderRight);
        return root;
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
