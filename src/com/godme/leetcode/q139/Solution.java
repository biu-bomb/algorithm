package com.godme.leetcode.q139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 无关忽略: 很多组合问题，甚至可能有子组合等多种组合方式，但是非题目要求，怎么组合的实在无关紧要
 * 最大检测: 组合问题中，如有可能，应该以最大匹配进行检测，防止额外子组合匹配操作
 * 层级递进:
 *      1. 逆向: 由结果向前反推，唯一前向依赖时候效率高
 *      2. 正向: 由初始向后遍历，多种组合方式重复覆盖，后续计算单一，效率高
 */

// 思路: 从匹配点开始，持续向后匹配，检测length为匹配点
//      1. 如何匹配的毫无关系
//      2. 由谁匹配的毫无关系
//      3. 最大长度匹配优先
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            // 尽量以为最长匹配
            for (int j = 0; j < i; j++) {
                // 检测当前是否为匹配点
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        // length是否为匹配点
        return dp[s.length()];
    }
}
