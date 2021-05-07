package com.godme.leetcode.q108;


class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createTreeNode( nums, 0, nums.length - 1);
    }

    public TreeNode createTreeNode(int[] nums, int left, int right){
        if(left > right) return null;
        int mid = (left + right) / 2;
        return new TreeNode(nums[mid], createTreeNode(nums, left, mid-1), createTreeNode(nums, mid+1, right));
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
