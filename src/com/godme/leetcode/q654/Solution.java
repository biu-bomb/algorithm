package com.godme.leetcode.q654;


class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
         return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int left, int right){
      if(left > right) return null;
      int maxIndex = left, max = nums[left];

      for(int index = left+1;index <= right; index++){
           if(nums[index] > max){
               max = nums[index];
               maxIndex = index;
           }
      }
      TreeNode leftNode = constructMaximumBinaryTree(nums, left, maxIndex-1);
      TreeNode rightNode = constructMaximumBinaryTree(nums, maxIndex+1, right);
      return new TreeNode(max, leftNode, rightNode);
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

