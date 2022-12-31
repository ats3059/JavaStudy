package lecture;

import java.util.Scanner;

public class DfsTest1 {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[m];
        new DfsTest1().dfs(0,n,m);
    }

    void dfs(int l , int n,int m){
        if(l==m){
            System.out.println(arr[0] + " : " + arr[1]);
        }else{
            for(int i = 1; i <= n; i++){
                arr[l] = i;
                dfs(l+1,n,m);
            }
        }
    }

}
