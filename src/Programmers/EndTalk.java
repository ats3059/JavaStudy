package Programmers;

import java.util.ArrayList;
import java.util.List;

public class EndTalk {
    public static void main(String[] args) {
        EndTalk et = new EndTalk();
        int[] solution = et.solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"});
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<>();
        int point = 0;
        int round = 1;
        int length = words.length;

        //일단 처음에는 넘어가야하니까 초기화
        char prev = words[0].charAt(0);

        while(point < length){
            for(int i = 0; i < n; i++){
                String word = words[point];

                if(list.contains(word)){
                    answer[0] = i+1;
                    answer[1] = round;
                    System.out.println("up "  + word);
                    return answer;
                }

                char cur = word.charAt(0);

                if(cur != prev) {
                    answer[0] = i+1;
                    answer[1] = round;
                    System.out.println("down " + word);
                    return answer;
                }

                list.add(word);
                prev = word.charAt(word.length()-1);
                point++;
            }
            //몇번째인지
            round++;
        }

        answer[0] = 0;
        answer[1] = 1;
        return answer;
    }



}


