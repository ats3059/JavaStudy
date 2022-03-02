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
        int lt = arr[0];
        int rt = arr[n-1];

        while(lt <= rt){
            int mid = (lt+rt)/2;
            if(search(mid,arr)){
                answer = mid;
                break;
            }


        }



        return answer;
    }

    boolean search(int mid, int[] arr){
        boolean se = false;

        for(int i : arr){
            if(i == mid) {
                se = true;
                break;
            }
        }


        return se;
    }



}
