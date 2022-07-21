package test.review;

import java.util.Scanner;

public class MaxScore {

    static int maxTime;
    static int[][] taskArr;
    static int maxScore = 0;
    static int loop;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loop = sc.nextInt();
        maxTime = sc.nextInt();

        taskArr = new int[loop][2];

        for (int i = 0; i < loop; i++) {
            for (int j = 0; j < 2; j++) {
                taskArr[i][j] = sc.nextInt();
            }
        }
        dfs(0,0,0);
        System.out.println(maxScore);
    }

    static void dfs(int l , int score,int time) {
        if(time > maxTime) return;
        if(l == loop){
            if(maxScore < score) maxScore = score;
        }
        else{
                int curScore = score + taskArr[l][0];
                int curTime = time + taskArr[l][1];
                dfs(l+1, curScore , curTime);
                dfs(l+1, score , time);
        }
    }
}
