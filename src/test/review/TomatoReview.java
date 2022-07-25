package test.review;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TomatoReview {

    static int[][] tmtBox;
    static int answer = 0;
    static int tmtX;
    static int tmtY;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int empty = 0;
    static int perfect = 0;
    static Queue<TomatoDir> q = new LinkedList<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        tmtY = sc.nextInt();
        tmtX = sc.nextInt();

        tmtBox = new int[tmtX + 1][tmtY + 1];

        for (int i = 1; i <= tmtX; i++) {
            for (int j = 1; j <= tmtY; j++) {
                tmtBox[i][j] = sc.nextInt();
                int number = tmtBox[i][j];
                if(number == 1) q.offer(new TomatoDir(i,j));
                if(number == 0) empty += 1;
            }
        }

        valid();
        bfs();
        valid2();
    }

    private static void valid2() {
        if(empty == perfect){
            System.out.println(answer-1);
        }else{
            System.out.println(-1);
        }
    }

    private static void valid() {
        if(empty == 0) {
            System.out.println(0);
            return;
        }
        if(q.isEmpty()) {
            System.out.println(-1);
            return;
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TomatoDir tomato = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = tomato.x + dir[j][0];
                    int ny = tomato.y + dir[j][1];
                    if(nx > 0 && ny > 0 && nx <= tmtX && ny <= tmtY && tmtBox[nx][ny] == 0){
                        tmtBox[nx][ny] = 1;
                        q.offer(new TomatoDir(nx,ny));
                        perfect+=1;
                    }
                }
            }
            answer++;
        }
    }

    static class TomatoDir{
        public TomatoDir(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
    }
}
