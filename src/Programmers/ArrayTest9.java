package Programmers;

import java.util.Arrays;

public class ArrayTest9 {

    public static void main(String[] args) {
        int len = 3;


//        int[][] ints= { {2 ,3, 1, 7, 3},
//                        {4, 1 ,9 ,6 ,8},
//                        {5, 5, 2, 4, 4},
//                        {6 ,5 ,2 ,6 ,7},
//                        {8 ,4 ,2 ,2 ,2}};
        int[][] ints = {{5 ,4 ,4 ,2 ,1},
                        {1 ,2, 3, 4, 5},
                        {1 ,2 ,3 ,7 ,8}};
        int answer = new ArrayTest9().solution(len,ints);
        System.out.println(answer);


    }

//    int solution(int len, int[][] ints){
//        int temp = 0;
//        int temp2 = 0;
//        int rank = 0;
//        for(int i = 0; i < len; i++){
//            for(int j = 0; j < len; j++){
//                for(int k = 0; k < len; k++) {
//                    if (i == k) continue;
//                    if (ints[i][j] == ints[k][j]) {
//                        temp += 1;
//                        break;
//                    }
//                }
//                rank = temp > temp2 ? i+1 : i;
//                temp2 = temp;
//                temp = 0;
//            }
//
//        }
//        return rank;
//    }

    int solution(int len, int[][] ints){
        int[] student = new int[len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                for(int k = 0; k < len; k++){
                    if(i==k) continue;
                    if(ints[i][j] == ints[k][j]) {
                        student[i]+=1;
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(student));
        int temp = 0;
        for(int i = 0 , j = i+1; j < student.length ;i++,j++){
            if(student[i] > student[j]){
                temp = i+1;
            }else if (student[i] < student[j]){
                temp = j+1;
            }
        }
        return temp;
    }
}
