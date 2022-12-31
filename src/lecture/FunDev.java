package lecture;

import java.util.*;

public class FunDev {
    public static void main(String[] args) {
        FunDev fd = new FunDev();

        fd.solution(new int[]{97, 98, 95, 94, 96},new int[]{1, 1, 1, 1, 1});
    }
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = null;
        int inCnt = 0;
        int outCnt = 0;
        int idx = 0;
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < progresses.length;i++){

            if(progresses[i] + speeds[i] >= 100 || progresses[i] + (speeds[i] * inCnt) >= 100){
                outCnt++;
                map.put(idx,outCnt);
                continue;
            }else{
                outCnt = 0;

                progresses[i] = progresses[i] + (speeds[i] * inCnt);


                while(progresses[i] < 100){
                    progresses[i] += speeds[i];
                    inCnt++;
                }

                idx++;
                outCnt++;
                map.put(idx,outCnt);
            }

        }
        answer = new int[map.size()];
        idx = 0;
        for(Integer x : map.keySet()){
            answer[idx++] = map.get(x);
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }


}