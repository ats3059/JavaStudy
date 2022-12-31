package lecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindCow {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int me = sc.nextInt();
        int cow = sc.nextInt();

        FindCow fc = new FindCow();
        System.out.println(fc.find(me, cow));
    }

    int find(int me, int cow) {
        int answer = 0;
        int[] arr = new int[10001];
        Queue<Integer> q = new LinkedList<>();
        arr[me] = 1;
        q.offer(me);
        int[] stepArr = {1, -1, 5};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int j = 0; j < 3; j++) {
                    int step = stepArr[j] + cur;
                    if(step == cow) return answer+1;
                    if (step <= 10000 && step > -1) {
                        putQ(arr, q, step);
                    }
                }
            }
            answer++;
        }

        return answer;
    }

    private void putQ(int[] arr, Queue<Integer> q, int step) {
        if (arr[step] == 0) {
            arr[step] = 1;
            q.offer(step);
        }
    }


}
