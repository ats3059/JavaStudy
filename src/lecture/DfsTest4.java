package lecture;

import java.util.Scanner;

public class DfsTest4 {
    static int[][] combi;
    static int[] useCombi;
    static int[] arr;
    static int n;
    static int m;
    static int[] chk;
    boolean isTrue = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[n][n];
        useCombi = new int[n];
        arr = new int[n];
        chk = new int[n+1];

        DfsTest4 dt4 = new DfsTest4();

        for(int i = 0; i < n; i++){
            useCombi[i] = dt4.dfsCombi(n-1,i);
        }

        dt4.dfs(0,0);

    }

    int dfsCombi(int f , int b){
        if(combi[f][b]>0) return combi[f][b];
        if(f == b || b == 0) return 1;
        else return combi[f][b] = dfsCombi(f-1 , b-1) + dfsCombi(f-1,b);
    }

    void dfs(int l , int sum){
        if(isTrue) return;
        if(l == n){
            if(sum == m){
                isTrue = true;
                for(int i : arr){
                  System.out.print(i + " ");
                }
            }
        }else{
            for(int i = 0; i < n; i++){
                if(chk[i] == 0){
                    chk[i] = 1;
                    arr[l] = i+1;
                    dfs(l+1, sum + (arr[l] * useCombi[l]));
                    chk[i] = 0;
                }
            }
        }
    }



}
