package lecture;

import java.util.Scanner;
import java.util.Stack;


public class QstackTest2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        QstackTest2 qst = new QstackTest2();
        qst.solution(str);
    }

    String solution(String str) {
        String answer = "";

        Stack<Character> st = new Stack<>();

        for (int i = 0 ; i < str.length(); i++) {
            if(str.charAt(i) == ')'){
                while(st.pop()!='(');
            }else{
                st.push(str.charAt(i));
            }
        }
        for(char c : st){
            System.out.print(c);
        }

        return answer;
    }


}
