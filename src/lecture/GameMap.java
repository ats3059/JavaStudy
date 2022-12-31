package lecture;

import java.util.LinkedList;
import java.util.Queue;

public class GameMap {
    Queue<Direction> queue = new LinkedList<>();
    int[][] dirArr;
    int answer = 1;
    int n;
    int m;

    public static void main(String[] args) {
        GameMap gameMap = new GameMap();
        gameMap.solution(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        });
        System.out.println(gameMap.answer);
    }


    public int solution(int[][] maps) {

        n = maps.length-1;
        m = maps[0].length-1;
        System.out.println(n);
        System.out.println(m);
        dirArr = new int[][]{
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };

        shortDis(0, 0, maps);

        return answer;
    }

    public void shortDis(int x, int y, int[][] maps) {
        queue.offer(new Direction(x, y));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int j = 0; j < size; j++){
                Direction dir = queue.poll();
                for(int i = 0; i < 4; i++){
                    int nx = dir.x + dirArr[i][0];
                    int ny = dir.y + dirArr[i][1];
                    if(nx > n || ny > m) continue;
                    if(nx == n && ny == m){
                        answer+=1;
                        return;
                    }
                    if((nx >= 0 && ny >= 0) && maps[nx][ny] == 1){
                        maps[nx][ny] = 0;
                        queue.offer(new Direction(nx,ny));
                    }
                }
            }
            answer++;
        }

        answer = -1;
        return;
    }

    static class Direction {
        int x;
        int y;

        public Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}


