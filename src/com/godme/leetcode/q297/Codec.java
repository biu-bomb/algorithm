package com.godme.leetcode.q297;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {
    public String doSerialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += root.val + ",";
            str = doSerialize(root.left, str);
            str = doSerialize(root.right, str);
        }
        return str;
    }

    public String serialize(TreeNode root) {
        return doSerialize(root, "");
    }

    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
        return doDeserialize(data_list);
    }

    // 连续两个null，也就是到叶子节点，自动返回停止
    public TreeNode doDeserialize(List<String> l) {
        if (l.get(0).equals("None")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(l.get(0)));
        l.remove(0);
        root.left = doDeserialize(l);
        root.right = doDeserialize(l);

        return root;
    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
