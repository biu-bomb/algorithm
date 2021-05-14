package com.godme.leetcode.q684;

class Solution {
    int[] parents;
    public int[] findRedundantConnection(int[][] edges) {
        init(edges.length+1);
        int n1, n2;
        for(int[] pair: edges){
            n1 = pair[0];
            n2 = pair[1];
            if(find(n1) != find(n2)){
                union(n1, n2);
            } else {
                return pair;
            }
        }
        return new int[0];

    }

    public void init(int n){
        parents = new int[n+1];
        for(int i = 0; i< n+1; i++){
            parents[i] = i;
        }
    }

    public int find(int node){
        if(parents[node] != node){
            parents[node] = find(parents[node]);
        }
        return parents[node];
    }

    public void union(int n1, int n2){
        parents[find(n1)] = find(n2);
    }
}