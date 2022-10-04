package Programmers;

import java.util.*;

public class Zip {
    Map<String, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    public int[] solution(String msg) {
        int[] answer = {};

        makeAlpUpper(map);
        makeZip(msg);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    private void makeZip(String str){
        int length = str.length();

        for (int i = 0; i < length; i++) {
            String word = str.substring(0,i+1);

            if(!map.containsKey(word)){
                map.put(word, map.size()+1);
                list.add(map.get(str.substring(0,i)));
                makeZip(str.substring(i));
                break;
            }else{
                if(i+1 == str.length()){
                    list.add(map.get(str.substring(0,i+1)));
                }
            }
        }
    }
    private void makeAlpUpper(Map<String, Integer> map) {
        char start = 'A';

        for (int i = 0; i < 26; i++) {
            char word = (char) (start+i);
            map.put(word+"" , word-64);
        }
    }
}
