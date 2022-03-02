package Programmers;

import java.util.Scanner;

public class MusicTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int sum = 0;
        int[] arr = new int[n];
        int max = 0;

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            max = Math.max(max,arr[i]);
            sum += arr[i];
        }

        MusicTest mt = new MusicTest();
        System.out.println(mt.solution(n,m,arr,sum,max));

    }
    int solution(int n , int m , int[] arr, int sum,int max){
        int answer = 0;
        int lt = max;
        int rt = sum;

        while(lt <= rt){
            int mid = (lt+rt)/2;
            if(isPoss(mid,arr) <= m) {
                rt = mid-1;
                answer = mid;
            }else if(isPoss(mid,arr) > m){
                lt = mid + 1;
            }
        }

        return answer;
    }

    int isPoss(int mid , int[] arr){
        int cnt = 1;
        int tmp = 0;
        for(int i : arr){
            if(tmp+i > mid){
                cnt++;
                tmp = i;
            }else tmp+=i;

        }
        return cnt;
    }

}
