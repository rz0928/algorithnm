package top.ruizhihut.union_find_4;

/**
 * @description: 并查集，主要是图的连通块相关的题目
 * @author：ruizhi
 * @date: 2024/10/28
 * @Copyright：
 */
public class UnionFind {
    public void demo (int[][] edges,int n) {
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
           //并查集生成过程
            int[] edge = edges[i];
            //连通边
            int node1 = edge[0], node2 = edge[1];
            //根节点不相同，则合并
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            }
        }
        //可以遍历数组来看有几个不同的根节点看连通块
        //可以在遍历过程中看有几条对连通无效的边
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
