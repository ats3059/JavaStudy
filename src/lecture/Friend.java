package algo;

import java.util.*;

public class Friend {

    static String answer = "NO";
    static int[] fri;

    static void union(int ff, int fb) {
        int uff = find(ff);
        int ufb = find(fb);
        if (uff != ufb) fri[uff] = ufb;
    }

    static int find(int v) {
        if (fri[v] == v) return v;
        else return find(fri[v]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        fri = new int[n + 1];
        for (int i = 1; i <= n; i++) fri[i] = i;
        for (int i = 0; i < m; i++) {
            int ff = sc.nextInt();
            int fb = sc.nextInt();
            union(ff, fb);
        }

        int ff = sc.nextInt();
        int fb = sc.nextInt();

        if (find(ff) == find(fb)) answer = "YES";
        System.out.println(answer);


    }


}