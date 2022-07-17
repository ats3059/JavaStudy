package test.review;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class GraphFindBfs {

    static int nodeNum;
    static int info;
    static int[] chk;
    static int[][] graphArr;
    static List<List<Integer>> graphList;

    static int[] dist;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 풀이 1.
        /* 2차원 배열로 그래프를 구성 후 풀었던 문제
            nodeNum = sc.nextInt();
            info = sc.nextInt();
            graphArr = new int[nodeNum + 1][nodeNum + 1];
            chk = new int[nodeNum + 1];

            for (int i = 0; i < info; i++) {
                graphArr[sc.nextInt()][sc.nextInt()] = 1;
            }

            chk[1] = 1;
            new GraphFindBfs().bfs();

         */
        //풀이 2. List 를 이용하여 그래프 구성 후 풀었던 문제.
        nodeNum = sc.nextInt();
        info = sc.nextInt();

        // 한 번 방문한 노드는 다시는 방문하지 않기 위해서 사용하는 체크배열
        chk = new int[nodeNum + 1];
        // 거리를 구하기 위한 배열
        dist = new int[nodeNum + 1];
        graphList = new ArrayList<>();

        for (int i = 0; i <= nodeNum; i++) {
            graphList.add(new ArrayList<>());
        }

        for (int i = 0; i < info; i++) {
            graphList.get(sc.nextInt()).add(sc.nextInt());
        }

        new GraphFindBfs().bfs(1);
        printArr(dist);


    }

    //1 번풀이 bfs
     void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                for (int j = 1; j <= nodeNum; j++) {
                    if (graphArr[node][j] == 1 && chk[j] == 0) {
                        q.offer(j);
                        isShort(j, level);
                    }
                }
            }
            level++;
        }
    }

    void isShort(int node,int level) {
        if (chk[node] > level || chk[node] == 0) {
            chk[node] = level;
        }
    }
    //

    static void printArr(int[] arr) {
        for (int j = 2; j <= nodeNum; j++) {
            System.out.println(String.format("%d : %d" , j , arr[j]));
        }
    }

    // 2번 풀이 bfs
    void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        chk[node] = 1;
        q.offer(node);
        while (!q.isEmpty()) {
            Integer num = q.poll();
            List<Integer> list = graphList.get(num);
            for (Integer inNode : list) {
                if (chk[inNode] == 0) {
                    chk[inNode] = 1;
                    dist[inNode] = dist[num] + 1;
                    q.offer(inNode);
                }
            }
        }
    }




}
