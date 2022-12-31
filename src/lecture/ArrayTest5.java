package lecture;

public class ArrayTest5 {
    public static void main(String[] args) {
        int sol = new ArrayTest5().solution(10,1 ,0, 1, 1, 1, 0, 0, 1, 1, 0);
        System.out.println(sol);
    }
    int solution(int len , int ... ints) {
        int suc = 0;
        int score = 0;
        for(int i = 0 ; i < len; i++){
            if(ints[i] != 0){
                suc++;
            }else{
                suc = 0;
            }
            score+=suc;
        }

        return score;
    }
}
