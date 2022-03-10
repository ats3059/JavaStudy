package Programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CoinTrade {

    static Integer[] arr;
    static int min = Integer.MAX_VALUE;
    static int n;
    static int coin;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        coin = sc.nextInt();
        CoinTrade ct = new CoinTrade();
        ct.dfs(0,0);
        System.out.println(min);
    }

    void dfs(int cnt,int sum){
        if(cnt > min) return;
        if(sum > coin) return;
        if(sum == coin){
            min = Math.min(cnt,min);
        }else{
            for(int i = 0; i < n; i++){
                dfs(cnt+1,sum + arr[i]);
            }
        }
    }
}
