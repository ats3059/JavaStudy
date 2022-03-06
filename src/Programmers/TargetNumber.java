package Programmers;

public class TargetNumber {

    int[] numbers;
    int target;
    int answer = 0;

    public static void main(String[] args) {
        TargetNumber tn = new TargetNumber();
        System.out.println(tn.solution(new int[]{4,1,2,1},4));
    }

    int solution(int[] numbers , int target){
        this.numbers = numbers;
        this.target = target;

        dfs(0);
        return answer;
    }

    void dfs(int n){
        System.out.println(n);
        if(n == target){
            answer++;
            return;
        }else{
            if(n > -1 && n < numbers.length-1){
                if(numbers[n] + numbers[n+1] > target){
                    dfs(n+1);
                }

            }
        }

    }






}
