package lecture;

import java.util.Scanner;

public class Maze {
    int answer = 0;
    static int[][] arr;
    static int[] roadX;
    static int[] roadY;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[8][8];

        for(int i = 1; i <= 7; i++){
            for(int j = 1; j <= 7; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        roadX = new int[]{-1, 0, 1, 0};
        roadY = new int[]{0,1,0,-1};
        arr[1][1] = 1;

        Maze maze = new Maze();
        maze.dfs(1,1);
        System.out.println(maze.answer);

    }

    void dfs(int n , int m){
        if(n == 7 && m == 7){
            answer++;
        } else{
            for(int i = 0 ; i < 4; i++){
                int nx = n + roadX[i];
                int ny = m + roadY[i];
                if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && arr[nx][ny] == 0){
                    arr[nx][ny] = 1;
                    dfs(nx,ny);
                    arr[nx][ny] = 0;
                }
            }
        }


    }






}
