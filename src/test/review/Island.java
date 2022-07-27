package test.review;

import java.util.Scanner;

public class Island {

    static int arrSize;
    static int[][] landArr;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    static int dirSize = dir.length;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arrSize = sc.nextInt();

        landArr = new int[arrSize+1][arrSize+1];

        for (int i = 1; i <= arrSize; i++) {
            for (int j = 1; j <= arrSize; j++) {
                landArr[i][j] = sc.nextInt();
            }
        }
        findIsland();
        System.out.println(answer);

    }

    static void findIsland() {
        for (int i = 1; i <= arrSize; i++) {
            for (int j = 1; j <= arrSize; j++) {
                if(landArr[i][j] == 1){
                    landArr[i][j] = 0;
                    answer++;
                    dfs(i,j);
                }
            }
        }
    }

    static void dfs(int x, int y) {
        for (int i = 0; i < dirSize; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX > 0 && nextY > 0 && nextX <= arrSize && nextY <= arrSize && landArr[nextX][nextY] == 1) {
                landArr[nextX][nextY] = 0;
                dfs(nextX, nextY);
            }
        }
    }

}
