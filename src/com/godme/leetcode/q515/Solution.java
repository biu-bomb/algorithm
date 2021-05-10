package com.godme.leetcode.q515;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {

    Map<Integer, Integer> recorder = new HashMap<>();
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        int index = 0;
        detect(root, 0);
        while (recorder.containsKey(index)){
            res.add(recorder.get(index));
            index += 1;
        }
        return res;
    }

    public void detect(TreeNode node, int depth){
        if(node == null) return;
        recorder.put(depth, Math.max(node.val, recorder.getOrDefault(depth, Integer.MIN_VALUE)));
        detect(node.left, depth+1);
        detect(node.right, depth+1);
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
