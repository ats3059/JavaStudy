package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WordConvert {
    String target;
    String[] words;
    int[] chk;
    public static void main(String[] args) {
        WordConvert wc = new WordConvert();

        System.out.println(wc.solution("hit","cog",new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));

    }

    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        this.chk = new int[words.length];
        int answer = 0;
        long cnt = Arrays.stream(words).filter(s -> s.equals(target)).count();
        if(cnt == 0) return 0;
        answer = bfs(begin);
        return answer;
    }

    int bfs(String word){
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(word);
        int l = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String me = q.poll();
                if(me.equals(target)) return l;
                for(int j = 0; j < words.length; j++){
                    if(chk[j]==0){
                        if(sucConvert(me,words[j])) {
                            chk[j]=1;
                            q.offer(words[j]);
                        }
                    }
                }
            }
            l++;
        }

        return answer;
    }

    boolean sucConvert(String me,String you){
        int cnt = 0;
        int len = me.length();

        for(int i = 0; i < len; i++){
            if(me.charAt(i) != you.charAt(i)) cnt++;
            if(cnt > 1) return false;
        }


        return true;
    }

}
