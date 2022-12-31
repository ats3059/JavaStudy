package lecture;

import java.util.Arrays;
import java.util.Scanner;

public class SortingTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        SortingTest1 st = new SortingTest1();
//        for(int i : st.selectSolution(n,arr)){
//            System.out.print(i + " ");
//        }
//        for (int i : st.bubbleSolution(n, arr)) {
//            System.out.print(i + " ");
//        }
        for(int i : st.insertSolution(n,arr)){
            System.out.print(i + " ");
        }

    }

    int[] selectSolution(int n, int[] arr) {

        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
//            System.out.println(idx);

            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;

        }
        return arr;
    }

    int[] bubbleSolution(int n, int[] arr) {

        int tmp = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    int[] insertSolution(int n , int[] arr){

        for(int i = 1; i < n; i++){
            int tmp = arr[i] , j;
            for(j = i-1; j >= 0;j--){
                if(arr[j] > tmp){
                    arr[j+1] = arr[j];
                }else break;
            }
            arr[j+1] = tmp;
        }


        return arr;
    }


}
