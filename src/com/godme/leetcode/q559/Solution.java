package com.godme.leetcode.q559;


import java.util.List;

class Solution {
    int res;
    public int maxDepth(Node root) {
        if(root == null) return 0;
        res = 0;
        dfs(root, 0);
        return res;
    }

    public void dfs(Node root, int level){
        level += 1;
        if(root.children.isEmpty()) {
            res = Math.max(res, level);
            return;
        }
        for(Node child: root.children){
            dfs(child, level);
        }
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
};
