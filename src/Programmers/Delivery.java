package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Delivery {

    int[] dist;
    List<List<Edge>> graph = new ArrayList<>();



    public static void main(String[] args) {
        Delivery delivery = new Delivery();
        int solution = delivery.solution(	5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3);
        System.out.println(solution);


    }


    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        dist = new int[N + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int len = road.length;

        for (int i = 0; i <= len; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < len; i++) {
            graph.get(road[i][0]).add(new Edge(road[i][1],road[i][2]));
            graph.get(road[i][1]).add(new Edge(road[i][0],road[i][2]));
        }

        deliStart(1);
        System.out.println(Arrays.toString(dist));
        for (int i = 1; i <= N; i++) {
            if(dist[i] <= K) answer++;
        }




        return answer;
    }

    void deliStart(int l) {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(l, 0));
        dist[l] = 0;
        while (!q.isEmpty()) {
            Edge nowEdge = q.poll();
            int now = nowEdge.vex;
            int nowCost = nowEdge.cost;
            if(nowCost > dist[now] ) continue;

            for (Edge edge : graph.get(now)) {
                if (dist[edge.vex] > nowCost + edge.cost) {
                    dist[edge.vex] = nowCost + edge.cost;
                    q.offer(new Edge(edge.vex,nowCost + edge.cost));
                }
            }
        }
    }



    static class Edge implements Comparable<Edge> {

        int vex;
        int cost;

        public Edge() {
        }

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

}
