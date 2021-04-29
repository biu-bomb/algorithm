package com.godme.nowcoder.l9;

public class Solution {
    // 存在大于数据集一半的众数，相消之下，众数存在剩余
    public int MoreThanHalfNum_Solution(int [] array) {
        int detector = 0, counter = 0;
        for (int value : array) {
            // 初始化或者刚好消完，重新记录
            if (counter == 0) {
                detector = value;
                counter += 1;
            } else {
                // 相同+1，不同消去-1
                counter += detector == value ? 1 : -1;
            }
        }
        counter = 0;
        // 首次遍历也可完成计数，但是提升空间复杂度
        // 非嵌套遍历不提升时间复杂度
        for (int num : array) {
            counter += num == detector ? 1 : 0;
        }
        // 确认大于数据集一半
        return counter > array.length / 2 ? detector : 0;
    }
}