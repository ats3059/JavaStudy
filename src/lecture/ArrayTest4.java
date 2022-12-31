package lecture;

import java.util.ArrayList;

public class ArrayTest4 {
    public static void main(String[] args) {
        ArrayTest4 ar = new ArrayTest4();
        ar.solution(9, 32 ,55, 62, 20, 250 ,370, 200, 30 ,100);



    }

    int[] solution(int len,int ... ints){
        ArrayList<Integer> answer = new ArrayList<>();
        int tmp = 0;
        int res = 0;
        int t = 1;
        for(int i = 0 ; i < len ; i++){
            tmp = ints[i];
            res = 0;
            while(tmp > 0){
                t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if(isSuc(res)) answer.add(res);
        }
        for(Integer i : answer){
            System.out.print(i + " ");
        }
        return null;
    }
    boolean isSuc(int is){
        if(is == 1) return false;
        for(int i = 2; i < is; i++){
            if(is%i == 0)return false;
        }
        return true;

    }

}
