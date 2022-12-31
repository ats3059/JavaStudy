package algo;

import java.util.ArrayList;
import java.util.List;

public class BigNum {

    public static void main(String[] args) {
        BigNum bigNum = new BigNum();
//        bigNum.solution(6,new int[]{7,3,9,5,6,12});
//        bigNum.solution2(8,new int[]{130 ,135, 148, 140, 145, 150, 150, 153});
        bigNum.solution3(5,new int[]{2,3,3,1,3},new int[]{1,1,2,2,3});

    }

    List<Integer> solution(int len , int[] arr){
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[i-1]){
                list.add(arr[i]);
            }
        }
        System.out.println(list);

        return null;
    }

    void solution2(int len , int[] arr){
        int max = arr[0];
        int count = 1;
        for(int i = 1; i < len; i++){
            if(max < arr[i]){
                ++count;
                max = arr[i];
            }
        }
        System.out.println(count);
    }

    void solution3(int len, int[] a , int[] b){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < len ; i++){
            if(a[i] == b[i]) list.add("D");
            else if(a[i] == 1 && b[i] == 3) list.add("A");
            else if(a[i] == 3 && b[i] == 1) list.add("B");
            else if(a[i] > b[i]) list.add("A");
            else list.add("B");


        }
        System.out.println(list);

    }


}
