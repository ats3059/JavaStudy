package lecture;

import java.util.*;
public class MoreHot {
    public static void main(String[] args) {
        System.out.println(new MoreHot().solution(new int[]{1, 2, 3, 9, 10, 12},7));
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i : scoville) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            Integer first = q.poll();
            if(first >= K) return answer;
            else if(q.size() == 0) return -1;
            Integer second = q.poll();
            Integer hap = first  + (second * 2);
            q.offer(hap);
            answer++;
        }
        return answer;
    }


}
