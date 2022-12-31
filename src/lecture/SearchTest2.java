package algo;

import java.util.Arrays;
import java.util.Scanner;

public class SearchTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        SearchTest2 st = new SearchTest2();
        st.solution(n,arr);

    }

    void solution(int n, int[] origin){
        int[] arr = Arrays.copyOf(origin,n);

        for(int i = 1; i < n; i++){
            int temp = arr[i];
            int j;
            for(j = i-1; j >= 0; j--){
                if(arr[j] > temp) {
                    arr[j+1] = arr[j];
                }else break;
            }
            arr[j+1] = temp;
        }

        for(int i = 0; i < n; i++){
            if(arr[i] != origin[i]) System.out.print(i+1 + " ");
        }





    }
}
