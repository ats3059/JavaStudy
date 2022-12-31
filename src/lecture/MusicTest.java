package lecture;

import java.util.Arrays;
import java.util.Scanner;

public class MusicTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        MusicTest mt = new MusicTest();
        System.out.println(mt.solution(n,m,arr));
    }
    int solution(int n, int m ,int[] arr){
        int answer = 0;
        int sum = Arrays.stream(arr).sum();
        int max = Arrays.stream(arr).max().getAsInt();

        int lt = max;
        int rt = sum;

        while(lt <= rt){
            int mid = (lt+rt)/2;

            if(getCnt(mid,arr) >= m){
                lt = mid+1;
                answer = mid;
            }else{
                rt = mid-1;
            }
        }

        return answer;
    }

    int getCnt(int mid , int[] arr){
        int cnt = 0;
        int sum = 0;

        for(int i : arr){
            sum += i;
            if(sum >= mid){
                cnt++;
                sum = i;
            }

        }

        return cnt;
    }

}

