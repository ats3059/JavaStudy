package Programmers;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;
import java.util.Scanner;

public class Maze {
    int answer = 0;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[7][7];

        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                arr[i][j] = sc.nextInt();
            }
        }


        Maze maze = new Maze();
        maze.dfs(0,0);

    }

    void dfs(int n , int m){
        if(n == 6 && m == 6){
            answer++;
            System.out.println("answer = " + answer);
            return;
        } else{
            System.out.println("n = " + n  + " m = " + m);
            if(hasPlMove(m)) if(arr[n][m+1] == 0) dfs(n,m+1);
            if(hasPlMove(n)) if(arr[n+1][m] == 0) dfs(n+1,m);
            if(hasMinMove(m)) if(arr[n][m-1] == 0) dfs(n,m-1);
            if(hasMinMove(n)) if(arr[n-1][m] == 0) dfs(n-1,m);
        }


    }
    boolean hasPlMove(int x){
        if(x+1 > 6) return false;
        return true;
    }
    boolean hasMinMove(int x){
        if(x-1 < 0) return false;
            return true;
    }





}
