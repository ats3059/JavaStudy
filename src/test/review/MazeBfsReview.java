package test.review;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MazeBfsReview {
    static int mazeLen = 8;
    static int[][] maze = new int[mazeLen][mazeLen];
    static int answer = 0;
    static int[][] dir = {{1,0} , {-1,0} , {0,1} , {0,-1}} ;
    static int dirSize = dir.length;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 1; i < mazeLen; i++){
            for(int j = 1; j < mazeLen; j++){
                maze[i][j] = sc.nextInt();
            }
        }
        bfs(1,1);
        System.out.println(answer);
    }

    static void bfs(int x , int y) {
        Queue<Direction> q = new LinkedList<>();
        q.offer(new Direction(x,y));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                Direction dirObj = q.poll();
                for (int i = 0; i < dirSize; i++) {
                    int nx = dirObj.x + dir[i][0];
                    int ny = dirObj.y + dir[i][1];
                    if(nx == 7 && ny == 7) {
                        answer+=1;
                        return;
                    }
                    if (nx > 0 && ny > 0 && nx < mazeLen && ny < mazeLen && maze[nx][ny] == 0) {
                        maze[nx][ny] = 1;
                        q.offer(new Direction(nx,ny));
                    }
                }
            }
            answer++;
        }

    }


    static class Direction{
        int x;
        int y;

        public Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
