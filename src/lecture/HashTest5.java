package lecture;

import java.util.*;

public class HashTest5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        HashTest5 ht = new HashTest5();
        ht.solution(n,m,arr);
    }

    int solution(int n , int m , int[] arr){
        TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());
        int answer = 0;

        for(int i = 0; i < n;i++){
            for(int j = i+1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    ts.add(arr[i]+arr[j]+arr[k]);
                }
            }
        }

        Iterator iter = ts.iterator();
        int cnt = 0;

        while(iter.hasNext()){
            Object in = iter.next();
            cnt++;
            if(cnt == m) System.out.println(in);
        }


        return answer;
    }


}
