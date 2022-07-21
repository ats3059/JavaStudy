package test.review;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CoinConverter {

    static int coinHap;
    static Integer[] coinStore;
    static int minCoin = Integer.MAX_VALUE;
    static int coinStock;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        coinStock = sc.nextInt();
        coinStore = new Integer[coinStock];
        for (int i = 0; i < coinStock; i++) {
            coinStore[i] = sc.nextInt();
        }
        Arrays.sort(coinStore,Comparator.reverseOrder());
        coinHap = sc.nextInt();

        dfs(0,0);

        System.out.println(minCoin);
    }

    static void dfs(int l,int total) {
        if(total > coinHap) return;
        if(total == coinHap) minCoin = Math.min(minCoin,l);
        if(minCoin < l) return;
        else{
            for (int i = 0; i < coinStock; i++) {
                dfs(l + 1, total + coinStore[i]);
            }
        }
    }
}
