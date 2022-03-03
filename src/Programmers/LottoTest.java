package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTest {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        int rank = 6;
        for(int i = 1; i <= 6; i++ , rank--) {
            map.put(rank, i);
        }

        int zeroCnt = 0;
        int cnt = 0;

        int[] lottos = {9,5,4,2,6,7};
        int[] win_nums = {31, 10, 45, 1, 6, 19};


        for(int i = 0; i < lottos.length; i++){
            for(int j = 0; j< win_nums.length; j++){
                if(lottos[i] == 0) {
                    zeroCnt++;
                    break;
                }
                if(lottos[i] == win_nums[j]){
                    cnt++;
                }
            }
        }

        int[] result = new int[2];

        result[0] = map.get(zeroCnt+cnt);
        if(cnt <= 1) result[1] = 6;
        else result[1] = map.get(cnt);


        System.out.println(Arrays.toString(result));


    }


}
