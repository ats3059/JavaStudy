package algo;

import java.util.Scanner;

public class DfsTest5 {
    static int[] chk;
    static int[] pm;
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        new DfsTest5().dfs(0,1);
    }

    void dfs(int l,int s){
        if(l == m) {
            System.out.println(pm[0] + " " + pm[1]);
        }else{
            for(int i = s;i <= n; i++){
                pm[l] = i;
                dfs(l+1,i+1);
            }
        }
    }

}
