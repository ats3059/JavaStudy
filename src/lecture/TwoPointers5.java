package lecture;

import java.util.Scanner;

public class TwoPointers5 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        TwoPointers5 tp = new TwoPointers5();
        System.out.println(tp.solution(n));
    }

    int solution(int n){
        int answer = 0;
        int len = n/2+1;
        int[] arr = new int[len];
        int lt = 0;
        int sum = 0;

        for(int i = 0; i < len; i++){
            arr[i] += i+1;
        }


        for(int rt = 0; rt < len; rt++){
            sum += arr[rt];
            if(sum == n){
                answer++;
                sum -= arr[lt++];
            }
            while(sum >= n){
                sum -= arr[lt++];
                if(sum == n){
                    answer++;
                }
            }
        }


        return answer;
    }

}
