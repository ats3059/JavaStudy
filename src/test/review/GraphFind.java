package test.review;

import java.util.Arrays;
import java.util.Scanner;

public class GraphFind {
    static int someNode;
    static int hap;
    static int[] nodeArr;
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        someNode = sc.nextInt();
        nodeArr = new int[someNode+1];
        int graphSize = sc.nextInt();

        graph = new int[someNode+1][someNode+1];

        for (int i = 1; i <= graphSize; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
        }
        System.out.println(Arrays.deepToString(graph));
        nodeArr[1] = 1;
        dfs(1);

        System.out.println("hap = " + hap);
    }

    static void dfs(int node) {
        if(someNode == node){
            hap++;
            return;
        }else {
            for (int i = 1; i <= someNode; i++) {
                if(graph[node][i] == 1){
                    if(nodeArr[i] == 0){
                        nodeArr[i] = 1;
                        dfs(i);
                        nodeArr[i] = 0;
                    }
                }
            }
        }
    }


}
