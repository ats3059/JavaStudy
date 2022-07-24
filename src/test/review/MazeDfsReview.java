package test.review;

import java.util.Scanner;

public class MazeDfsReview {
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
        maze[1][1] =1;
        dfs(1,1);
        System.out.println(answer);
    }

    static void dfs(int x, int y) {
        if(x == 7 && y == 7) {
            answer+=1;
            return;
        }
        else {
            for (int i = 0; i < dirSize; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx > 0 && ny > 0 && nx < mazeLen && ny < mazeLen && maze[nx][ny] == 0) {
                    maze[nx][ny] = 1;
                    dfs(nx,ny);
                    maze[nx][ny] = 0;
                }
            }
        }
    }




}
