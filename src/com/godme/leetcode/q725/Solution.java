package com.godme.leetcode.q725;


class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int size = 0;
        // 计数
        for(ListNode cursor = root; cursor != null; cursor = cursor.next){
            size += 1;
        }
        // basic: 基础的个数
        // more : 剩余的个数
        int basic = size / k, more = size % k;
        ListNode[] res = new ListNode[k];
        int index = 0;
        // 遍历
        for(ListNode cursor = root, temp; index < k; index ++){
            temp = cursor;
            // 每一次的个数 = 基础的个数 + 均摊的多余的个数
            // 由于需要断开链接关系，每次找到的是前一个，需要-1，讲逻辑放到了多个个数的判断里面
            for(int count = 0; temp != null && count < basic + (more > 0? 0: -1); count++){
                temp = temp.next;
            }
            // 总是前面的均摊多余个数
            more -= 1;
            // 每次都直接放置cursor
            res[index] = cursor;
            // 如果不够，直接null，否则使用后续节点
            cursor = temp == null ? null : temp.next;
            // 如果节点足够，需要断开关系
            if(temp != null){
                temp.next = null;
            }
        }
        return res;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
