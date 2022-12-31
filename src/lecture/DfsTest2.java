package lecture;

import java.util.Scanner;

public class DfsTest2 {
    static int[] arr;
    static int m;
    static int n;
    static int[] chk;
    static int[] pm;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        chk = new int[n];
        pm = new int[m];
        DfsTest2 dt2 = new DfsTest2();
        dt2.dfs(0);
    }

    void dfs(int l) {
        if (l == m) {
            System.out.println(pm[0] + " : " + pm[1]);
        } else {
            for (int i = 0; i < n; i++) {
                if(chk[i] == 0) {
                    chk[i] = 1;
                    pm[l] = arr[i];
                    dfs(l+1);
                    chk[i] = 0;
                }
            }
        }
    }

}

