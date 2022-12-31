package algo;

import java.util.Arrays;

public class BinarySearch2 {
    public static void main(String[] args) {
        long n = 6;
        int[] times = {7,10};
        long answer = 0;
        long lt = times[0];
        long rt = n * (long)Arrays.stream(times).max().getAsInt();
        long tmp = 0;
        while(lt <= rt){
            long mid = (lt+rt)/2;
            long ch = chkTime(mid,times);
            System.out.println("lt = " + lt + " rt = " + rt + " mid ="+ mid);

            if(ch < n){
                lt = mid+1;
                answer = mid;
            }else{
                rt = mid-1;
                tmp = mid;
            }

        }

        System.out.println(Math.min(answer,tmp));


    }

    static int chkTime(long mid , int[] arr){
        int cnt = 0;

        for(int i = 0; i< arr.length; i++){
            long sum = 0;
            while(sum <= mid){
                sum += arr[i];
                cnt++;
                if(sum + arr[i] >= mid) break;
            }
        }

        System.out.println(cnt);
        return cnt;
    }


}
