package Programmers;

import java.util.*;

public class GreedyTest1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 1;
        int n = sc.nextInt();
        List<Time> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(new Time(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(list);

        int temp = list.get(0).end;
        for (int i = 1; i < n; i++) {
            if(list.get(i).start >= temp){
                answer++;
                temp = list.get(i).end;
            }
        }




        System.out.println(answer);




    }

    static class Time implements Comparable<Time>{
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if(this.end == o.end) return this.start - o.start;
            return this.end - o.end;
        }

    }

}
