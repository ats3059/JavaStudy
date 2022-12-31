package algo;


import java.util.Scanner;
import java.util.Stack;

public class QstackTest5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        QstackTest5 qst = new QstackTest5();
        System.out.println(qst.solution(str));

    }

    int solution(String str) {
        Stack<Character> stack = new Stack<>();
        int len = str.length();
        int answer = 0;
        for (int i = 0; i < len; i++) {
            char c =  str.charAt(i);
            if(c == '(') stack.push(c);
            else{
                stack.pop();
                if(str.charAt(i-1) == '(') {
                    answer += stack.size();
                }else{
                    answer += 1;
                }
            }
        }

//        System.out.println(answer);

        return answer;
    }
}
