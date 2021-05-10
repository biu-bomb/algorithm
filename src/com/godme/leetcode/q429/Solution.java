package com.godme.leetcode.q429;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        Queue<Node> currentLevel = new LinkedList<>();
        currentLevel.add(root);
        Queue<Node> nextLevel = new LinkedList<>(), temp;
        List<Integer> line = null;
        while(!currentLevel.isEmpty()){
            nextLevel.clear();
            line = new LinkedList<>();
            while(!currentLevel.isEmpty()){
                root = currentLevel.poll();
                line.add(root.val);
                if(root.children != null){
                    nextLevel.addAll(root.children);
                }
            }
            temp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = temp;
            res.add(line);
        }
        return res;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
