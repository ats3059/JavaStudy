package Programmers;

import java.util.Arrays;

public class ArrayTest2 {
    public static void main(String[] args) {
        ArrayTest2 at = new ArrayTest2();
//        at.solution(7);
//        at.solution2(10);
        at.solution3(10);

    }



    int solution2(int pr){
        int[] ints = new int[pr];
        ints[0] = 1; ints[1]=1;
        for(int i = 2; i < ints.length; i++){
            ints[i] = ints[i-1] + ints[i-2];
        }
        System.out.println(Arrays.toString(ints));

        return 0;
    }

    int solution(int pr){
        int answer = 1;
        int temp = 1;
        for(int i = 2; i< pr; i++){
                answer = temp + answer;
                temp = answer - temp;
        }
        System.out.println(answer);


        return 0;
    }

    int solution3(int pr){
        int a = 1 , b = 1 , c = 0;
        for(int i = 2; i< pr; i++){
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println(c);


        return 0;
    }

}
