package top.ruizhihut.shortestPath_2.LeetCode;

import java.util.*;

/**
 * @description:
 * @author：ruizhi
 * @date: 2024/10/8
 * @Copyright：
 */
public class LeetCode_1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> graph = new ArrayList<>();
        //初始化
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < edges.length; i++) {
            //记录双向关联信息
            graph.get(edges[i][0]).add(new Pair(succProb[i], edges[i][1]));
            graph.get(edges[i][1]).add(new Pair(succProb[i], edges[i][0]));
        }
        return djst2(n, start_node, end_node, graph);
    }

    //使用数组存放超空间
    public double djst1(int n, int start, int end, int[][] edges, double[] succProb) {
        double[] dist = new double[n];
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> Double.compare(dist[o2], dist[o1]));
        double[][] graph = new double[n][n];
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]][edges[i][1]] = succProb[i];
            graph[edges[i][1]][edges[i][0]] = succProb[i];
            if (edges[i][0] == start) {
                dist[edges[i][1]] = succProb[i];
                queue.add(edges[i][1]);
            } else if (edges[i][1] == start) {
                dist[edges[i][0]] = succProb[i];
                queue.add(edges[i][0]);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < n; i++) {
                if (graph[node][i] != 0 && dist[i] < graph[node][i] * dist[node]) {
                    dist[i] = graph[node][i] * dist[node];
                    queue.add(i);
                }
            }
        }
        return dist[end];
    }

    public double djst2(int n, int start, int end, List<List<Pair>> graph) {
        double[] dist = new double[n];
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> Double.compare(dist[o2], dist[o1]));
        for (int i = 0; i < graph.get(start).size(); i++) {
            Pair pair = graph.get(start).get(i);
            dist[pair.node] = pair.succProb;
            queue.offer(pair.node);
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < graph.get(node).size(); i++) {
                Pair pair = graph.get(node).get(i);
                if(dist[node]*pair.succProb > dist[pair.node]){
                    dist[pair.node] = dist[node]*pair.succProb;
                    queue.offer(pair.node);
                }
            }

        }
        return dist[end];
    }

}

class Pair {
    double succProb;
    int node;

    public Pair(double succProb, int node) {
        this.succProb = succProb;
        this.node = node;
    }
}
