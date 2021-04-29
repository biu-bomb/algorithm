package com.godme.leetcode.q143;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        // 线性表
        for (;head!=null;head=head.next){
            nodes.add(head);
        }
        ListNode front, back, temp;
        // 间隔插入
        int frontIndex=0,backIndex=nodes.size()-1;
        for(;backIndex - frontIndex >= 2;frontIndex++,backIndex--){
            front = nodes.get(frontIndex);
            temp = nodes.get(frontIndex+1);
            back = nodes.get(backIndex);
            front.next = back;
            back.next = temp;
        }
        // 阻断尾节点关联
        nodes.get(backIndex).next = null;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
