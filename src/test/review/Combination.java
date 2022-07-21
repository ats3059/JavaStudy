package test.review;

import java.util.Scanner;

public class Combination {

    static int some;
    static int max;
    static int[] pm;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        max = sc.nextInt();
        some = sc.nextInt();
        pm = new int[some];
        dfs(0);

    }

    static void dfs(int l) {
        if(l == some) {
            for (int i : pm) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        else{
            for (int i = 1; i <= max; i++) {
                pm[l] = i;
                dfs(l+1);
            }
        }
    }
}
