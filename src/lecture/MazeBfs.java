package algo;

import java.util.*;

public class MazeBfs {
    int answer = 0;
    static int[][] arr,dis;
    static int[] roadX;
    static int[] roadY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[8][8];
        dis = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        roadX = new int[]{-1, 0, 1, 0};
        roadY = new int[]{0, 1, 0, -1};
        arr[1][1] = 1;

        MazeBfs maze = new MazeBfs();


        maze.bfs(1, 1);
        if(dis[7][7] == 0) System.out.println(-1);
        else System.out.println(maze.answer);

    }
    int bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));

        while(!q.isEmpty()){
            int size = q.size();
            for(int j = 0; j < size; j++){
                Point po = q.poll();
                for(int i = 0 ; i < 4; i++){
                    int nx = po.x + roadX[i];
                    int ny = po.y + roadY[i];
                    if(nx == 7 && ny == 7) {
                        dis[nx][ny] = 1;
                        return answer = answer+1;
                    }
                    if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && arr[nx][ny] == 0){
                        arr[nx][ny] = 1;
                        q.offer(new Point(nx,ny));
                        dis[nx][ny] = 1;
                    }
                }
            }
            answer++;
        }


        return answer;
    }

}

class Point{
    int x;
    int y;
    Point(int x , int y){
        this.x = x;
        this.y = y;
    }
}







