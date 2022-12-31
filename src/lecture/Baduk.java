package algo;

import java.util.Scanner;

public class Baduk {
    static int max;
    static int[] arr;
    static int maximum = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        max = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[m];
        for(int i = 0; i < arr.length;i++){
            arr[i] = sc.nextInt();
        }
        Baduk ba = new Baduk();
        ba.dfs(0,0);
        System.out.println(maximum);
  
    }

    void dfs(int n,int sum){
        if(sum > max) return;
        if(n == arr.length){
            maximum = Math.max(maximum,sum);
            return;
        }else{
            dfs(n+1, arr[n]+sum);
            dfs(n+1, sum);
        }
    }



}
