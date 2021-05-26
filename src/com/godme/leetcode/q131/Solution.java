package com.godme.leetcode.q131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 压栈拼接: 存在重复路径的情况下，可以使用压栈拼接，后续移除的情况构造回溯，避免独立维护浪费内存
 */
// 思路: 表示回文，按图索骥拼接
// 时间: O(n * 2 ^ n)     全是单字符的情况，最坏O(2 ^ n)
// 空间: O(n ^ 2)
class Solution {
    boolean[][] f;
    List<List<String>> ret = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }
        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}

