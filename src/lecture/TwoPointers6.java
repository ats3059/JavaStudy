package lecture;

import java.util.Scanner;

public class TwoPointers6 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        TwoPointers6 tp = new TwoPointers6();
        System.out.println(tp.solution(n,m,arr));
        System.out.println(10/3);
    }

    int solution(int n , int m , int[] arr){
        int answer = 0;
        int cnt = 0;
        int lt = 0;

        for(int rt = 0; rt < n; rt++){
            if(arr[rt] == 0) cnt++;

            while(cnt > m){
                if(arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer,rt-lt+1);

        }
        return answer;
    }

//    int solution(int n , int m , int[] arr){
//        int answer = 0;
//        int cnt = 0;
//        int sum = 0;
//        int lt = 0;
//        for(int rt = 0; rt < n; rt++){
//            sum += arr[rt];
//            if(arr[rt] == 0){
//                cnt++;
//                sum += 1;
//                if(cnt == 1){
//                    lt = rt;
//                }
//                if(rt == n-1){
//                    cnt = n+1;
//                }
//               if(cnt > m){
//                    answer = Math.max(sum-1 , answer);
//                    sum = 0;
//                    cnt = 0;
//                    rt = lt;
//                }
//            }
//        }
//
//
//        return answer;
//    }
}
