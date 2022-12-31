package algo;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pizza {
    static int n;
    static int m;
    static int[][] arr;
    static List<Direction> home;
    static List<Direction> pizza;
    static int answer = Integer.MAX_VALUE;
    static Direction[] combiPiz;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n + 1][n + 1];
        home = new ArrayList<>();
        pizza = new ArrayList<>();
        pizza.add(null);
        combiPiz = new Direction[n];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    home.add(new Direction(i, j));
                } else if (arr[i][j] == 2) {
                    pizza.add(new Direction(i, j));
                }
            }
        }

        combi(0, 1);
        System.out.println(answer);

    }

    private static void combi(int l , int s) {

        if (l == m) {
            int temp = 0;
            for (Direction hDir : home) {
                int min = Integer.MAX_VALUE;
                for (Direction pDir : combiPiz) {
                    if(pDir != null){
                        int homeDir = Math.abs(hDir.x - pDir.x);
                        int pizzaDir = Math.abs(hDir.y - pDir.y);
                        int dist = homeDir + pizzaDir;
                        min = Math.min(min, dist);
                    }
                }
                temp += min;
            }
            answer = Math.min(temp, answer);
        }else{
            for (int i = s; i <= pizza.size()-1; i++) {
                combiPiz[l] = pizza.get(i);
                combi(l + 1, i + 1);
            }
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
