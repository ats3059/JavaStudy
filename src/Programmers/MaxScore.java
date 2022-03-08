package Programmers;

import java.util.Arrays;
import java.util.Scanner;

public class MaxScore {
    static int time;
    static int[][] arr;
    static int issue;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        issue = sc.nextInt();
        time = sc.nextInt();
        arr = new int[issue][2];
        for(int i = 0; i < arr.length;i++){
            for(int j = 0; j < 2;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        MaxScore mx = new MaxScore();
        mx.dfs(0,0,0);
        System.out.println(answer);
    }

    void dfs(int idx , int curT , int sum){
        if(idx == issue) answer = Math.max(sum,answer);
        else{
            dfs(idx+1 , curT+arr[idx][1] , sum+arr[idx][0]);
            dfs(idx+1 , curT , sum);
        }



    }



}
