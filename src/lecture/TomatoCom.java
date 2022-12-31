package lecture;

import java.util.*;

public class TomatoCom {
    static int[][] tmt;
    static int[] tx;
    static int[] ty;
    static int answer;
    static int diffCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        tmt = new int[m + 1][n + 1];
        List<Direction> list = new ArrayList<>();
        int cnt = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                tmt[i][j] = sc.nextInt();
                if(tmt[i][j] == 0) cnt++;
                if (tmt[i][j] == 1) {
                    list.add(new Direction(i, j));
                }
            }
        }

        tx = new int[]{-1, 1, 0, 0};
        ty = new int[]{0, 0, -1, 1};

        TomatoCom tc = new TomatoCom();


        if (list.size() == n * m) System.out.println(0);
        else {
            tc.dfs(list, n, m);
            if(diffCnt == cnt) System.out.println(answer);
            else System.out.println(-1);
        }


    }



    int dfs(List<Direction> dirs, int n, int m) {
        Queue<Direction> q = new LinkedList<>();
        for (Direction dir : dirs) {
            q.offer(dir);
        }
        int l = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Direction dir = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = dir.x + tx[j];
                    int y = dir.y + ty[j];
                    if (x >= 1 && x <= m && y >= 1 && y <= n && tmt[x][y] == 0) {
                        diffCnt++;
                        tmt[x][y] = 1;
                        q.offer(new Direction(x, y));
                    }
                }
            }

            if (q.size() == 0) {
                return answer = l;
            }

            l++;
        }

        return 0;
    }


}

class Direction {
    int x;
    int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
