package Programmers;

import java.util.Scanner;

public class 그냥만들어봄 {
    int[] chk;
    static int n;
    int[] memory;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        그냥만들어봄 그냥 = new 그냥만들어봄();
        n = sc.nextInt();
        그냥.chk = new int[n+1];
        그냥.memory = new int[n+1];
        그냥.dfs(0);

    }

    void dfs(int l) {
        if(l==n){
            for(int i : memory){
                if(i!=0) System.out.print(i + " ");
            }
            System.out.println();
        }
        else for(int i = 1; i <= n; i++){
            if(chk[i] == 0){
                chk[i] = 1;
                memory[l] = i;
                dfs(l+1);
                chk[i] = 0;
            }
        }
    }

}
