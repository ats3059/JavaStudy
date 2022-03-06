package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RoadSearch {
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;
    static List<List<Integer>> list;

    public static void main(String[] args) {
        RoadSearch T = new RoadSearch();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            list.get(kb.nextInt()).add(kb.nextInt());
        }


//        graph=new int[n+1][n+1];
        ch=new int[n+1];
//        for(int i=0; i<m; i++){
//            int a=kb.nextInt();
//            int b=kb.nextInt();
//            graph[a][b]=1;
//        }
        ch[1]=1;
//        T.DFS(1);
        T.DFS2(1);
        System.out.println(answer);
    }

    public void DFS2(int v) {
        if (n == v) answer++;
        else {
            for(int vc : list.get(v)){
                if(ch[vc] == 0){
                    ch[vc] = 1;
                    DFS2(vc);
                    ch[vc] = 0;
                }
            }
        }
    }


    public void DFS(int v) {
        if (v == n) answer++;
        else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }

}




