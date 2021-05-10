package com.godme.leetcode.q449;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Codec {

    public void doSerialize(TreeNode node, StringBuilder res){
        if(node == null) {
            res.append("None,");
        } else {
            res.append(node.val).append(",");
            doSerialize(node.left, res);
            doSerialize(node.right, res);
        }
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        doSerialize(root, sb);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        List<String> values = new LinkedList<>(Arrays.asList(data.split(",")));
        return doDeserialize(values.iterator());
    }

    public TreeNode doDeserialize(Iterator<String> it){
        if(!it.hasNext()) return null;
        String current = it.next();
        if("None".equals(current)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(current));
        node.left = doDeserialize(it);
        node.right = doDeserialize(it);
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
