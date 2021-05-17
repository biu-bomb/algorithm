package com.godme.offer.q32;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(Collections.singletonList(root));
        return res;
    }

    public void dfs(List<TreeNode> nodes){
        if(nodes.isEmpty()) return;
        List<TreeNode> nextLine = new LinkedList<>();
        List<Integer> values = new LinkedList<>();
        for(TreeNode node: nodes){
            values.add(node.val);
            if(node.left != null){
                nextLine.add(node.left);
            }
            if(node.right != null){
                nextLine.add(node.right);
            }
        }
        res.add(values);
        dfs(nextLine);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
