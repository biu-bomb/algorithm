package com.godme.offer.q0402;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return generate(nums, 0, nums.length-1);
    }


    public TreeNode generate(int[] nums, int left, int right) {
        if(left > right) return null;
        int index = (left + right) / 2;
        TreeNode node = new TreeNode(nums[index]);
        node.left = generate(nums, left, index-1);
        node.right = generate(nums, index+1, right);
        return node;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

