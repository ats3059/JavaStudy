package test.review;

import java.util.Scanner;

public class PermutationReview {

    static int numStock;
    static int numCount;
    static int[] numArr;
    static int[] succArr;
    static int[] validArr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        numStock = sc.nextInt();
        numCount = sc.nextInt();
        numArr = new int[numStock];
        for (int i = 0; i < numStock; i++) {
            numArr[i] = sc.nextInt();
        }
        validArr = new int[numStock];
        succArr = new int[numCount];
        dfs(0);

    }

    static void dfs(int l) {
        if (l == numCount) {
            for (int i : succArr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }else{
            for (int i = 0; i < numStock; i++) {
                if (validArr[i] == 0) {
                    validArr[i] = 1;
                    succArr[l] = numArr[i];
                    dfs(l+1);
                    validArr[i] = 0;
                }
            }
        }



    }



}
