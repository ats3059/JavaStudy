package Programmers;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConvertBfs6 {
    static int[][] arr;
    static int[] a;
    static int[] b;
    static int answer = 0;
    static int st;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        st = sc.nextInt();
        arr = new int[st + 1][st + 1];
        for (int i = 1; i <= st; i++) {
            for (int j = 1; j <= st; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        a = new int[]{1, -1, 0, 0, -1, -1, 1, 1};
        b = new int[]{0, 0, 1, -1, -1, 1, 1, -1};
        new ConvertBfs6().findIsland();
        System.out.println(answer);

    }

    void findIsland() {
        for (int i = 1; i <= st; i++) {
            for (int j = 1; j <= st; j++) {
                if (arr[i][j] == 1) {
                    answer++;
                    arr[i][j] = 0;
                    bfs(i,j);
                }
            }
        }
    }

    void bfs(int n, int m) {
        Queue<IslandDir> q = new LinkedList<>();
        q.offer(new IslandDir(n,m));

        while(!q.isEmpty()){
            int size = q.size();
            for(int x = 0; x < size; x++){
                IslandDir id = q.poll();
                for (int i = 0; i < 8; i++) {
                    int curA = id.x + a[i];
                    int curB = id.y + b[i];
                    if (curA >= 1 && curA <= st && curB >= 1 && curB <= st && arr[curA][curB] == 1) {
                        arr[curA][curB] = 0;
                        q.offer(new IslandDir(curA,curB));
                    }
                }
            }
        }
    }


}

class IslandDir{
    int x;
    int y;
    IslandDir(int x , int y){
        this.x = x;
        this.y = y;
    }
}
