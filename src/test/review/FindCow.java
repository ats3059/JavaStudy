package test.review;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindCow {
    static int[] dir = {1,-1,5};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int front = sc.nextInt();
        int back = sc.nextInt();

        int bfs = new FindCow().bfs(front, back);
        System.out.println(bfs);


    }

    public int bfs(int front , int back) {
        Queue<Integer> q = new LinkedList<>();
        int level = 0;
        int[] arr = new int[10001];
        arr[front] = 1;
        q.offer(front);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int some = q.poll();
                for (int j : dir) {
                    int hap = some + j;
                    if(hap == back) return level+1;
                    if (hap <= 10000 && hap > -1) putQ(arr,q,hap);
                }
            }
            level++;
        }

        return 0;
    }
    void putQ(int[] arr , Queue<Integer> q , int some) {
        if(arr[some] == 0){
            arr[some] = 1;
            q.offer(some);
        }
    }
}
