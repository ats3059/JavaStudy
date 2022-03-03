package Programmers;

import java.util.Arrays;
import java.util.Scanner;

public class HorseTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        HorseTest mt = new HorseTest();
        System.out.println(mt.solution(n,m,arr));

    }
    int solution(int n , int m , int[] arr){
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n-1];

        while(lt<= rt){
            int mid = (lt+rt)/2;

            if(search(mid,arr) >= m){
                lt = mid +1;
                answer = mid;
            }else if(search(mid,arr) < m){
                rt = mid -1;
            }

        }

        return answer;
    }

    int search(int mid, int[] arr){
        int cnt = 1;
        int tmp = 1;

        for(int i = 0; i < arr.length;i++){
            if(arr[i] - tmp >= mid){
                tmp = arr[i];
                cnt++;
            }
        }

        return cnt;
    }



}
