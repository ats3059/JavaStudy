package test.review;

import java.util.Scanner;

public class FindCombi {
    static int front;
    static int back;
    static int[] store;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        front = sc.nextInt();
        back = sc.nextInt();
        store = new int[back];
        dfs(0,1);
    }
    static void dfs(int l,int s) {
        if (l == back) {
            for (int i : store) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = s; i <= front; i++) {
                store[l] = i;
                dfs(l+1 , i+1);
            }
        }


    }

}
