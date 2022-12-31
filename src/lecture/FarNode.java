package algo;

import java.util.*;

public class FarNode {
    List<List<Integer>> list;
    Set<Integer> set;
    int[] node;
    int[] cntNode;

    public static void main(String[] args) {
        FarNode fn = new FarNode();
        System.out.println(fn.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        this.list = new ArrayList<>();
        this.set = new HashSet<>();
        for (int i = 0; i <= edge.length; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        node = new int[n + 1];
        cntNode = new int[n+1];
        node[1] = 1;
        bfs(1);

        int max = Arrays.stream(cntNode).max().getAsInt();
        for(int i : cntNode){
            if(max == i) answer++;
        }

        return answer;
    }

    void bfs(int l) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(l);
        while (!q.isEmpty()) {
            int size = q.size();

            for (int j = 0; j < size; j++) {
                Integer x = q.poll();
                for (Integer i : list.get(x)) {
                    if (node[i] == 0) {
                        q.offer(i);
                        node[i] = 1;
                        cntNode[i] = l;
                    }
                }
            }

            l++;

        }
    }

}
