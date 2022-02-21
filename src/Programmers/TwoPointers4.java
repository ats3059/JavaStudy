package Programmers;

import java.util.Scanner;

public class TwoPointers4 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        TwoPointers4 tp = new TwoPointers4();
        System.out.println(tp.solution(n,m,arr));
    }

    public int solution(int n, int k, int[] arr){
        int answer = 0;

        int lt = 0;
        int rt = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){

            if(sum > k){
                sum -= arr[lt];
                lt++;
            }else if(sum < k){
                rt++;
                sum += arr[rt];
            }

            if(sum == k){
                answer++;
                sum-= arr[lt];
                lt++;
            }

        }


        return answer;
    }

}
