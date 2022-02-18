package Programmers;

import java.util.Arrays;

public class ArrayTest3 {
    public static void main(String[] args) {
        int a = 20;
        int[] ints = new int[a+1];
        int answer = 0;
        for(int i = 2; i < ints.length; i++){
            if(ints[i] == 0){
                answer++;
                for(int j = i; j < ints.length; j=j+i){
                    ints[j] = 1;
                }
            }
        }
        System.out.println(answer);
    }
}
