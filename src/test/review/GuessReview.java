package test.review;

import java.util.Arrays;
import java.util.Scanner;

public class GuessReview {
    static int numCount;
    static int answer;
    static int[][] combiArr;
    static int[] tempArr;
    static int[] pascalArr;
    static int[] distArr;
    static boolean isTrue = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        numCount = sc.nextInt();
        answer = sc.nextInt();
        combiArr = new int[numCount][numCount];
        tempArr = new int[numCount];

        for (int i = 0; i < numCount; i++) {
            tempArr[i] = combiDfs(numCount-1, i);
        }
        distArr = new int[numCount+1];
        dfs(0, 0);
        String result = "FALSE";
        if(isTrue) result = "TRUE";
        System.out.println(Arrays.toString(tempArr));
        System.out.println(result);
    }

    static int combiDfs(int n,int r) {
        if(combiArr[n][r] > 0) return combiArr[n][r];
        if(n == r || r == 0) return 1;
        else {
            return combiArr[n][r] = combiDfs(n-1,r-1) + combiDfs(n-1,r);
        }
    }

    static void dfs(int l,int sum){
        if(isTrue) return;
        if(sum > answer) return;
        if(l == numCount) {
            if(sum == answer)  {
                isTrue = true;
            }
        }
        else{
            for (int i = 1; i <= numCount; i++) {
                if (distArr[i] == 0) {
                    distArr[i] = 1;
                    dfs(l + 1, sum + (i * tempArr[l]));
                    distArr[i] = 0;
                }
            }
        }


    }

}
