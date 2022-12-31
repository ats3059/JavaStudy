package lecture;

import java.util.Scanner;

public class DfsTest3 {
    static int[][] arr;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n + 1][m + 1];
        DfsTest3 dt = new DfsTest3();
        System.out.println(dt.dfs(n, m));

    }

    int dfs(int f, int b) {
        if(arr[f][b] > 0) return arr[f][b];
        if (f == b || b == 0) return 1;
        else return arr[f][b] = dfs(f - 1, b - 1) + dfs(f-1, b);
    }

//    public int dfs(int n, int r){
//        if(dy[n][r]>0) return dy[n][r];
//        if(n==r || r==0) return 1;
//        else return dy[n][r]=dfs(n-1, r-1)+dfs(n-1, r);
//    }



}
