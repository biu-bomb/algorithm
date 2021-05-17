package com.godme.leetcode.q684;

class Solution {
<<<<<<< HEAD
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
=======
    public int[] findRedundantConnection(int[][] edges) {
        int nodesCount = edges.length;
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}
>>>>>>> 3772284 (add)
