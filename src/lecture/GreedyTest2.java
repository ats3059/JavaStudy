package lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GreedyTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;

        int n = sc.nextInt();
        List<PeopleTime> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new PeopleTime(sc.nextInt(), 's'));
            list.add(new PeopleTime(sc.nextInt(), 'e'));
        }
        Collections.sort(list);
        int cnt = 0;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            char gubun = list.get(i).gubun;
            if(gubun == 's') cnt++;
            if(gubun == 'e') cnt--;
            answer = Math.max(cnt, answer);
        }
        System.out.println(answer);

    }

    static class PeopleTime implements Comparable<PeopleTime>{
        int time;
        char gubun;
        public PeopleTime(int time,char gubun) {
            this.time = time;
            this.gubun = gubun;
        }

        @Override
        public String toString() {
            return "PeopleTime{" +
                    "time=" + time +
                    ", gubun=" + gubun +
                    '}';
        }

        @Override
        public int compareTo(PeopleTime o) {
            if(this.time == o.time) return this.gubun - o.gubun;
            return this.time - o.time;
        }
    }
}
