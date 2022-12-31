package algo;

import java.util.*;

public class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String,List<String>> map = new HashMap<>();
        int size = clothes.length;

        for(int i = 0; i < size; i++){
            String name = clothes[i][0];
            String type = clothes[i][1];
            if(!map.containsKey(type)){
                List<String> list = new ArrayList<>();
                list.add(name);
                map.put(type,list);

            }else{
                map.get(type).add(name);
            }
        }



        for(String s : map.keySet()){
            int value = map.get(s).size();
            value++;
            if(answer == 0) answer = value;
            else answer *= value;
        }

        answer--;






        return answer;
    }
}
