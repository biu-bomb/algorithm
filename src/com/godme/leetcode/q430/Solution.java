package com.godme.leetcode.q430;




class Solution {
    public Node flatten(Node head) {
        if(head != null){
            Node temp = new Node();
            flattenLastNode(temp, head);
            head = temp.next;
            head.prev = null;
        }
        return head;
    }

    public Node flattenLastNode(Node resultTail, Node current){
        for(; current != null && current.child == null; current = current.next,resultTail = resultTail.next){
            resultTail.next = current;
            current.prev = resultTail;

        }
        if(current == null){
            return resultTail;
        }
        resultTail.next = current;
        current.prev = resultTail;

        resultTail = resultTail.next;
        Node child = current.child;
        current.child = null;
        Node next = current.next;
        resultTail = flattenLastNode(resultTail, child);
        return flattenLastNode(resultTail, next);
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}