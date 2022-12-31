package algo;

import java.util.*;

public class TwoPointers2 {

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

        TwoPointers2 tp = new TwoPointers2();

        Arrays.sort(arr);
        Arrays.sort(arr2);

        tp.solution(n,m,arr,arr2);
    }

    List<Integer> solution(int n, int m , int[]arr , int[]arr2){
        List<Integer> list = new ArrayList<>();
        int p1 = 0 , p2  = 0;

        while(p1 < n && p2 < m){
            if(arr[p1] == arr2[p2]){
                list.add(arr2[p2++]);
                p1++;
            }else if(arr[p1] < arr2[p2]) p1++;
            else p2++;
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

        return list;
    }


}
