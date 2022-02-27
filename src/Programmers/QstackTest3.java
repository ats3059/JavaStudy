package Programmers;


import java.util.Scanner;
import java.util.Stack;

public class QstackTest3 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        int m = kb.nextInt();
        int[] buc = new int[m];

        for (int j = 0; j < m; j++) {
            buc[j] = kb.nextInt();
        }


        QstackTest3 qt = new QstackTest3();
        System.out.println(qt.solution(n,arr,m,buc));



    }

    int solution(int n, int[][] arr, int m, int[] buc) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int cnt = 0;
        for (int k = 0; k < m; k++) {
            for (int j = 1; j <= n; j++) {
                if(arr[j][buc[k]] != 0){
                    if(stack.peek() == arr[j][buc[k]]) {
                        cnt+=2;
                        stack.pop();
                    }
                    else stack.push(arr[j][buc[k]]);

                    arr[j][buc[k]] = 0;
                    break;
                }
            }
        }


        return cnt;

    }

}
