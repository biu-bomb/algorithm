package com.godme.leetcode.q118;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> lastRow = null;
        for(int level = 1; level <= numRows; level++){
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(0, 1);
            for(int index = 1; index < level - 1; index++){
                currentRow.add(index, lastRow.get(index - 1) + lastRow.get(index));
            }
            currentRow.add(level - 1, 1);
            res.add(currentRow);
            lastRow = currentRow;
        }
        return res;
    }
}