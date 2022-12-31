package lecture;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest6 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayTest6().solution(7,88 ,88 , 92,89 ,92 ,100, 76);
    }

    List<Integer> solution(int len , int ... ints){
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < len; i++){
            int myScore = ints[i];
            int myLevel = 1;
            for(int j = 0; j < len; j++){
                if(i==j) continue;

                if(myScore < ints[j])myLevel++;
            }
            list.add(myLevel);
        }
        for(Integer i : list){
            System.out.print(i + " ");
        }

        return null;
    }
}
