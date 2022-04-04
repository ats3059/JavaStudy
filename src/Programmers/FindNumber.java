package Programmers;

import java.util.HashSet;
import java.util.Set;

public class FindNumber {
    int max;
    int len;
    int[] tempArr;
    int answer;
    Set<Integer> set = new HashSet();
    public static void main(String[] args) {
        FindNumber fn = new FindNumber();
        fn.solution("011");
    }

    public int solution(String numbers) {
        answer = 0;
        len = numbers.length();
        tempArr = new int[len];

        for(int i = 1; i <= len; i++){
            max = i;
            dfs(0,"",numbers);
        }
        return answer;
    }

    void dfs(int l ,String str,String numbers){
        if(l==max){
            int x = Integer.parseInt(str);
            if(!set.contains(x)) {
                set.add(x);
                if(findDecimal(x)){
                    System.out.println(x);
                    answer++;
                }
            }
        }else{
            for(int i = 0; i < numbers.length(); i++){
                if(tempArr[i] == 0){
                    tempArr[i] = 1;
                    dfs(l+1,str+numbers.charAt(i),numbers);
                    tempArr[i] = 0;
                }
            }
        }

    }

    boolean findDecimal(int num){
        if(num <= 1) return false;
        if(num == 2 || num == 3) return true;
        for(int i = 2; i < num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }


}
