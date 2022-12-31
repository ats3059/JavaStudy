package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoPointers {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        int m = kb.nextInt();
        int[] arr2 = new int[m];

        for(int j = 0; j < m; j++) {
            arr2[j] = kb.nextInt();
        }

        TwoPointers tp = new TwoPointers();
        tp.solution(n,m,arr,arr2);
    }
    List<Integer> solution(int n , int m , int[] arr , int[] arr2){
        List<Integer> list = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        if(n < m){
            while(p1 < n){
                if(arr[p1] < arr2[p2]){
                    list.add(arr[p1]);
                    p1++;
                }else{
                    list.add(arr2[p2]);
                    p2++;
                }
            }
            for(int i = p2; i < arr2.length;i++) list.add(arr2[i]);
        }else{
            while(p2 < m){
                if(arr[p1] < arr2[p2]){
                    list.add(arr[p1]);
                    p1++;
                }else{
                    list.add(arr2[p2]);
                    p2++;
                }
            }
            for(int i = p2; i < arr.length;i++) list.add(arr[i]);
        }

        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }


        return list;
    }


}
