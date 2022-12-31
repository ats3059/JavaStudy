package algo;

import java.util.*;

public class Test {
    static int[] ha;
    static List<Vertex> list = new ArrayList<>();
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        ha = new int[n+1];

        for (int i = 1; i <= n; i++) ha[i] = i;
        for (int i = 0; i < m; i++) {
            Vertex v = new Vertex(sc.nextInt(),sc.nextInt(), sc.nextInt());
            list.add(v);
        }
        Collections.sort(list);


        for (int i = 0; i < m; i++) {
            Vertex v = list.get(i);
            Union(v.prevNode,v.node,v.cost);
        }

        System.out.println(answer);

    }
    public static void Union(int a, int b,int cost){
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb){
            ha[fa] = fb;
            answer += cost;
        }

    }

    public static int Find(int v) {
        if(ha[v] == v) return v;
        else return ha[v] = Find(ha[v]);
    }

    static class Vertex implements Comparable<Vertex>{
        int node;
        int cost;
        int prevNode;
        public Vertex(int prevNode,int node, int cost) {
            this.prevNode = prevNode;
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.cost - o.cost;
        }

    }
}
