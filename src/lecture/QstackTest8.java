package algo;

import java.util.*;

public class QstackTest8 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        int m = kb.nextInt();
        int[] arr = new int[n];

        for (int j = 0; j < n; j++) {
            arr[j] = kb.nextInt();
        }
        QstackTest8 qst = new QstackTest8();
        System.out.println(qst.solution(n,m,arr));

    }

    int solution(int n , int m , int[] arr){
        int answer = 0;
        int target = arr[m];

        Queue<Person> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            q.offer(new Person(i,arr[i]));
        }

        while(!q.isEmpty()){
            Person tmp = q.poll();
            for(Person x : q){
                if(tmp.val < x.val) {
                    q.offer(tmp);
                    tmp = null;
                    break;
                }
            }

            if(tmp != null) {
                answer++;
                if(tmp.num == m && tmp.val == target) break;
            }

        }




        return answer;
    }
}


class Person{
    int num;
    int val;
    Person(int num , int val){
        this.num = num;
        this.val = val;
    }
}
