package Programmers;

import java.util.*;

public class HashTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        HashTest3 ht = new HashTest3();
        ht.solution(n,m,arr);
    }

    List<Integer> solution(int n, int m , int[] arr){
        int lt = 0;
        int cnt  = 1;
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < m; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        list.add(map.size());
        System.out.print(list.get(0) + " ");

        for(int rt = m; rt < n; rt++){
            map.put(arr[lt],map.get(arr[lt])-1);
            if(map.get(arr[lt]) == 0){
                map.remove(arr[lt]);
            }
            map.put(arr[rt],map.getOrDefault(arr[rt],0)+1);
            list.add(map.size());
            lt++;
            System.out.print(list.get(cnt++) + " ");
        }

        return list;
    }


}
