package test.review;

import java.util.Scanner;

public class CombiReview {
    static int num;
    static int combi;
    static int result;
    static int[][] combiArr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        combi = sc.nextInt();
        combiArr = new int[num+1][combi+1];

        System.out.println(dfs(num, combi));
    }

    static int dfs(int n , int r) {
        if(combiArr[n][r] > 0) return combiArr[n][r];
        if( n == r ||r == 0) return 1;
        return combiArr[n][r] = dfs(n-1 , r-1) +  dfs(n-1,r);
    }
}
