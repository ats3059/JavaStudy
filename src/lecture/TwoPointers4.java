package lecture;

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
        System.out.println(tp.solution(n, m, arr));
    }

    public int solution(int n, int k, int[] arr) {
        int answer = 0;

        int lt = 0;
        int sum = 0;

        for(int rt = 0;  rt < n; rt++){
            sum += arr[rt];
            if(sum == k) answer++;
            while(sum > k){
                sum -= arr[lt++];
                if(sum == k) {
                    answer++;
                    sum -= arr[lt++];
                }
            }
        }



        return answer;
    }

}
