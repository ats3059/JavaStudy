package lecture;

import java.util.Arrays;
import java.util.Scanner;

public class SearchTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        SearchTest1 st = new SearchTest1();
        System.out.println(st.solution(n,arr));
    }
    String solution(int n, int[] arr){
        String answer = "U";

        for(int i = 1 ; i < n; i++){
            int temp = arr[i];
            int j;
            for(j = i-1; j >= 0; j--){
                if(arr[j] > temp) {
                    arr[j+1] = arr[j];
                }else break;
            }
            arr[j+1] = temp;
        }
        System.out.println(Arrays.toString(arr));

        return answer;
    }

}
