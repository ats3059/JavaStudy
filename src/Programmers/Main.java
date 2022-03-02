package Programmers;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        int input1 = in.nextInt();
//        int[][] intss = new int[input1][5];
//        for(int i = 0; i < input1; i++){
//            for(int j = 0; j < 5; j++){
//                intss[i][j] = in.nextInt();
//            }
//        }
//        Main t = new Main();
//        System.out.println(t.solution(input1,intss));

        int[] nums = {1, 2, 7, 6, 4};
        int len = nums.length;
        int cnt = 0;
        int answer = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j+1; k < len; k++) {
                    answer += nums[i] + nums[j] + nums[k];
                    if(isTrue(answer)) cnt++;
                    answer = 0;
                }
            }
        }

        System.out.println(cnt);


    }

    static boolean isTrue(int answer){
        boolean is = true;
        for (int k = 2; k < answer; k++) {
            if (answer % k == 0) {
                is = false;
                break;
            }
        }
        return is;
    }

    int solution(int len, int[][] ints) {
        int be = 0;
        int answer = 0;

        for (int i = 0; i < len; i++) {
            int cur = 0;
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < 5; k++) {
                    if (ints[i][k] == ints[j][k]) {
                        cur++;
                        break;
                    }
                }
            }

            if (cur > be) {
                be = cur;
                answer = i + 1;
            }

        }

        return answer;
    }


}