package Programmers;

import java.util.Scanner;

public class TwoPointers3 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        TwoPointers3 tp = new TwoPointers3();
        System.out.println(tp.solution(n,m,arr));

    }

    public int solution(int n, int k, int[] arr){
        int sum = 0;

        for(int i = 0; i < k; i++){
            sum += arr[i];
        }
        int answer = sum;

        for(int i = k; i < n; i++){
            sum += arr[i];
            sum -= arr[i-k];
            answer = Math.max(answer,sum);
        }



        return answer;
    }
}
