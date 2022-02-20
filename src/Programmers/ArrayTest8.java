package Programmers;

public class ArrayTest8 {
    public static void main(String[] args) {
        int len = 5;


        int[][] ints = {
                {5, 3 ,7 ,2, 3},
                {3, 7, 1, 6, 1},
                {7, 2, 5 ,3 ,4},
                {4 ,3 ,6 ,4 ,1},
                {8 ,7 ,3 ,5 ,2}
        };
        new ArrayTest8().solution(len,ints);





    }

    int solution(int len , int[][] ints){
        int count = 0;
        int[] dx = {-1, 0, 1,0};
        int[] dy = {0, 1, 0,-1};

        for(int i = 0 ; i < len; i++){
            for(int j = 0; j < len; j++){
                boolean is = true;
                for(int k = 0; k < dx.length; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx >= 0 && nx < len  && ny >= 0 && ny < len && ints[i][j] <= ints[nx][ny]){
                        is = false;
                        break;
                    }
                }
                if(is) count++;
            }
        }


        return count;
    }
}
