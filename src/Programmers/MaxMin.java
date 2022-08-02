package Programmers;

import java.util.Arrays;

public class MaxMin {
    public static void main(String[] args) {
        new MaxMin().solution("-1 -2 -3 -4");
    }
    public String solution(String s) {
        String answer = "";
        String[] strArr = s.split(" ");
        int[] intArr = new int[strArr.length];

        for(int i = 0; i < strArr.length; i++){
            intArr[i] = Integer.valueOf(strArr[i]);
        }

        Arrays.sort(intArr);

        answer = String.format("%d %d" , intArr[0],intArr[intArr.length-1]);

        return answer;
    }
}
