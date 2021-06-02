package com.godme.leetcode.q105;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> indexMap;
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int n = preorder.length;
        // 快速定位，免查找
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(0, n - 1, 0, n - 1);
    }
    // 元素区间分割，层级递归
    public TreeNode myBuildTree(int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) return null;
        int inorder_root = indexMap.get(preorder[preorder_left]);
        TreeNode root = new TreeNode(preorder[preorder_left]);
        int left_length = inorder_root - inorder_left;
        root.left = myBuildTree(preorder_left + 1, preorder_left + left_length, inorder_left, inorder_root - 1);
        root.right = myBuildTree(preorder_left + left_length + 1, preorder_right, inorder_root + 1, inorder_right);
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
