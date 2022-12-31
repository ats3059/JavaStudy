package lecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QstackTest7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        String m = sc.next();

        QstackTest7 qst = new QstackTest7();
        System.out.println(qst.solution(n,m));
    }
    String solution(String n ,String m){
        Queue<Character> q = new LinkedList<>();
        String answer = "YES";

        for(int i = 0; i < n.length(); i++){
            q.offer(n.charAt(i));
        }

        char c = q.poll();
        int cnt = 0;

        for(int i = 0; i < m.length();i++){
            if(c == m.charAt(i)) cnt++;
            if(cnt > 0){
                if(q.contains(m.charAt(i))){
                    if(m.charAt(i) != q.poll()) {
                        answer = "NO";
                        break;
                    }
                }
            }
        }

        if(q.size() > 0) answer = "NO";


        return answer;
    }
}
