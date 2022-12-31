package algo;

import java.util.*;

public class ShortPath {
    static List<List<Integer>> list;
    static int[] nodeArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i <= m; i++) {
            list.get(sc.nextInt()).add(sc.nextInt());
        }

        ShortPath sp = new ShortPath();
        nodeArr = new int[n + 1];
        sp.bfs(list, n);
        System.out.println(Arrays.toString(nodeArr));
    }

    void bfs(List<List<Integer>> list, int n) {

        Queue<Integer> q = new LinkedList<>();


        q.offer(1);

        while (!q.isEmpty()) {
            Integer idx = q.poll();
            for (Integer x : list.get(idx)) {
                if (nodeArr[x] == 0) {
                    System.out.println(x);
                    nodeArr[x] = nodeArr[idx] + 1;
                    q.offer(x);
                }
            }
        }
    }
}

