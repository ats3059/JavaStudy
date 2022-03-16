package Programmers;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;
import java.util.Scanner;

public class DfsTest6 {
    static int[][] arr;
    static int[] a;
    static int[] b;
    static int answer = 0;
    static int st;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        st = sc.nextInt();
        arr = new int[st + 1][st + 1];
        for (int i = 1; i <= st; i++) {
            for (int j = 1; j <= st; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        a = new int[]{1, -1, 0, 0, -1, -1, 1, 1};
        b = new int[]{0, 0, 1, -1, -1, 1, 1, -1};
        new DfsTest6().findIsland();
        System.out.println(answer);

    }

    void findIsland() {
        for (int i = 1; i <= st; i++) {
            for (int j = 1; j <= st; j++) {
                if (arr[i][j] == 1) {
                    answer++;
                    arr[i][j] = 0;
                    dfs(i, j);
                }
            }
        }
    }

    void dfs(int n, int m) {
        for (int i = 0; i < 8; i++) {
            int curA = n + a[i];
            int curB = m + b[i];
            if (curA >= 1 && curA <= st && curB >= 1 && curB <= st && arr[curA][curB] == 1) {
                arr[curA][curB] = 0;
                dfs(curA, curB);
            }
        }
    }


}
