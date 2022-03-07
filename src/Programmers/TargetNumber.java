package Programmers;

public class TargetNumber {

    int[] numbers;
    int target;
    int answer = 0;
    public static void main(String[] args) {
        TargetNumber tn = new TargetNumber();
        System.out.println(tn.solution(new int[]{4,1,2,1},2));
    }

    int solution(int[] numbers , int target){
        this.numbers = numbers;
        this.target = target;
        dfs(0,0);
        return answer;
    }

    void dfs(int n, int val){
        if(n == numbers.length) {
            if(val == target) answer++;
            return;
        }else{
            dfs(n+1,val + numbers[n]);
            dfs(n+1,val - numbers[n]);
        }
    }






}
