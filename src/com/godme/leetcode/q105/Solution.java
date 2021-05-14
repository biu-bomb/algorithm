package com.godme.leetcode.q105;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> inorderIndexMap;
    int[] preorder, inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for(int i = 0; i < inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }
        return buildTree(0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode buildTree(int preLeft, int preRight, int inLeft, int inRight){
        if(preLeft > preRight || inLeft > inRight) return null;
        int rootValue = preorder[preLeft];
        int nextRootInorderIndex = inorderIndexMap.get(preorder[preLeft]);
        int leftLength = nextRootInorderIndex - inLeft;
        return new TreeNode(rootValue,
                buildTree(preLeft+1, preLeft+leftLength, inLeft, inLeft+leftLength),
                buildTree(preLeft+leftLength+1, preRight, inLeft+leftLength+1, inRight));
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
