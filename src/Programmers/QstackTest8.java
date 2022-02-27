package Programmers;

import java.util.*;

public class QstackTest8 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        int m = kb.nextInt();
        int[] arr = new int[n];

        for (int j = 0; j < n; j++) {
            arr[j] = kb.nextInt();
        }
        QstackTest8 qst = new QstackTest8();
        System.out.println(qst.solution(n,m,arr));

    }

    int solution(int n , int m , int[] arr){
        int answer = 0;

        return answer;
    }
}
