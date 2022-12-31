package lecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QstackTest6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        QstackTest6 qst = new QstackTest6();
        System.out.println(qst.solution(n,m));
    }
    int solution(int n ,int m){
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;

        for(int i = 1 ; i <= n; i++){
            q.offer(i);
        }

        while(q.size() > 1){
            cnt++;
            if(cnt == m){
                cnt = 0;
                q.poll();
            }else{
                q.offer(q.poll());
            }
        }

        return q.poll();
    }
}
