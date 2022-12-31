package lecture;

import java.util.*;

public class Wonder2 {
    static List<List<Edge>> list = new ArrayList<>();
    static int chk[];
    static int dist[];
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        chk = new int[n + 1];
        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int prev = sc.nextInt();
            int next = sc.nextInt();
            int cost = sc.nextInt();
            list.get(prev).add(new Edge(next, cost));
            list.get(next).add(new Edge(prev, cost));
        }


        findDist(1, 0);
        System.out.println(answer);
        System.out.println(Arrays.toString(chk));


    }

    static void findDist(int x, int y) {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(x, y));
        while (!q.isEmpty()) {
            Edge cur = q.poll();
            int next = cur.next;

            if (chk[cur.next] == 0) {
                chk[cur.next] = 1;
                answer += cur.cost;
                for (Edge edge : list.get(next)) {
                    if(chk[edge.next] == 0) q.offer(new Edge(edge.next, edge.cost));
                }
            }


        }


    }


    static class Edge implements Comparable<Edge> {

        int next;
        int cost;

        public Edge(int next, int cost) {

            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    ", next=" + next +
                    ", cost=" + cost +
                    '}';
        }
    }


}
