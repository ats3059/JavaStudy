package Programmers;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i< arr.length;i++){
            arr[i] = sc.nextInt();
        }


        BinarySearchTest bt = new BinarySearchTest();
        bt.solution(n,m,arr);

    }
    int solution(int n, int m  ,int[] arr){
        int answer = 0;

        Arrays.sort(arr);
        int lt = 0 , rt = n;
        while(true){

            int mid = (lt+rt)/2;
            if(arr[mid] == m){
                answer = mid+1;
                break;
            }else if(arr[mid] > m){
                rt = mid-1;
            }else{
                lt = mid+1;
            }
        }




        return answer;

    }


}
