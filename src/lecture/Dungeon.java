package lecture;

public class Dungeon {

    static int size;
    static Go[] goArr;
    static int max = Integer.MIN_VALUE;
    static int[] permit;

    public static void main(String[] args) {
        new Dungeon().solution(80,new int[][]{{80,20},{50,40},{30,10}});
    }

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        size = dungeons.length;
        goArr = new Go[size];
        permit = new int[size];
        perSearch(0,k,dungeons);
        answer = max;
        System.out.println(answer);
        return answer;
    }

    void perSearch(int l ,int k,int[][] dungeons) {
        if(max == size) return;
        if(l == size){
            int tempMax = 0;
            for (int i = 0; i < size; i++) {
                Go temp = goArr[i];
                if(temp.abs <= k && temp.minus <= k){
                    k -= temp.minus;
                    tempMax++;
                }
            }
            max = Math.max(max,tempMax);
        }else{
            for (int i = 0; i < size; i++) {
                if(permit[i] == 0){
                    permit[i] = 1;
                    Go go = new Go(dungeons[i][0],dungeons[i][1]);
                    goArr[l] = go;
                    perSearch(l+1,k,dungeons);
                    permit[i] = 0;
                }
            }
        }

    }

    static class Go{
        public Go(int abs, int minus) {
            this.abs = abs;
            this.minus = minus;
        }
        int abs;
        int minus;
    }


}
