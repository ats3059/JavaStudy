package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Wonder {
    static int[] fri;
    static List<Edge> list = new ArrayList<>();
    static int answer = 0;

    static void union(int ff, int fb , int cost) {
        int uff = find(ff);
        int ufb = find(fb);
        if (uff != ufb){
            fri[uff] = ufb;
            answer+= cost;
        }
    }

    static int find(int v) {
        if (fri[v] == v) return v;
        else return fri[v] = find(fri[v]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        fri = new int[n + 1];

        for (int i = 1; i <= n; i++) fri[i] = i;
        for (int i = 0; i < m; i++) {
            int ff = sc.nextInt();
            int fb = sc.nextInt();
            int cost = sc.nextInt();
            list.add(new Edge(ff, fb, cost));
        }
        Collections.sort(list);

        for (Edge edge : list) {
            union(edge.v1, edge.v2,edge.cost);
        }

        System.out.println(answer);


    }

    static class Edge implements Comparable<Edge>{
        int v1;
        int v2;
        int cost;
        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }

    }
}
